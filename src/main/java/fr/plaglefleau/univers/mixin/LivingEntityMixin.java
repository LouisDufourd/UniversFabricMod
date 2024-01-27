package fr.plaglefleau.univers.mixin;

import fr.plaglefleau.univers.Univers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "onStatusEffectRemoved", at = @At("HEAD"))
    private void onStatusEffectRemovedMixin(StatusEffectInstance effect, CallbackInfo ci) {
        if ((LivingEntity)(Object)this instanceof PlayerEntity player) {
            boolean canFlyNaturally = (player.isCreative() || player.isSpectator());
            PlayerAbilities abilities = player.getAbilities();

            Univers.LOGGER.info("can fly 1 : %s".formatted(canFlyNaturally && abilities.allowFlying));
            abilities.allowFlying = canFlyNaturally && abilities.allowFlying;
            Univers.LOGGER.info("can fly 2 : %s".formatted(abilities.allowFlying));

            Univers.LOGGER.info("can flying 1 : %s".formatted(canFlyNaturally && abilities.flying));
            abilities.flying = canFlyNaturally && abilities.flying;
            Univers.LOGGER.info("can flying 2 : %s".formatted(abilities.flying));

            player.sendAbilitiesUpdate();
        }
    }
}
