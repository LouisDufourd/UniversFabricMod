package fr.plaglefleau.univers.utils;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Utils {

    public static <T extends ItemConvertible> void addItemToGroup(RegistryKey<ItemGroup> group, @NotNull T item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static <T extends ItemConvertible> void addItemToGroupAfter(RegistryKey<ItemGroup> group, @NotNull T item, @NotNull T afterItem) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(afterItem,item));
    }

    public static int secondToTicks(int second) {
        return second * 20;
    }

    public static int minuteToTicks(int minute) {
        return minute * 60 * 20;
    }

    public static int hourToTicks(int minute) {
        return minute * 60 * 60 * 20;
    }

    public static int millisecondToTicks(int millisecond) {
        return (millisecond / 1000) * 20;
    }
}
