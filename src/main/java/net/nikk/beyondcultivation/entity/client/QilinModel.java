package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.nikk.beyondcultivation.entity.animations.ModAnimations;
import net.nikk.beyondcultivation.entity.custom.QilinEntity;

public class QilinModel<T extends QilinEntity> extends SinglePartEntityModel<T> {
    private final ModelPart qilin;
    public QilinModel(ModelPart root) {
        this.qilin = root.getChild("qilin");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData qilin = modelPartData.addChild("qilin", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -20.0F, -9.0F, 10.0F, 10.0F, 21.0F, new Dilation(0.0F))
                .uv(63, 0).cuboid(-1.0F, -20.5F, -9.0F, 2.0F, 1.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData tail = qilin.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.8952F, 0.3327F));

        ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(13, 98).cuboid(-1.0F, -9.0F, 23.5F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create(), ModelTransform.pivot(-24.8952F, -16.8952F, 18.0F));

        ModelPartData cube_r2 = tail2.addChild("cube_r2", ModelPartBuilder.create().uv(37, 102).cuboid(-10.25F, -0.25F, 23.5F, 5.25F, 0.75F, 2.0F, new Dilation(0.0F))
                .uv(37, 98).cuboid(-15.25F, -0.25F, 22.5F, 5.25F, 0.75F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.8241F, 0.7519F, -1.933F));

        ModelPartData cube_r3 = tail2.addChild("cube_r3", ModelPartBuilder.create().uv(22, 98).cuboid(-7.25F, -0.75F, -24.5F, 5.25F, 0.75F, 2.0F, new Dilation(0.0F))
                .uv(22, 102).cuboid(-2.25F, -0.75F, -25.5F, 5.25F, 0.75F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -0.6655F, -1.8241F, -0.7519F, 1.933F));

        ModelPartData cube_r4 = tail2.addChild("cube_r4", ModelPartBuilder.create().uv(51, 84).cuboid(-1.0F, -1.0F, 23.5F, 2.0F, 10.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(24.8952F, 16.8952F, -18.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r5 = tail3.addChild("cube_r5", ModelPartBuilder.create().uv(0, 84).cuboid(-22.25F, -0.25F, 20.5F, 7.25F, 0.75F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.8241F, 0.7519F, -1.933F));

        ModelPartData cube_r6 = tail3.addChild("cube_r6", ModelPartBuilder.create().uv(60, 84).cuboid(-2.0F, 11.25F, 24.15F, 4.0F, 8.25F, 0.75F, new Dilation(0.0F))
                .uv(0, 109).cuboid(-1.0F, 9.5F, 23.5F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(24.8952F, 16.8952F, -18.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r7 = tail3.addChild("cube_r7", ModelPartBuilder.create().uv(30, 79).cuboid(2.75F, -0.75F, -27.75F, 7.25F, 0.75F, 3.25F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -0.6655F, -1.8241F, -0.7519F, 1.933F));

        ModelPartData legRF = qilin.addChild("legRF", ModelPartBuilder.create().uv(15, 69).cuboid(-5.0F, -15.0F, -9.0F, 3.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData head = qilin.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(9, 109).cuboid(11.3F, -27.75F, -13.0F, 0.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2608F, -0.0226F, -0.3957F));

        ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(12, 109).cuboid(-11.3F, -27.75F, -13.0F, 0.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2608F, 0.0226F, 0.3957F));

        ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(30, 69).cuboid(-2.0F, -32.75F, 2.5F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 98).cuboid(-1.0F, -33.25F, 2.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(17, 54).cuboid(2.0F, -34.25F, 7.5F, 1.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 54).cuboid(-3.0F, -34.25F, 7.5F, 1.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(37, 32).cuboid(-2.0F, -34.25F, 7.5F, 4.0F, 14.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r11 = head.addChild("cube_r11", ModelPartBuilder.create().uv(25, 109).cuboid(-1.0F, -27.0F, -27.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(32, 114).cuboid(-4.0F, -31.0F, -26.25F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(37, 109).cuboid(-3.0F, -29.0F, -26.25F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 119).cuboid(-2.0F, -28.0F, -26.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(15, 109).cuboid(-2.0F, -33.0F, -26.25F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 109).cuboid(1.0F, -33.0F, -26.25F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(25, 113).cuboid(3.0F, -31.0F, -26.25F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(32, 109).cuboid(2.0F, -29.0F, -26.25F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(5, 119).cuboid(1.0F, -28.0F, -26.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r12 = head.addChild("cube_r12", ModelPartBuilder.create().uv(21, 84).cuboid(-2.0F, -33.25F, 11.5F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.8165F, 0.2443F, 0.2519F));

        ModelPartData cube_r13 = head.addChild("cube_r13", ModelPartBuilder.create().uv(36, 84).cuboid(1.0F, -33.25F, 11.5F, 1.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.8165F, -0.2443F, -0.2519F));

        ModelPartData cube_r14 = head.addChild("cube_r14", ModelPartBuilder.create().uv(0, 32).cuboid(-1.0F, -27.0F, -26.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.5821F, -14.3955F, -0.7854F, 0.0F, 0.0F));

        ModelPartData lehRB = qilin.addChild("lehRB", ModelPartBuilder.create().uv(0, 69).cuboid(-5.0F, -15.0F, 8.0F, 3.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData legLB = qilin.addChild("legLB", ModelPartBuilder.create().uv(34, 54).cuboid(2.0F, -15.0F, 8.0F, 3.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData legLF = qilin.addChild("legLF", ModelPartBuilder.create().uv(49, 54).cuboid(2.0F, -15.0F, -9.0F, 3.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public ModelPart getPart() {
        return this.qilin;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        //this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(ModAnimations.TIGER_STATIC, limbAngle, limbDistance, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
        this.updateAnimation(entity.sitAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        qilin.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
