package fr.plaglefleau.univers.item.custom.scrolls;

import fr.plaglefleau.univers.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ScrollItem extends Item {

    private final int DURATION;

    public ScrollItem(Settings settings, int duration) {
        super(settings);
        DURATION = duration;
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()) {
            user.setStackInHand(hand, new ItemStack(Items.AIR));
            user.giveItemStack(new ItemStack(ModItems.BLANK_SCROLLS));
            user.getItemCooldownManager().set(this, DURATION * 2);
        }
        return super.use(world, user, hand);
    }

    public int getDURATION() {
        return DURATION;
    }
}
