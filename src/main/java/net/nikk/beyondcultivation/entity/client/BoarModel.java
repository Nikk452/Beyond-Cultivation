package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nikk.beyondcultivation.entity.animations.ModAnimations;
import net.nikk.beyondcultivation.entity.custom.BoarEntity;
import net.nikk.beyondcultivation.entity.custom.QilinEntity;

public class BoarModel<T extends BoarEntity> extends SinglePartEntityModel<T> {
    private final ModelPart boar;
    private final ModelPart head;
    public BoarModel(ModelPart root) {
        this.boar = root.getChild("boar");
        this.head = boar.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData boar = modelPartData.addChild("boar", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -12.0F, -5.0F, 14.0F, 8.0F, 10.0F, new Dilation(0.0F))
                .uv(40, 23).cuboid(-5.0F, -14.0F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(36, 19).cuboid(-3.0F, -15.0F, 0.0F, 6.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 23.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData head = boar.addChild("head", ModelPartBuilder.create().uv(36, 36).cuboid(-5.0F, -7.0F, 0.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 19).cuboid(-7.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -9.0F, 0.0F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(25, 19).cuboid(-2.0F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = nose.addChild("cube_r1", ModelPartBuilder.create().uv(5, 0).cuboid(0.0F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 2.0F, -0.1745F, 0.0F, 0.0F));

        ModelPartData cube_r2 = nose.addChild("cube_r2", ModelPartBuilder.create().uv(5, 0).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, -2.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData ear1 = head.addChild("ear1", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -4.0F, 3.0F));

        ModelPartData cube_r3 = ear1.addChild("cube_r3", ModelPartBuilder.create().uv(0, 19).cuboid(8.0F, -7.0F, -1.5F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 4.0F, -1.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData ear2 = head.addChild("ear2", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -4.0F, -3.0F));

        ModelPartData cube_r4 = ear2.addChild("cube_r4", ModelPartBuilder.create().uv(0, 19).cuboid(8.0F, -7.0F, -0.5F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 4.0F, 1.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData tail = boar.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, -10.0F, 0.0F));

        ModelPartData leg2 = boar.addChild("leg2", ModelPartBuilder.create().uv(33, 27).cuboid(-2.0F, 0.75F, -2.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -4.75F, -3.0F));

        ModelPartData cube_r5 = leg2.addChild("cube_r5", ModelPartBuilder.create().uv(39, 39).cuboid(-7.0F, 0.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.7067F, 4.75F, -1.3233F, 0.0F, -0.3927F, 0.0F));

        ModelPartData cube_r6 = leg2.addChild("cube_r6", ModelPartBuilder.create().uv(39, 6).cuboid(-7.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.7067F, 4.75F, 0.3233F, 0.0F, 0.3927F, 0.0F));

        ModelPartData leg1 = boar.addChild("leg1", ModelPartBuilder.create().uv(26, 36).cuboid(-2.0F, -1.25F, -1.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -2.75F, 3.0F));

        ModelPartData cube_r7 = leg1.addChild("cube_r7", ModelPartBuilder.create().uv(39, 3).cuboid(-7.0F, 0.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.7067F, 2.75F, -0.3233F, 0.0F, -0.3927F, 0.0F));

        ModelPartData cube_r8 = leg1.addChild("cube_r8", ModelPartBuilder.create().uv(39, 0).cuboid(-7.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.7067F, 2.75F, 1.3233F, 0.0F, 0.3927F, 0.0F));

        ModelPartData leg3 = boar.addChild("leg3", ModelPartBuilder.create().uv(0, 36).cuboid(-1.0F, 0.0F, -2.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -4.0F, -3.0F));

        ModelPartData cube_r9 = leg3.addChild("cube_r9", ModelPartBuilder.create().uv(5, 5).cuboid(-7.0F, 0.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.7067F, 4.0F, -1.3233F, 0.0F, -0.3927F, 0.0F));

        ModelPartData cube_r10 = leg3.addChild("cube_r10", ModelPartBuilder.create().uv(39, 42).cuboid(-7.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.7067F, 4.0F, 0.3233F, 0.0F, 0.3927F, 0.0F));

        ModelPartData leg4 = boar.addChild("leg4", ModelPartBuilder.create().uv(13, 36).cuboid(-1.0F, 0.0F, -1.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -4.0F, 3.0F));

        ModelPartData cube_r11 = leg4.addChild("cube_r11", ModelPartBuilder.create().uv(23, 36).cuboid(-7.0F, 0.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.7067F, 4.0F, -0.3233F, 0.0F, -0.3927F, 0.0F));

        ModelPartData cube_r12 = leg4.addChild("cube_r12", ModelPartBuilder.create().uv(10, 36).cuboid(-7.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.7067F, 4.0F, 1.3233F, 0.0F, 0.3927F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public ModelPart getPart() {
        return this.boar;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);

        this.animateMovement(ModAnimations.BOAR_WALK, limbAngle, limbDistance, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.BOAR_IDLE, animationProgress, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.BOAR_ATTACK, animationProgress, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        boar.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
