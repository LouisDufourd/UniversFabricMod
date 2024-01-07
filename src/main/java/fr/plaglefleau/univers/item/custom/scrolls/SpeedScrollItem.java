package fr.plaglefleau.univers.item.custom.scrolls;

import fr.plaglefleau.univers.Univers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.concurrent.*;

public class SpeedScrollItem extends Item {
    public SpeedScrollItem(Settings settings) {
        super(settings);
    }

    ScheduledExecutorService scheduledExecutorService;

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
            float userSpeed = 0.1f;
            float speed = userSpeed * ((float) 1/3);
            user.getAbilities().setWalkSpeed(speed);
            if(scheduledExecutorService != null) {
                if(!scheduledExecutorService.isShutdown() || !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.shutdown();
                }
            }
            scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.schedule(() -> {
                user.getAbilities().setWalkSpeed(userSpeed);
            }, 5, TimeUnit.MINUTES);
        }
        return super.use(world, user, hand);
    }
}