package ing.boykiss.serversideadditions.mobpickup.item;

import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import ing.boykiss.serversideadditions.mobpickup.util.MobHeadData;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.storage.TagValueOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MobItemFactory {
    public static ItemStack createItemStack(Entity entity) {
        String texture = MobHeadData.getHeadTexture(entity);
        ResolvableProfile profile = createHeadProfile(texture);

        ItemStack itemStack = new ItemStack(Items.TRIAL_KEY);

        // Remove unnecessary default data
        itemStack.set(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY); // Needed for anvil renaming to work for some reason
        itemStack.remove(DataComponents.REPAIR_COST);
        itemStack.remove(DataComponents.ATTRIBUTE_MODIFIERS);
        itemStack.remove(DataComponents.TOOLTIP_DISPLAY);
        itemStack.remove(DataComponents.BREAK_SOUND);

        itemStack.set(DataComponents.ITEM_MODEL, ResourceLocation.withDefaultNamespace("player_head"));

        itemStack.set(DataComponents.RARITY, Rarity.UNCOMMON);
        itemStack.set(DataComponents.MAX_STACK_SIZE, 1);
        itemStack.set(DataComponents.PROFILE, profile);

        MutableComponent name = Component.empty();

        List<Component> lore = new ArrayList<>();

        if (entity instanceof Villager villager) {
            VillagerData villagerData = villager.getVillagerData();
            Brain<Villager> brain = villager.getBrain();
            MerchantOffers offers = villager.getOffers();
            boolean isBaby = villager.isBaby();
            boolean hasCustomName = villager.hasCustomName();

            Optional<ResourceKey<VillagerType>> optionalTypeKey = villagerData.type().unwrapKey();
            if (optionalTypeKey.isPresent()) {
                ResourceKey<VillagerType> villagerTypeResourceKey = optionalTypeKey.get();
                String optionalSnowAppend = villagerData.type().is(VillagerType.SNOW) ? "y_taiga" : "";
                name.append(Component.translatable("biome.minecraft." + villagerTypeResourceKey.location().getPath() + optionalSnowAppend).append(" "));
            }

            Optional<ResourceKey<VillagerProfession>> optionalProfessionKey = villagerData.profession().unwrapKey();
            if (optionalProfessionKey.isPresent() && !villagerData.profession().is(VillagerProfession.NONE)) {
                name.append(Component.translatable("entity.minecraft.villager." + optionalProfessionKey.get().location().getPath()).append(" "));
            }

            if (isBaby) name.append("Baby ");

            if (hasCustomName) {
                Component customName = villager.getCustomName();
                if (customName != null) {
                    lore.add(Component.literal("§r§7Custom Name: §f" + customName.getString()));
                    lore.add(Component.empty());
                }
            }

            // Health
            float health = villager.getHealth();
            BigDecimal roundedHealth = BigDecimal.valueOf(health).setScale(1, RoundingMode.UNNECESSARY);

            float maxHealth = villager.getMaxHealth();
            BigDecimal roundedMaxHealth = BigDecimal.valueOf(maxHealth).setScale(1, RoundingMode.UNNECESSARY);

            lore.add(Component.literal("§r§7Health: " + roundedHealth + "/" + roundedMaxHealth + " §c❤"));

            // Workstation
            Optional<GlobalPos> optionalWorkstation = brain.getMemory(MemoryModuleType.JOB_SITE);
            if (optionalWorkstation.isPresent()) {
                GlobalPos workstation = optionalWorkstation.get();
                String workstationDimension = Arrays.stream(workstation.dimension().location().getPath().split("_")).map((s) -> s.substring(0, 1).toUpperCase() + s.substring(1)).collect(Collectors.joining(" "));
                lore.add(Component.literal("§r§7Workstation: " + workstationDimension + " " + workstation.pos().toShortString()));
            } else {
                lore.add(Component.literal("§r§7Workstation: None"));
            }

            // Bed
            Optional<GlobalPos> optionalBed = brain.getMemory(MemoryModuleType.HOME);

            if (optionalBed.isPresent()) {
                GlobalPos bed = optionalBed.get();
                String bedDimension = Arrays.stream(bed.dimension().location().getPath().split("_")).map((s) -> s.substring(0, 1).toUpperCase() + s.substring(1)).collect(Collectors.joining(" "));
                lore.add(Component.literal("§r§7Bed: " + bedDimension + " " + bed.pos().toShortString()));
            } else {
                lore.add(Component.literal("§r§7Bed: None"));
            }

            // Trades
            if (!offers.isEmpty()) {
                lore.add(Component.empty());
                lore.add(Component.literal("§r§7Trades:"));
                offers.forEach((trade) -> {
                    ItemStack buy1 = trade.getCostA();
                    ItemStack buy2 = trade.getCostB();
                    ItemStack sell = trade.getResult();

                    int buy1Amount = buy1.getCount();
                    String buy1Name = buy1.getItemName().getString();

                    int buy2Amount = buy2.getCount();
                    String buy2Name = buy2.getItemName().getString();

                    int sellAmount = sell.getCount();
                    String sellName = sell.getItemName().getString(); // TODO: maybe add support for showing enchantments

                    if (buy2.isEmpty()) {
                        lore.add(Component.literal("  §r§7" + buy1Amount + "x " + buy1Name + " -> " + sellAmount + "x " + sellName));
                    } else {
                        lore.add(Component.literal("  §r§7" + buy1Amount + "x " + buy1Name + " + " + buy2Amount + "x " + buy2Name + " -> " + sellAmount + "x " + sellName));
                    }
                });
            }
        }

        name.append(Component.translatable(entity.getType().toString()));
        itemStack.set(DataComponents.ITEM_NAME, name);

        String entityTypeId = EntityType.getKey(entity.getType()).toString();

        if (!lore.isEmpty()) lore.add(Component.empty());
        lore.add(Component.literal("§r§8" + entityTypeId));
        itemStack.set(DataComponents.LORE, new ItemLore(lore));

        CompoundTag mobItemData = new CompoundTag();
        mobItemData.putBoolean("SSA_mobItem", true);
        mobItemData.putString("SSA_mobItem_entityType", entityTypeId);
        itemStack.set(DataComponents.CUSTOM_DATA, CustomData.of(mobItemData));

        entity.getPickResult();
        TagValueOutput entityData = TagValueOutput.createWithoutContext(ProblemReporter.DISCARDING);
        entity.save(entityData);
        itemStack.set(DataComponents.ENTITY_DATA, CustomData.of(entityData.buildResult()));

        return itemStack;
    }

    public static ResolvableProfile createHeadProfile(String texture) {
        PropertyMap properties = new PropertyMap();
        Property property = new Property("textures", texture);
        properties.put("", property);
        return new ResolvableProfile(Optional.empty(), Optional.empty(), properties);
    }
}
