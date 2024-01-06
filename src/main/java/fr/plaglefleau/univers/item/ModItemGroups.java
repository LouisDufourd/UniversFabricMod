package fr.plaglefleau.univers.item;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.MutableText;
import net.minecraft.item.ItemGroup.DisplayContext;
import net.minecraft.item.ItemGroup.Entries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ModItemGroups {

    public static final Map<String, ItemGroup> UNIVERS_MOD_ITEM_GROUPS = new HashMap<>();
    public static void registerItemGroups() {
        Univers.LOGGER.info("Registering Item Groups for %s".formatted(Univers.MOD_ID));
        UNIVERS_MOD_ITEM_GROUPS.put(
                "SCROLLS",
                registerItemGroup(
                        "scrolls",
                        Text.translatable("itemGroup.scrolls"),
                        getItemModStack("blank_scroll")
                )
        );
    }

    private static ItemGroup registerItemGroup(String itemGroupId, MutableText title, ItemStack icon) {
        return Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(Univers.MOD_ID, itemGroupId),
                FabricItemGroup
                        .builder()
                        .displayName(title)
                        .icon(() -> icon)
                        .entries((displayContext, entries) -> addEntries(itemGroupId, entries))
                        .build()
        );
    }

    @Contract("_ -> new")
    private static @NotNull ItemStack getItemModStack(String itemId) {
        return new ItemStack(ModItems.UNIVERS_MOD_ITEMS.get(itemId).getRight());
    }

    private static void addEntries(String itemGroupId, Entries entries) {
        ModItems.UNIVERS_MOD_ITEMS.forEach((key, value) -> value.getLeft().forEach(groupId -> {
            if (itemGroupId.equalsIgnoreCase(groupId)) {
                entries.add(value.getRight());
            }
        }));
        ModBlocks.UNIVERS_MOD_BLOCKS.forEach((key, value) -> value.getLeft().forEach(groupId -> {
            if (itemGroupId.equalsIgnoreCase(groupId)) {
                entries.add(value.getRight());
            }
        }));
    }
}
