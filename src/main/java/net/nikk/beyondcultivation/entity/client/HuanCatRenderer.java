package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.HuancatEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;

public class HuanCatRenderer extends MobEntityRenderer<HuancatEntity, HuanCatModel<HuancatEntity>> {
    public HuanCatRenderer(EntityRendererFactory.Context context) {
        super(context, new HuanCatModel<>(context.getPart(ModModelLayers.HUANCAT)), 1.0f);
    }

    @Override
    public Identifier getTexture(HuancatEntity entity) {
        return new Identifier(BCMod.MOD_ID,"textures/entity/huancat.png");
    }

    @Override
    public void render(HuancatEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.7f, 0.7f, 0.7f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
