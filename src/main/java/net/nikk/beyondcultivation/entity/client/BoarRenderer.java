package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.BoarEntity;
import net.nikk.beyondcultivation.entity.custom.QilinEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;

public class BoarRenderer extends MobEntityRenderer<BoarEntity, BoarModel<BoarEntity>> {
    public BoarRenderer(EntityRendererFactory.Context context) {
        super(context, new BoarModel<>(context.getPart(ModModelLayers.BOAR)), 1.0f);
    }

    @Override
    public Identifier getTexture(BoarEntity entity) {
        return new Identifier(BCMod.MOD_ID,"textures/entity/boar.png");
    }

    @Override
    public void render(BoarEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(1f, 1f, 1f);
        } else {
            matrixStack.scale(1.5f, 1.5f, 1.5f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
