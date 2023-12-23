package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nikk.beyondcultivation.entity.animations.ModAnimations;
import net.nikk.beyondcultivation.entity.custom.RedPandaEntity;

public class RedPandaModel <T extends RedPandaEntity> extends SinglePartEntityModel<T> {
    private final ModelPart redpanda;
    private final ModelPart head;
    public RedPandaModel(ModelPart root) {
        this.redpanda = root.getChild("redpanda");
        this.head = redpanda.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData redpanda = modelPartData.addChild("redpanda", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -5.0F, -9.0F, 7.0F, 5.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, 3.0F));

        ModelPartData legRF = redpanda.addChild("legRF", ModelPartBuilder.create().uv(25, 0).cuboid(-1.5F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, -8.0F));

        ModelPartData legRB = redpanda.addChild("legRB", ModelPartBuilder.create().uv(0, 16).cuboid(-1.5F, 2.0F, -1.5F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 0.5F));

        ModelPartData legLB = redpanda.addChild("legLB", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 2.0F, -1.5F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -2.0F, 0.5F));

        ModelPartData tail = redpanda.addChild("tail", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -1.5F, 2.0F, 4.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -0.5F));

        ModelPartData head = redpanda.addChild("head", ModelPartBuilder.create().uv(17, 16).cuboid(-3.6F, -3.0F, -2.0F, 7.2F, 5.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 6).cuboid(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(25, 6).cuboid(1.5F, -5.0F, -1.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 29).cuboid(-4.5F, -5.0F, -1.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, -11.0F));

        ModelPartData legLF = redpanda.addChild("legLF", ModelPartBuilder.create().uv(26, 25).cuboid(-0.5F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, -8.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(RedPandaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ModAnimations.TIGER_STATIC, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.TIGER_STATIC, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.TIGER_STATIC, ageInTicks, 1f);
        this.updateAnimation(entity.sitAnimationState, ModAnimations.TIGER_STATIC, ageInTicks, 1f);
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public ModelPart getPart() {
        return redpanda;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        redpanda.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
