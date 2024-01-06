package fr.plaglefleau.univers.utils;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemGroupsUtils {
    public static <T extends ItemConvertible> void addItemInGroup(@NotNull List<String> itemGroups, T item) {
        for (String itemGroup: itemGroups) {
            switch (itemGroup) {
                case "COMBAT" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(item));
                case "BUILDING_BLOCKS" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(item));
                case "NATURAL" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(item));
                case "COLORED_BLOCKS" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> entries.add(item));
                case "FOOD_AND_DRINK" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(item));
                case "FUNCTIONAL" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
                case "HOTBAR" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.HOTBAR).register(entries -> entries.add(item));
                case "INGREDIENTS" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(item));
                case "INVENTORY" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.INVENTORY).register(entries -> entries.add(item));
                case "OPERATOR" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> entries.add(item));
                case "REDSTONE" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.add(item));
                case "SEARCH" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(entries -> entries.add(item));
                case "SPAWN_EGGS" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.add(item));
                case "TOOLS" -> ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(item));
            }
        }
    }
}
