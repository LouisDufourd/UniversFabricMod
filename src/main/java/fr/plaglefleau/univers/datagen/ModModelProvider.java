package fr.plaglefleau.univers.datagen;

import fr.plaglefleau.univers.block.ModBlocks;
import fr.plaglefleau.univers.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
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
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) {
        //SCROLLS
        itemModelGenerator.register(ModItems.BLANK_SCROLLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPEED_SCROLLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLY_SCROLLS, Models.GENERATED);

        //GEMS
        itemModelGenerator.register(ModItems.WATER_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.EARTH_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.AIR_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOLY_GEM, Models.GENERATED);

        //Minerals
        itemModelGenerator.register(ModItems.RAW_PLATINUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_INGOT, Models.GENERATED);
    }
}
