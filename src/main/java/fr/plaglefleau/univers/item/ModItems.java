package fr.plaglefleau.univers.item;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.item.custom.ModArmorMaterials;
import fr.plaglefleau.univers.item.custom.scrolls.FlyScrollItem;
import fr.plaglefleau.univers.item.custom.scrolls.SpeedScrollItem;
import fr.plaglefleau.univers.utils.Utils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    //SCROLLS
    public static final Item BLANK_SCROLLS = registerItem("blank_scroll", new Item(new FabricItemSettings()));
    public static final Item WRITTEN_SCROLLS = registerItem("written_scroll",  new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item SPEED_SCROLLS = registerItem("speed_scroll",  new SpeedScrollItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON), Utils.minuteToTicks(10)));
    public static final Item FLY_SCROLLS = registerItem("fly_scroll", new FlyScrollItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON), Utils.minuteToTicks(5)));

    //ORES
    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_PLATINUM = registerItem("raw_platinum", new Item(new FabricItemSettings()));

    //TOOLS
    public static final Item PLATINUM_STICK = registerItem("platinum_stick", new Item(new FabricItemSettings()));
    public static final Item PLATINUM_HELMET = registerItem("platinum_helmet", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PLATINUM_CHESTPLATE = registerItem("platinum_chestplate", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PLATINUM_LEGGINGS = registerItem("platinum_leggings", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PLATINUM_BOOTS = registerItem("platinum_boots", new ArmorItem(ModArmorMaterials.PLATINUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item PLATINUM_SWORD = registerItem("platinum_sword", new SwordItem(ModToolMaterial.PLATINUM, 3, -2.4f, new FabricItemSettings()));
    public static final Item PLATINUM_PICKAXE = registerItem("platinum_pickaxe", new PickaxeItem(ModToolMaterial.PLATINUM, 1, -2.8f, new FabricItemSettings()));
    public static final Item PLATINUM_AXE = registerItem("platinum_axe", new AxeItem(ModToolMaterial.PLATINUM, 6.0f, -3.1f, new FabricItemSettings()));
    public static final Item PLATINUM_SHOVEL = registerItem("platinum_shovel", new ShovelItem(ModToolMaterial.PLATINUM, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item PLATINUM_HOE = registerItem("platinum_hoe", new HoeItem(ModToolMaterial.PLATINUM, -2, -1.0f, new FabricItemSettings()));

    //GEMS
    public static final Item WATER_GEM = registerItem("water_gem", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item FIRE_GEM = registerItem("fire_gem", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item EARTH_GEM = registerItem("earth_gem", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item AIR_GEM = registerItem("air_gem", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item HOLY_GEM = registerItem("holy_gem", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    //STAFFS
    public static final Item FIRE_STAFF = registerItem("fire_staff", new Item(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item WATER_STAFF = registerItem("water_staff", new Item(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item EARTH_STAFF = registerItem("earth_staff", new Item(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item AIR_STAFF = registerItem("air_staff", new Item(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));
    public static final Item HOLY_STAFF = registerItem("holy_staff", new Item(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));

    //OTHER
    public static final Item MAGIC_INK = registerItem("magic_ink", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Univers.MOD_ID, name), item);
    }
    private static void addItemsToGroup() {
        //ORES
        Utils.addItemToGroupAfter(ItemGroups.INGREDIENTS, PLATINUM_INGOT, Items.GOLD_INGOT);
        Utils.addItemToGroupAfter(ItemGroups.INGREDIENTS, RAW_PLATINUM, Items.RAW_GOLD);

        //ARMORS
        Utils.addItemToGroupAfter(ItemGroups.COMBAT, PLATINUM_HELMET, Items.GOLDEN_BOOTS);
        Utils.addItemToGroupAfter(ItemGroups.COMBAT, PLATINUM_CHESTPLATE, PLATINUM_HELMET);
        Utils.addItemToGroupAfter(ItemGroups.COMBAT, PLATINUM_LEGGINGS, PLATINUM_CHESTPLATE);
        Utils.addItemToGroupAfter(ItemGroups.COMBAT, PLATINUM_BOOTS, PLATINUM_LEGGINGS);

        //TOOLS
        Utils.addItemToGroupAfter(ItemGroups.COMBAT, PLATINUM_SWORD, Items.GOLDEN_SWORD);
        Utils.addItemToGroupAfter(ItemGroups.COMBAT, PLATINUM_AXE, Items.GOLDEN_AXE);
        Utils.addItemToGroupAfter(ItemGroups.TOOLS, PLATINUM_SHOVEL, Items.GOLDEN_HOE);
        Utils.addItemToGroupAfter(ItemGroups.TOOLS, PLATINUM_PICKAXE, PLATINUM_SHOVEL);
        Utils.addItemToGroupAfter(ItemGroups.TOOLS, PLATINUM_AXE, PLATINUM_PICKAXE);
        Utils.addItemToGroupAfter(ItemGroups.TOOLS, PLATINUM_HOE, PLATINUM_AXE);
    }

    public static void registerModItems() {
        Univers.LOGGER.info("Registering Items for %s".formatted(Univers.MOD_ID));
        addItemsToGroup();
    }
}
