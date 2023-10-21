package net.nikk.beyondcultivation;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.block.entity.ModBlockEntities;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.client.*;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;
import net.nikk.beyondcultivation.util.ModWoodTypes;

public class BCModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEACHTREE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEACHTREE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_BLOSSOM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_BLOSSOM_LEAVES, RenderLayer.getCutout());
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.PEACHTREE, TexturedRenderLayers.getSignTextureId(ModWoodTypes.PEACHTREE));


        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TIGER, TigerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RED_PANDA, RedPandaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RED_PANDA, RedPandaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.QILIN, QilinModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.QILIN, QilinRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPIRIT_FOX, SpiritFoxModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SPIRIT_FOX, SpiritFoxRenderer::new);
    }
}
