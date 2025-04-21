package ing.boykiss.serversideadditions.mobpickup.event;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import ing.boykiss.serversideadditions.config.Config;
import ing.boykiss.serversideadditions.mobpickup.item.MobItemFactory;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public class MobPickupEvent implements InteractionEvent.InteractEntity {
    @Override
    public EventResult interact(Player player, Entity entity, InteractionHand interactionHand) {
        if (!Config.INSTANCE.getMobPickup().isEnabled()) return EventResult.pass();

        if (!player.isCrouching()) return EventResult.pass();
        List<String> allowedEntityTypeIds = Config.INSTANCE.getMobPickup().getAllowedEntityTypes();
        List<? extends EntityType<?>> allowedEntityTypes = allowedEntityTypeIds.stream()
                .map(EntityType::byString)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        if (!allowedEntityTypes.contains(entity.getType())) return EventResult.pass();

        ItemStack mobItem = MobItemFactory.createItemStack(entity);
        boolean success = player.addItem(mobItem);
        if (success) {
            entity.remove(Entity.RemovalReason.DISCARDED);
            return EventResult.interruptTrue();
        } else if (Config.INSTANCE.getMobPickup().isDropItemOnFullInventory()) {
            Level level = entity.level();
            ItemEntity itemEntity = new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), mobItem);

            boolean success2 = level.addFreshEntity(itemEntity);
            if (success2) {
                entity.remove(Entity.RemovalReason.DISCARDED);
                return EventResult.interruptTrue();
            } else {
                return EventResult.interruptFalse();
            }
        } else {
            return EventResult.interruptFalse();
        }
    }
}
