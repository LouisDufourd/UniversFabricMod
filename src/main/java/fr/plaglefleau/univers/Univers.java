package fr.plaglefleau.univers;

import fr.plaglefleau.univers.block.ModBlocks;
import fr.plaglefleau.univers.block.entity.ModBlockEntities;
import fr.plaglefleau.univers.effect.ModEffect;
import fr.plaglefleau.univers.item.ModItemGroups;
import fr.plaglefleau.univers.item.ModItems;
import fr.plaglefleau.univers.recipe.ModRecipes;
import fr.plaglefleau.univers.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Univers implements ModInitializer {

    public static final String MOD_ID = "univers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initialize Univers mods");
        ModItemGroups.registerItemGroups();

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();

        ModEffect.registerEffects();

        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();

        ModRecipes.registerRecipes();
    }
}
