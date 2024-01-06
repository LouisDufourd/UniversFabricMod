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
            }
        }
    }
}
