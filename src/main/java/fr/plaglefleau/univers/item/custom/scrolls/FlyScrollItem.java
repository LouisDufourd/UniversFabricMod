package fr.plaglefleau.univers.item.custom.scrolls;

import fr.plaglefleau.univers.effect.ModEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class FlyScrollItem extends ScrollItem {
    public FlyScrollItem(Settings settings, int duration) {
        super(settings, duration);
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()) {
            user.addStatusEffect(new StatusEffectInstance(ModEffect.FLY, getDURATION(), 0, true, false, false));
        }
        return super.use(world, user, hand);
    }
}