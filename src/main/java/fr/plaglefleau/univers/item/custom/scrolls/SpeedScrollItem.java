package fr.plaglefleau.univers.item.custom.scrolls;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class SpeedScrollItem extends ScrollItem {

    public SpeedScrollItem(Settings settings, int duration) {
        super(settings, duration);
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, getDURATION(), 1, true, false, false));
        }
        return super.use(world, user, hand);
    }
}