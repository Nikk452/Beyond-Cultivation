package net.nikk.beyondcultivation.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.PEACHTREE_LOG).log(ModBlocks.PEACHTREE_LOG).wood(ModBlocks.PEACHTREE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PEACHTREE_LOG).log(ModBlocks.STRIPPED_PEACHTREE_LOG).wood(ModBlocks.STRIPPED_PEACHTREE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.PLUM_BLOSSOM_LOG).log(ModBlocks.PLUM_BLOSSOM_LOG).wood(ModBlocks.PLUM_BLOSSOM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_PLUM_BLOSSOM_LOG).log(ModBlocks.STRIPPED_PLUM_BLOSSOM_LOG).wood(ModBlocks.STRIPPED_PLUM_BLOSSOM_WOOD);
        //BlockStateModelGenerator.BlockTexturePool tPlnaks = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PEACHTREE_PLANKS);
        //BlockStateModelGenerator.BlockTexturePool tplumPlnaks = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PLUM_BLOSSOM_PLANKS);
        //tPlnaks.family(BlockFamilies.register(ModBlocks.PEACHTREE_PLANKS).sign(ModBlocks.PEACHTREE_SIGN, ModBlocks.PEACHTREE_WALL_SIGN).build());
        //tplumPlnaks.family(BlockFamilies.register(ModBlocks.PEACHTREE_PLANKS).sign(ModBlocks.PEACHTREE_SIGN, ModBlocks.PEACHTREE_WALL_SIGN).build());
        //blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_PEACHTREE_LOG, ModBlocks.PEACHTREE_HANGING_SIGN, ModBlocks.PEACHTREE_HANGING_WALL_SIGN);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PEACHTREE_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLUM_BLOSSOM_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TIGER_SKIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIGER_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_TIGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNAKE_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAT_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_RAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_SNAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHEASANT_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHOENIX_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEACOCK_FEATHER,Models.GENERATED);
        itemModelGenerator.register(ModItems.SPIRIT_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MARTIAL_MANUAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAT_TAIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNAKE_VENOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOAR_HORN , Models.GENERATED);
        itemModelGenerator.register(ModItems.QILIN_ANTLER , Models.GENERATED);
        itemModelGenerator.register(ModItems.TEST_POISON , Models.GENERATED);
        itemModelGenerator.register(ModItems.SPIRIT_FOX_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.TIGER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.RED_PANDA_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.QILIN_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.THOUSAND_LEE_HORSE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
