package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.RedPandaEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;

public class RedPandaRenderer extends MobEntityRenderer<RedPandaEntity, RedPandaModel<RedPandaEntity>> {
    public RedPandaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RedPandaModel<>(ctx.getPart(ModModelLayers.RED_PANDA)), 1.0f);
    }

    @Override
    public Identifier getTexture(RedPandaEntity entity) {
        return new Identifier(BCMod.MOD_ID,"textures/entity/red_panda.png");
    }

    @Override
    public void render(RedPandaEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
