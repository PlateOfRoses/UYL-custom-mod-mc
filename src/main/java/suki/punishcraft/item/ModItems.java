package suki.punishcraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import suki.punishcraft.UYLPunishcraft;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UYLPunishcraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        UYLPunishcraft.LOGGER.info("Registering Mod Items for " + UYLPunishcraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }
}
