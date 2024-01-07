package fr.plaglefleau.univers.item.custom.scrolls;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FlyScrollItem extends Item {
    public FlyScrollItem(Settings settings) {
        super(settings);
    }

    ScheduledExecutorService scheduledExecutorService;

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
            user.getAbilities().allowFlying = true;
            if(scheduledExecutorService != null) {
                if(!scheduledExecutorService.isShutdown() || !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.shutdown();
                }
            }
            scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.schedule(() -> {
                user.getAbilities().allowFlying = false;
                user.getAbilities().flying = false;
            }, 60, TimeUnit.SECONDS);
            user.setStackInHand(hand, new ItemStack(ModItems.UNIVERS_MOD_ITEMS.get("blank_scroll").getRight()));
        }
        return super.use(world, user, hand);
    }
}