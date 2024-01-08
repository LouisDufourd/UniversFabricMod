package fr.plaglefleau.univers.item;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.MutableText;
import net.minecraft.item.ItemGroup.Entries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ModItemGroups {
    public static final ItemGroup SCROLLS = registerItemGroup(
            "scrolls",
            Text.translatable("itemGroup.univers.scrolls"),
            getItemStack(ModItems.BLANK_SCROLLS)
    );

    public static final ItemGroup MAGICS = registerItemGroup(
            "magics",
            Text.translatable("itemGroup.univers.magics"),
            getItemStack(ModItems.WATER_GEM)
    );

    private static @Nullable ItemGroup registerItemGroup(@NotNull String itemGroupId, MutableText title, ItemStack icon) {
        switch (itemGroupId) {
            case "magics" -> {
                return Registry.register(
                        Registries.ITEM_GROUP,
                        new Identifier(Univers.MOD_ID, itemGroupId),
                        FabricItemGroup
                                .builder()
                                .displayName(title)
                                .icon(() -> icon)
                                .entries((displayContext, entries) -> addEntriesMagics(entries))
                                .build()
                );
            }
            case "scrolls" -> {
                return Registry.register(
                        Registries.ITEM_GROUP,
                        new Identifier(Univers.MOD_ID, itemGroupId),
                        FabricItemGroup
                                .builder()
                                .displayName(title)
                                .icon(() -> icon)
                                .entries((displayContext, entries) -> addEntriesScrolls(entries))
                                .build()
                );
            }
            default -> {
                return null;
            }
        }
    }

    private static void addEntriesScrolls(@NotNull Entries entries) {
        entries.add(getItemStack(ModItems.BLANK_SCROLLS));
        entries.add(getItemStack(ModItems.SPEED_SCROLLS));
        entries.add(getItemStack(ModItems.FLY_SCROLLS));
    }

    private static @NotNull ItemStack getItemStack(Item item) {
        return new ItemStack(item);
    }

    public static void registerItemGroups() {
        Univers.LOGGER.info("Registering mod item groups for %s".formatted(Univers.MOD_ID));
    }

    private static void addEntriesMagics(@NotNull Entries entries) {
        entries.add(getItemStack(ModItems.WATER_GEM));
        entries.add(getItemStack(ModItems.FIRE_GEM));
        entries.add(getItemStack(ModItems.EARTH_GEM));
        entries.add(getItemStack(ModItems.AIR_GEM));
        entries.add(getItemStack(ModItems.HOLY_GEM));
    }
}
