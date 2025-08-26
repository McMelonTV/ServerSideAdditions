package ing.boykiss.serversideadditions.mobpickup.event;

import dev.architectury.event.events.common.InteractionEvent;
import ing.boykiss.serversideadditions.ServerSideAdditions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.ValueInput;

public class MobItemPlaceEvent implements InteractionEvent.RightClickBlock {
    @Override
    public InteractionResult click(Player player, InteractionHand interactionHand, BlockPos blockPos, Direction direction) {
        try (Level level = player.level()) {
            ItemStack itemStack = player.getItemInHand(interactionHand);

            if (!itemStack.is(Items.TRIAL_KEY)) return InteractionResult.PASS;

            CustomData customData = itemStack.get(DataComponents.CUSTOM_DATA);
            if (customData == null) return InteractionResult.PASS;

            CompoundTag mobItemData = customData.copyTag();
            if (mobItemData.getBoolean("SSA_mobItem").isEmpty() && !mobItemData.getBoolean("SSA_mobItem").get())
                return InteractionResult.PASS;
            if (mobItemData.getString("SSA_mobItem_entityType").isEmpty()) return InteractionResult.PASS;

            String entityTypeId = mobItemData.getString("SSA_mobItem_entityType").get();
            if (entityTypeId.isEmpty()) return InteractionResult.PASS;

            EntityType<?> entityType = EntityType.byString(entityTypeId).orElse(null);
            if (entityType == null) return InteractionResult.PASS;

            CustomData entityData = itemStack.get(DataComponents.ENTITY_DATA);
            if (entityData == null) return InteractionResult.PASS;

            CompoundTag entityTag = entityData.copyTag();
            ValueInput entityDataInput = TagValueInput.create(ProblemReporter.DISCARDING, level.registryAccess(), entityTag);

            Entity entity = entityType.create(level, EntitySpawnReason.BUCKET);
            if (entity == null) return InteractionResult.PASS;
            entity.load(entityDataInput);
            entity.setPos(blockPos.getX() + direction.getStepX() + 0.5, blockPos.getY() + direction.getStepY(), blockPos.getZ() + direction.getStepZ() + 0.5);
            if (itemStack.has(DataComponents.CUSTOM_NAME)) {
                Component customName = itemStack.get(DataComponents.CUSTOM_NAME);
                entity.setCustomName(customName);
            }
            level.addFreshEntity(entity);

            itemStack.setCount(itemStack.getCount() - 1);

            return InteractionResult.SUCCESS;
        } catch (Exception e) {
            ServerSideAdditions.LOGGER.error(e.getMessage());
            return InteractionResult.FAIL; // ???
        }
    }
}
