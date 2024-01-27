package fr.plaglefleau.univers.effect;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.effect.custom.FlyEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffect {

    public static final StatusEffect FLY = registerEffect("fly_effect", new FlyEffect());

    public static void registerEffects() {
        Univers.LOGGER.info("Registering Effects for %s".formatted(Univers.MOD_ID));
    }

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Univers.MOD_ID, name), effect);
    }
}
