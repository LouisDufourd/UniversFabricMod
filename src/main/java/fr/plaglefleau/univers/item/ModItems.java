package fr.plaglefleau.univers.item;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.item.custom.scrolls.FlyScrollItem;
import fr.plaglefleau.univers.item.custom.scrolls.SpeedScrollItem;
import fr.plaglefleau.univers.utils.Utils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.Rarity;

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
            Utils.addItemInGroup(itemInfo.getLeft(), itemInfo.getRight());
        }
    }
    private static void registerItems() {
        UNIVERS_MOD_ITEMS.put("blank_scroll", new Pair<>(List.of("COMBAT", "scrolls"),registerItem("blank_scroll", new Item(new FabricItemSettings()))));
        UNIVERS_MOD_ITEMS.put("platinum_ingot", new Pair<>(List.of("INGREDIENTS"),registerItem("platinum_ingot", new Item(new FabricItemSettings()))));
        UNIVERS_MOD_ITEMS.put("raw_platinum", new Pair<>(List.of("INGREDIENTS"),registerItem("raw_platinum", new Item(new FabricItemSettings()))));
        UNIVERS_MOD_ITEMS.put("speed_scroll",new Pair<>(List.of("COMBAT", "scrolls"), registerItem("speed_scroll", new SpeedScrollItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)))));
        UNIVERS_MOD_ITEMS.put("fly_scroll",new Pair<>(List.of("COMBAT", "scrolls"), registerItem("fly_scroll", new FlyScrollItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)))));
        UNIVERS_MOD_ITEMS.put("water_gem", new Pair<>(List.of("INGREDIENTS","magics"), registerItem("water_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)))));
        UNIVERS_MOD_ITEMS.put("fire_gem", new Pair<>(List.of("INGREDIENTS","magics"), registerItem("fire_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)))));
        UNIVERS_MOD_ITEMS.put("earth_gem", new Pair<>(List.of("INGREDIENTS","magics"), registerItem("earth_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)))));
        UNIVERS_MOD_ITEMS.put("air_gem", new Pair<>(List.of("INGREDIENTS","magics"), registerItem("air_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)))));
        UNIVERS_MOD_ITEMS.put("holy_gem", new Pair<>(List.of("INGREDIENTS","magics"), registerItem("holy_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)))));
    }

    public static void registerModItems() {
        Univers.LOGGER.info("Registering Mod Items for %s".formatted(Univers.MOD_ID));
        registerItems();
        addItemsGroup();
    }
}
