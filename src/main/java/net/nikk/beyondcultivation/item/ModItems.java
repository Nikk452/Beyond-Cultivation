package net.nikk.beyondcultivation.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.ModEntities;

public class ModItems {
    public static final Item SPIRIT_STONE = registerItem("spirit_stone",
            new Item(new FabricItemSettings()));
    public static final Item MARTIAL_MANUAL = registerItem("martial_manual",
            new Item(new FabricItemSettings()));
    public static final Item PHOENIX_FEATHER = registerItem("phoenix_feather",
            new Item(new FabricItemSettings()));
    public static final Item PHEASANT_FEATHER = registerItem("pheasant_feather",
            new Item(new FabricItemSettings()));
    public static final Item PEACOCK_FEATHER = registerItem("peacock_feather",
            new Item(new FabricItemSettings()));
    public static final Item RAT_TAIL = registerItem("rat_tail",
            new Item(new FabricItemSettings()));
    public static final Item BOAR_HORN = registerItem("boar_horn",
            new Item(new FabricItemSettings()));
    public static final Item SNAKE_VENOM = registerItem("snake_venom",
            new Item(new FabricItemSettings()));
    public static final Item QILIN_ANTLER = registerItem("qilin_antler",
            new Item(new FabricItemSettings()));
    public static final Item TIGER_SKIN = registerItem("tiger_skin",
            new Item(new FabricItemSettings()));
    public static final Item TIGER_MEAT = registerItem("tiger_meat",
            new Item(new FabricItemSettings()));
    public static final Item RAT_MEAT = registerItem("rat_meat",
            new Item(new FabricItemSettings()));
    public static final Item SNAKE_MEAT = registerItem("snake_meat",
            new Item(new FabricItemSettings()));
    public static final Item COOKED_TIGER = registerItem("cooked_tiger",
            new Item(new FabricItemSettings()));
    public static final Item COOKED_RAT = registerItem("cooked_rat",
            new Item(new FabricItemSettings()));
    public static final Item COOKED_SNAKE = registerItem("cooked_snake",
            new Item(new FabricItemSettings()));
    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER, 0xb8652e, 0xFFFFFF, new FabricItemSettings()));
    public static final Item RED_PANDA_SPAWN_EGG = registerItem("red_panda_spawn_egg",
            new SpawnEggItem(ModEntities.RED_PANDA, 0xb8652e, 0x000000, new FabricItemSettings()));
    public static final Item QILIN_SPAWN_EGG = registerItem("qilin_spawn_egg",
            new SpawnEggItem(ModEntities.QILIN, 0x09652e, 0xa3900f, new FabricItemSettings()));
    public static final Item SPIRIT_FOX_SPAWN_EGG = registerItem("spirit_fox_spawn_egg",
            new SpawnEggItem(ModEntities.SPIRIT_FOX, 0xf9652e, 0x09900f, new FabricItemSettings()));
    //public static final Item THOUSAND_LEE_HORSE_SPAWN_EGG = registerItem("thousand_lee_horse_spawn_egg",
    //        new SpawnEggItem(EntityTy, 0x09652e, 0xa3900f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BCMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(SPIRIT_STONE);
    }
    private static void itemGroupSpawnEgg(FabricItemGroupEntries entries) {
        entries.add(TIGER_SPAWN_EGG);
        entries.add(RED_PANDA_SPAWN_EGG);
        entries.add(QILIN_SPAWN_EGG);
        entries.add(SPIRIT_FOX_SPAWN_EGG);
    }
    public static void registerModItems() {
        BCMod.LOGGER.info("Registering Mod Items for " + BCMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::itemGroupSpawnEgg);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupSpawnEgg);
    }
}
