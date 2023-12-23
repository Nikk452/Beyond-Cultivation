package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.QilinEntity;
import net.nikk.beyondcultivation.entity.custom.RedPandaEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;

public class QilinRenderer extends MobEntityRenderer<QilinEntity, QilinModel<QilinEntity>> {
    public QilinRenderer(EntityRendererFactory.Context context) {
        super(context, new QilinModel<>(context.getPart(ModModelLayers.QILIN)), 1.0f);
    }

    @Override
    public Identifier getTexture(QilinEntity entity) {
        return new Identifier(BCMod.MOD_ID,"textures/entity/qilin.png");
    }

    @Override
    public void render(QilinEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(1f, 1f, 1f);
        } else {
            matrixStack.scale(1.5f, 1.5f, 1.5f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
