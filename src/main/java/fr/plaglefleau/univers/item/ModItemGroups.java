package fr.plaglefleau.univers.item;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroup.Entries;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class ModItemGroups {
    public static final ItemGroup SCROLLS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Univers.MOD_ID, "scrolls"),
            FabricItemGroup
                    .builder()
                    .displayName(Text.translatable("itemGroup.univers.scrolls"))
                    .icon(() -> getItemStack(ModItems.BLANK_SCROLLS))
                    .entries((displayContext, entries) -> addEntriesScrolls(entries))
                    .build()
    );

    public static final ItemGroup MAGICS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Univers.MOD_ID, "magics"),
            FabricItemGroup
                    .builder()
                    .displayName(Text.translatable("itemGroup.univers.magics"))
                    .icon(() -> getItemStack(ModItems.WATER_STAFF))
                    .entries((displayContext, entries) -> addEntriesMagics(entries))
                    .build()
    );

    private static void addEntriesScrolls(@NotNull Entries entries) {
        entries.add(getItemStack(ModBlocks.SCROLL_WRITER.asItem()));
        entries.add(getItemStack(ModItems.BLANK_SCROLLS));
        entries.add(getItemStack(ModItems.SPEED_SCROLLS));
        entries.add(getItemStack(ModItems.FLY_SCROLLS));
    }

    private static @NotNull ItemStack getItemStack(Item item) {
        return new ItemStack(item);
    }

    public static void registerItemGroups() {
        Univers.LOGGER.info("Registering Item Groups for %s".formatted(Univers.MOD_ID));
    }

    private static void addEntriesMagics(@NotNull Entries entries) {
        entries.add(getItemStack(ModItems.MAGIC_INK));
        entries.add(getItemStack(ModItems.WATER_GEM));
        entries.add(getItemStack(ModItems.FIRE_GEM));
        entries.add(getItemStack(ModItems.EARTH_GEM));
        entries.add(getItemStack(ModItems.AIR_GEM));
        entries.add(getItemStack(ModItems.HOLY_GEM));

        entries.add(getItemStack(ModItems.FIRE_STAFF));
        entries.add(getItemStack(ModItems.WATER_STAFF));
        entries.add(getItemStack(ModItems.EARTH_STAFF));
        entries.add(getItemStack(ModItems.AIR_STAFF));
        entries.add(getItemStack(ModItems.HOLY_STAFF));
    }
}
