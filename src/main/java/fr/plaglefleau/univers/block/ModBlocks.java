package fr.plaglefleau.univers.block;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.utils.ItemGroupsUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {

    public static final Map<String, Pair<List<String>, Block>> UNIVERS_MOD_BLOCKS = new HashMap<>();

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Univers.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Univers.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static void addItemsGroup() {
        for (Map.Entry<String, Pair<List<String>, Block>> entry : UNIVERS_MOD_BLOCKS.entrySet()) {
            Pair<List<String>, Block> blockInfo = entry.getValue();
            ItemGroupsUtils.addItemInGroup(blockInfo.getLeft(), blockInfo.getRight());
        }
    }

    public static void registerModBlocks() {
        Univers.LOGGER.info("Registering ModBlocks for %s".formatted(Univers.MOD_ID));
        UNIVERS_MOD_BLOCKS.put(
                "platinum_ore",
                new Pair<>(
                        List.of("BUILDING_BLOCK"),
                        registerBlock(
                                "platinum_ore",
                                new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(DyeColor.GRAY))
                        )
                )
        );
    }
}
