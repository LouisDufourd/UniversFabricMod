package fr.plaglefleau.univers.datagen;

import fr.plaglefleau.univers.block.ModBlocks;
import fr.plaglefleau.univers.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import org.jetbrains.annotations.NotNull;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NotNull BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PLATINUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PLATINUM_BLOCK);

        blockStateModelGenerator.registerSimpleState(ModBlocks.SCROLL_WRITER);
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) {
        //SCROLLS
        itemModelGenerator.register(ModItems.BLANK_SCROLLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.WRITTEN_SCROLLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPEED_SCROLLS, ModItems.WRITTEN_SCROLLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLY_SCROLLS, ModItems.WRITTEN_SCROLLS, Models.GENERATED);

        //MAGICS
        itemModelGenerator.register(ModItems.MAGIC_INK, Models.GENERATED);
        itemModelGenerator.register(ModItems.WATER_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.EARTH_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.AIR_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOLY_GEM, Models.GENERATED);

        //MINERALS
        itemModelGenerator.register(ModItems.RAW_PLATINUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_INGOT, Models.GENERATED);

        //TOOLS
        itemModelGenerator.register(ModItems.PLATINUM_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLATINUM_HOE, Models.HANDHELD);

        //ARMORS
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PLATINUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PLATINUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PLATINUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PLATINUM_BOOTS);
    }
}
