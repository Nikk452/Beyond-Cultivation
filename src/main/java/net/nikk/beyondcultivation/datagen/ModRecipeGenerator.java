package net.nikk.beyondcultivation.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.nikk.beyondcultivation.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET)
        //        .pattern("SSS")
        //        .pattern("SPS")
        //        .pattern("SSS")
        //        .input('S', Items.STONE)
        //        .input('P', ModItems.PINK_GARNET)
        //        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
        //        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
        //        .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_PINK_GARNET) + "_"));

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);

        //offerSmelting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
        //                ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET,
        //        0.25f, 200, "pink_garnet");
        //offerBlasting(exporter, List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
        //                ModBlocks.NETHER_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE), RecipeCategory.MISC, ModItems.PINK_GARNET,
        //        0.25f, 200, "pink_garnet");

        //new GemEmpoweringRecipeBuilder(ModItems.RAW_PINK_GARNET, ModItems.PINK_GARNET, 3)
        //        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
        //        .offerTo(exporter);

        //new GemEmpoweringRecipeBuilder(Items.STICK, Items.END_ROD, 1)
        //        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
        //        .offerTo(exporter);

        //new GemEmpoweringRecipeBuilder(Items.COAL, Items.DIAMOND, 7)
        //        .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
        //        .offerTo(exporter);

        //new GemEmpoweringRecipeBuilder(Blocks.PRISMARINE, Items.COOKED_CHICKEN, 12)
        //        .criterion(hasItem(Blocks.PRISMARINE), conditionsFromItem(Blocks.PRISMARINE))
        //        .offerTo(exporter);
    }
}
