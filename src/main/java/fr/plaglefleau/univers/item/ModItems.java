package fr.plaglefleau.univers.item;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.item.custom.scrolls.FlyScrollItem;
import fr.plaglefleau.univers.item.custom.scrolls.SpeedScrollItem;
import fr.plaglefleau.univers.utils.Utils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item BLANK_SCROLLS = registerItem("blank_scroll", new Item(new FabricItemSettings()));
    public static final Item SPEED_SCROLLS = registerItem("speed_scroll",  new SpeedScrollItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item FLY_SCROLLS = registerItem("fly_scroll", new FlyScrollItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_PLATINUM = registerItem("raw_platinum", new Item(new FabricItemSettings()));
    public static final Item WATER_GEM = registerItem("water_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item FIRE_GEM = registerItem("fire_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item EARTH_GEM = registerItem("earth_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item AIR_GEM = registerItem("air_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item HOLY_GEM = registerItem("holy_gem", new Item(new FabricItemSettings().rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Univers.MOD_ID, name), item);
    }
    private static void addItemsToGroup() {
        Utils.addItemToGroup(ItemGroups.INGREDIENTS, PLATINUM_INGOT);
        Utils.addItemToGroup(ItemGroups.INGREDIENTS, RAW_PLATINUM);
    }

    public static void registerModItems() {
        Univers.LOGGER.info("Registering Mod Items for %s".formatted(Univers.MOD_ID));
        addItemsToGroup();
    }
}
