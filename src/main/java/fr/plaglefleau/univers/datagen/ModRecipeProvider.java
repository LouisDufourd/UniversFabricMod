package fr.plaglefleau.univers.datagen;

import fr.plaglefleau.univers.block.ModBlocks;
import fr.plaglefleau.univers.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> PLATINUM_INGOT_SMELTABLES = List.of(ModBlocks.PLATINUM_ORE, ModBlocks.DEEPSLATE_PLATINUM_ORE, ModItems.RAW_PLATINUM);
    private static final List<ItemConvertible> PLATINUM_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_PLATINUM_BLOCK);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, PLATINUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT,
                0.7f, 100, "platinum");
        offerSmelting(exporter, PLATINUM_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.PLATINUM_BLOCK,
                6.3f, 900, "platinum");
        offerBlasting(exporter, PLATINUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT,
                0.7f, 100, "platinum");
        offerBlasting(exporter, PLATINUM_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.PLATINUM_BLOCK,
                6.3f, 900, "platinum");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.PLATINUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PLATINUM, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_PLATINUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PLATINUM, 1)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('P', ModItems.PLATINUM_INGOT)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.PLATINUM_INGOT), conditionsFromItem(ModItems.PLATINUM_INGOT))
                .offerTo(exporter, new Identifier("raw_platinum_from_platinum_ingot"));
    }
}
