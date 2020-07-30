package mod.author.simplemod.init;

import mod.author.simplemod.SimpleMod;
import mod.author.simplemod.content.SimpleModArmorMaterial;
import mod.author.simplemod.content.SimpleModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Sinhika, notes by Cadiboo.
 */
public final class ModItems 
{
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, SimpleMod.MODID);

    // ingots and nuggets
    public static final RegistryObject<Item> foo_ingot = ITEMS.register("foo_ingot", 
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> foo_nugget = ITEMS.register("foo_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> bar_ingot = ITEMS.register("bar_ingot",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> bar_nugget = ITEMS.register("bar_nugget",
            ()-> new Item(new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // parts

   
    // TOOLS & WEAPONS
    // bows

    // swords
    public static final RegistryObject<SwordItem> foo_sword = ITEMS.register("foo_sword",
            () -> new SwordItem(SimpleModItemTier.FOO, 3, -2.4F,
                                new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<SwordItem> bar_sword = ITEMS.register("bar_sword",
            () -> new SwordItem(SimpleModItemTier.BAR, 3, -2.4F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // pickaxes
    public static final RegistryObject<PickaxeItem> foo_pickaxe = ITEMS.register("foo_pickaxe",
            () -> new PickaxeItem(SimpleModItemTier.FOO, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<PickaxeItem> bar_pickaxe = ITEMS.register("bar_pickaxe",
            () -> new PickaxeItem(SimpleModItemTier.BAR, 1, -2.8F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // axes
    public static final RegistryObject<AxeItem> foo_axe = ITEMS.register("foo_axe",
            () -> new AxeItem(SimpleModItemTier.FOO, 7.0F, -3.1F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<AxeItem> bar_axe = ITEMS.register("bar_axe",
            () -> new AxeItem(SimpleModItemTier.BAR, 6.0F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // shovels
    public static final RegistryObject<ShovelItem> foo_shovel = ITEMS.register("foo_shovel",
            () -> new ShovelItem(SimpleModItemTier.FOO, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ShovelItem> bar_shovel = ITEMS.register("bar_shovel",
            () -> new ShovelItem(SimpleModItemTier.BAR, 1.5F, -3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // hoes
    public static final RegistryObject<HoeItem> foo_hoe = ITEMS.register("foo_hoe",
            () -> new HoeItem(SimpleModItemTier.FOO,-2.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<HoeItem> bar_hoe = ITEMS.register("bar_hoe",
            () -> new HoeItem(SimpleModItemTier.BAR,-3.0F,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // ARMOR
    // foo
    public static final RegistryObject<ArmorItem> foo_helmet = ITEMS.register("foo_helmet",
            () -> new ArmorItem(SimpleModArmorMaterial.FOO, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> foo_leggings = ITEMS.register("foo_leggings",
            () -> new ArmorItem(SimpleModArmorMaterial.FOO, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> foo_chestplate = ITEMS.register("foo_chestplate",
            () -> new ArmorItem(SimpleModArmorMaterial.FOO, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> foo_boots = ITEMS.register("foo_boots",
            () -> new ArmorItem(SimpleModArmorMaterial.FOO, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

    // bar
    public static final RegistryObject<ArmorItem> bar_helmet = ITEMS.register("bar_helmet",
            () -> new ArmorItem(SimpleModArmorMaterial.BAR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> bar_leggings = ITEMS.register("bar_leggings",
            () -> new ArmorItem(SimpleModArmorMaterial.BAR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> bar_chestplate = ITEMS.register("bar_chestplate",
            () -> new ArmorItem(SimpleModArmorMaterial.BAR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<ArmorItem> bar_boots = ITEMS.register("bar_boots",
            () -> new ArmorItem(SimpleModArmorMaterial.BAR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModTabGroups.MOD_ITEM_GROUP)));

} // end class
