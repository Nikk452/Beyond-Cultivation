package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.DragonEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;

public class DragonRenderer extends MobEntityRenderer<DragonEntity, DragonModel<DragonEntity>> {
    public DragonRenderer(EntityRendererFactory.Context context) {
        super(context, new DragonModel<>(context.getPart(ModModelLayers.DRAGON)), 1.0f);
    }

    @Override
    public Identifier getTexture(DragonEntity entity) {
        return new Identifier(BCMod.MOD_ID,"textures/entity/dragon.png");
    }

    @Override
    public void render(DragonEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(1f, 1f, 1f);
        } else {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
