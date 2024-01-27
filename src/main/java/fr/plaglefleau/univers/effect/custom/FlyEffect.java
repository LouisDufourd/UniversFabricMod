package fr.plaglefleau.univers.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FlyEffect extends StatusEffect {
    public FlyEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x9a9a9a);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity player) {
            if(!player.getWorld().isClient()) {
                player.getAbilities().allowFlying = true;
                player.sendAbilitiesUpdate();
            }
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity player) {
            if(!player.getWorld().isClient()) {
                player.getAbilities().allowFlying = true;
                player.sendAbilitiesUpdate();
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}