package suki.punishcraft.block;

import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import suki.punishcraft.UYLPunishcraft;
import suki.punishcraft.effect.AdventureEffect;

import java.util.function.Supplier;

public class ModBlocks {
    public static final Block DEATH_BLOCK = registerBlockWithoutBlockItem("death_block", )


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(UYLPunishcraft.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(UYLPunishcraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(UYLPunishcraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
}
