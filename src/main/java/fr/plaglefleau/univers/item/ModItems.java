package fr.plaglefleau.univers.item;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.utils.ItemGroupsUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    public static final Map<String, Pair<List<String>,Item>> UNIVERS_MOD_ITEMS = new HashMap<>();

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Univers.MOD_ID, name), item);
    }

    private static void addItemsGroup() {
        for (Map.Entry<String, Pair<List<String>, Item>> entry : UNIVERS_MOD_ITEMS.entrySet()) {
            Pair<List<String>, Item> itemInfo = entry.getValue();
            ItemGroupsUtils.addItemInGroup(itemInfo.getLeft(), itemInfo.getRight());
        }
    }

    public static void registerModItems() {
        Univers.LOGGER.info("Registering Mod Items for %s".formatted(Univers.MOD_ID));
        UNIVERS_MOD_ITEMS.put("scroll", new Pair<>(List.of("COMBAT", "scrolls"),registerItem("blank_scroll", new Item(new FabricItemSettings()))));
        addItemsGroup();
    }
}
