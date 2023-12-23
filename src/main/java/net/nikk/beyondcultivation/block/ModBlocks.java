package net.nikk.beyondcultivation.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.block.custom.*;
import net.nikk.beyondcultivation.block.entity.ModBlockEntities;
import net.nikk.beyondcultivation.item.ModItemGroup;
import net.nikk.beyondcultivation.util.ModWoodTypes;
import net.nikk.beyondcultivation.world.tree.PeachTreeSaplingGenerator;

public class ModBlocks {
    public static final Block PEACHTREE_LOG = registerBlock("peachtree_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));
    public static final Block PEACHTREE_WOOD = registerBlock("peachtree_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));
    public static final Block STRIPPED_PEACHTREE_LOG = registerBlock("stripped_peachtree_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));
    public static final Block STRIPPED_PEACHTREE_WOOD = registerBlock("stripped_peachtree_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final Block PEACHTREE_PLANKS = registerBlock("peachtree_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));

    public static final Block PLUM_BLOSSOM_LOG = registerBlock("plum_blossom_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));
    public static final Block PLUM_BLOSSOM_WOOD = registerBlock("plum_blossom_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));
    public static final Block STRIPPED_PLUM_BLOSSOM_LOG = registerBlock("stripped_plum_blossom_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));
    public static final Block STRIPPED_PLUM_BLOSSOM_WOOD = registerBlock("stripped_plum_blossom_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD)));

    public static final Block PLUM_BLOSSOM_PLANKS = registerBlock("plum_blossom_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
    public static final Block PEACHTREE_LEAVES = registerBlock("peachtree_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES)));
    public static final Block PLUM_BLOSSOM_LEAVES = registerBlock("plum_blossom_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES)));
    public static final Block PEACHTREE_SAPLING = registerBlock("peachtree_sapling",
            new ModSaplingBlock(new PeachTreeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.CHERRY_SAPLING)));
    public static final Block PLUM_BLOSSOM_SAPLING = registerBlock("plum_blossom_sapling",
            new ModSaplingBlock(new PeachTreeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.CHERRY_SAPLING)));

    /**public static final Block PEACHTREE_SIGN = registerBlockWithoutBlockItem("peachtree_sign",
            new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_SIGN), ModWoodTypes.PEACHTREE));
    public static final Block PEACHTREE_WALL_SIGN = registerBlockWithoutBlockItem("peachtree_wall_sign",
            new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_WALL_SIGN), ModWoodTypes.PEACHTREE));
    public static final Block PEACHTREE_HANGING_SIGN = registerBlockWithoutBlockItem("peachtree_hanging_sign",
            new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_HANGING_SIGN), ModWoodTypes.PEACHTREE));
    public static final Block PEACHTREE_HANGING_WALL_SIGN = registerBlockWithoutBlockItem("peachtree_hanging_wall_sign",
            new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_WALL_HANGING_SIGN), ModWoodTypes.PEACHTREE));
    */
     private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BCMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BCMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item temp = Registry.register(Registries.ITEM, new Identifier(BCMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(temp));
        return temp;
    }

    public static void registerModBlocks() {
        BCMod.LOGGER.info("Registering ModBlocks for " + BCMod.MOD_ID);
        ModBlockEntities.registerBlockEntities();
    }
}
