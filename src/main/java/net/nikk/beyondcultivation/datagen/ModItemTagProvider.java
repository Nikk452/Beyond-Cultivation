package net.nikk.beyondcultivation.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nikk.beyondcultivation.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
        //        .add(ModItems.PINK_GARNET_HELMET, ModItems.PINK_GARNET_CHESTPLATE, ModItems.PINK_GARNET_LEGGINGS, ModItems.PINK_GARNET_BOOTS);
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.PEACHTREE_PLANKS.asItem())
                .add(ModBlocks.PLUM_BLOSSOM_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PEACHTREE_LOG.asItem())
                .add(ModBlocks.PEACHTREE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PEACHTREE_LOG.asItem())
                .add(ModBlocks.STRIPPED_PEACHTREE_WOOD.asItem())
                .add(ModBlocks.PLUM_BLOSSOM_LOG.asItem())
                .add(ModBlocks.PLUM_BLOSSOM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PLUM_BLOSSOM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PLUM_BLOSSOM_WOOD.asItem());
    }
}
