package net.nikk.beyondcultivation;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.block.baked.BakedApertureModel;
import net.nikk.beyondcultivation.block.baked.UnbakedApertureModel;
import net.nikk.beyondcultivation.block.entity.ApertureBlockEntity;
import net.nikk.beyondcultivation.block.entity.ModBlockEntities;
import net.nikk.beyondcultivation.block.entity.renderer.ApertureBlockEntityRenderer;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.client.*;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;
import net.nikk.beyondcultivation.item.ModItemRendererRegistry;
import net.nikk.beyondcultivation.item.ModItems;
import net.nikk.beyondcultivation.screen.ApertureBlockScreen;
import net.nikk.beyondcultivation.screen.ApertureScreen;
import net.nikk.beyondcultivation.screen.ModScreenHandlers;
import net.nikk.beyondcultivation.util.ModWoodTypes;

public class BCModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEACHTREE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEACHTREE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_BLOSSOM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_BLOSSOM_LEAVES, RenderLayer.getCutout());
        /**BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.PEACHTREE, TexturedRenderLayers.getSignTextureId(ModWoodTypes.PEACHTREE));
        */
        HandledScreens.register(ModScreenHandlers.APERTURE_SCREEN_HANDLER, ApertureScreen::new);

        HandledScreens.register(ModScreenHandlers.APERTURE_BLOCK_SCREEN_HANDLER, ApertureBlockScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.APERTURE_BLOCK_ENTITY, ApertureBlockEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APERTURE, RenderLayer.getTranslucent());

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TIGER, TigerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RED_PANDA, RedPandaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RED_PANDA, RedPandaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.QILIN, QilinModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.QILIN, QilinRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPIRIT_FOX, SpiritFoxModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SPIRIT_FOX, SpiritFoxRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BOAR, BoarModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOAR, BoarRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HUANCAT, HuanCatModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.HUANCAT, HuanCatRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRAGON, DragonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DRAGON, DragonRenderer::new);

        EntityRendererRegistry.register(ModEntities.SPELL, SpellEntityRenderer::new);

        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.TEST_POISON, ((stack, mode, matrices, vertexConsumers, light, overlay) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            LivingEntity entity;
            //Optional<Entity> entity = EntityType.getEntityFromNbt(stack.getNbt(),client.world);
            if(client.world != null){
                entity = new SpiritFoxEntity(ModEntities.SPIRIT_FOX,client.world);
                NbtCompound nbt = stack.getOrCreateNbt().getCompound("SavedEntity");;
                if(nbt!=null) entity.readCustomDataFromNbt(nbt);
                matrices.push();
                // 1. Adjust for GUI/Hand positioning
                matrices.translate(0.5, 0.0, 0.5); // Center the entity
                //matrices.scale(0.5f, 0.5f, 0.5f);  // Scale to fit the item slot
                // 2. Use the Dispatcher to render
                EntityRenderDispatcher dispatcher = client.getEntityRenderDispatcher();
                dispatcher.setRenderShadows(false); // Items usually don't have shadows
                // The render method takes: entity, x, y, z, yaw, tickDelta, matrices, consumers, light
                dispatcher.render(entity, 0, 0, 0, 0.0f, 1.0f, matrices, vertexConsumers, light);
                matrices.pop();
            }
        }));

        BuiltinItemRendererRegistry.INSTANCE.register(ModBlocks.APERTURE, ((stack, mode, matrices, vertexConsumers, light, overlay) -> {
            
        }));

        ModelLoadingPlugin.register(pluginContext -> {
            pluginContext.addModels(new Identifier(BCMod.MOD_ID, "block/aperture"));
            pluginContext.modifyModelBeforeBake().register(((model, context) -> {
                if (context.id().getNamespace().equals(BCMod.MOD_ID) && context.id().getPath().equals("tank")) {
                    return new UnbakedApertureModel(model);
                }
                return model;
            }));
        });

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null && world.getBlockEntity(pos) instanceof ApertureBlockEntity ap) {
                if (tintIndex == 0) return 12414341; // Casing color
                if (tintIndex == 1) return ap.getWaterColor();
            }
            return -1;
        }, ModBlocks.APERTURE);
    }
}
