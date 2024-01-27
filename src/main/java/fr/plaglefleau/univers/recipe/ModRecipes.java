package fr.plaglefleau.univers.recipe;

import fr.plaglefleau.univers.Univers;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Univers.MOD_ID, ScrollWriterRecipe.Serializer.ID),
                ScrollWriterRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Univers.MOD_ID, ScrollWriterRecipe.Type.ID),
                ScrollWriterRecipe.Type.INSTANCE);
    }
}
