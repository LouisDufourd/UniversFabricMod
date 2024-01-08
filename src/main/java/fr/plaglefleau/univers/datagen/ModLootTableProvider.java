package fr.plaglefleau.univers.datagen;

import fr.plaglefleau.univers.block.ModBlocks;
import fr.plaglefleau.univers.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //BLOCKS
        addDrop(ModBlocks.PLATINUM_BLOCK);
        addDrop(ModBlocks.RAW_PLATINUM_BLOCK);

        //ORES
        addDrop(ModBlocks.PLATINUM_ORE, oreDrops(ModBlocks.PLATINUM_ORE, ModItems.RAW_PLATINUM, UniformLootNumberProvider.create(1.0f, 5.0f)));
        addDrop(ModBlocks.DEEPSLATE_PLATINUM_ORE, oreDrops(ModBlocks.DEEPSLATE_PLATINUM_ORE, ModItems.RAW_PLATINUM, UniformLootNumberProvider.create(1.0f, 5.0f)));
    }

    public LootTable.Builder oreDrops(Block silkTouchDrop, Item itemDrop, UniformLootNumberProvider numberOfDrop) {
        return BlockLootTableGenerator.dropsWithSilkTouch(
                silkTouchDrop,
                this.applyExplosionDecay(
                        silkTouchDrop,
                        (
                                (LeafEntry.Builder<?>) ItemEntry.builder(itemDrop)
                                        .apply(SetCountLootFunction.builder(numberOfDrop))
                        ).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
