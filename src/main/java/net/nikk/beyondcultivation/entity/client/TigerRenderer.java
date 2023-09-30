package net.nikk.beyondcultivation.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;
import net.nikk.beyondcultivation.entity.variant.TigerVariant;

import java.util.Map;

public class TigerRenderer extends MobEntityRenderer<TigerEntity, TigerModel<TigerEntity>> {
    private static final Map<TigerVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(TigerVariant.class), map -> {
                map.put(TigerVariant.DEFAULT,
                        new Identifier(BCMod.MOD_ID, "textures/entity/tiger.png"));
                map.put(TigerVariant.GREY,
                        new Identifier(BCMod.MOD_ID, "textures/entity/tiger.png"));
            });

    public TigerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new TigerModel<>(ctx.getPart(ModModelLayers.TIGER)), 1.0f);
    }

    @Override
    public Identifier getTexture(TigerEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(TigerEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
