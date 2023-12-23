package net.nikk.beyondcultivation.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.nikk.beyondcultivation.block.ModBlocks;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PEACHTREE_WOOD);
        addDrop(ModBlocks.PEACHTREE_LOG);
        addDrop(ModBlocks.STRIPPED_PEACHTREE_WOOD);
        addDrop(ModBlocks.STRIPPED_PEACHTREE_LOG);
        addDrop(ModBlocks.PEACHTREE_LEAVES);
        addDrop(ModBlocks.PEACHTREE_PLANKS);
        addDrop(ModBlocks.PEACHTREE_SAPLING);

        addDrop(ModBlocks.PLUM_BLOSSOM_LOG);
        addDrop(ModBlocks.PLUM_BLOSSOM_WOOD);
        addDrop(ModBlocks.STRIPPED_PLUM_BLOSSOM_LOG);
        addDrop(ModBlocks.STRIPPED_PLUM_BLOSSOM_WOOD);
        addDrop(ModBlocks.PLUM_BLOSSOM_LEAVES,leavesDrops(ModBlocks.PLUM_BLOSSOM_LEAVES,ModBlocks.PLUM_BLOSSOM_SAPLING,0.0025f));
        addDrop(ModBlocks.PLUM_BLOSSOM_PLANKS);
        addDrop(ModBlocks.PLUM_BLOSSOM_SAPLING);
        //addDrop(ModBlocks.PINK_GARNET_DOOR, doorDrops(ModBlocks.PINK_GARNET_DOOR));

        //BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.CAULIFLOWER_CROP)
        //        .properties(StatePredicate.Builder.create().exactMatch(CauliflowerCropBlock.AGE, 6));
        //this.addDrop(ModBlocks.CAULIFLOWER_CROP, this.cropDrops(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS, builder2));

        // IF YOU ONLY WANT THE ITEM TO DROP FROM THE TOP BLOCK
        // BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.CATTAIL_CROP)
        //         .properties(StatePredicate.Builder.create().exactMatch(CauliflowerCropBlock.AGE, 8));
        // this.addDrop(ModBlocks.CATTAIL_CROP, this.cropDrops(ModBlocks.CATTAIL_CROP, ModItems.CATTAIL, ModItems.CATTAIL_SEEDS, builder3));

        //AnyOfLootCondition.Builder builder =
        //        BlockStatePropertyLootCondition.builder(ModBlocks.CATTAIL_CROP).properties(StatePredicate.Builder.create()
        //                        .exactMatch(CauliflowerCropBlock.AGE, 7))
        //                .or(BlockStatePropertyLootCondition.builder(ModBlocks.CATTAIL_CROP).properties(StatePredicate.Builder.create()
        //                        .exactMatch(CauliflowerCropBlock.AGE, 8)));
        //addDrop(ModBlocks.CATTAIL_CROP, cropDrops(ModBlocks.CATTAIL_CROP, ModItems.CATTAIL, ModItems.CATTAIL_SEEDS, builder));


    }
}
