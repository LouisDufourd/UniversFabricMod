package fr.plaglefleau.univers.block;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.utils.Utils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",new ExperienceDroppingBlock(UniformIntProvider.create(0,0),FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",new ExperienceDroppingBlock(UniformIntProvider.create(0,0),FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(DyeColor.GRAY)));
    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(DyeColor.GRAY)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Univers.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Univers.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static void addItemsGroup() {
        Utils.addItemToGroup(ItemGroups.NATURAL, PLATINUM_ORE);
        Utils.addItemToGroup(ItemGroups.NATURAL, DEEPSLATE_PLATINUM_ORE);
        Utils.addItemToGroup(ItemGroups.NATURAL, RAW_PLATINUM_BLOCK);
        Utils.addItemToGroup(ItemGroups.BUILDING_BLOCKS, PLATINUM_BLOCK);
    }

    public static void registerModBlocks() {
        Univers.LOGGER.info("Registering ModBlocks for %s".formatted(Univers.MOD_ID));
        addItemsGroup();
    }
}
