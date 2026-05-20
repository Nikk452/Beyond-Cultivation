package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nikk.beyondcultivation.entity.animations.ModAnimations;
import net.nikk.beyondcultivation.entity.custom.DragonEntity;
import net.nikk.beyondcultivation.entity.custom.HuancatEntity;

public class HuanCatModel <T extends HuancatEntity> extends SinglePartEntityModel<T> {
    private final ModelPart huancat;
    private final ModelPart head;
    public HuanCatModel(ModelPart root) {
        this.huancat = root.getChild("huancat");
        this.head = this.huancat.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData huancat = modelPartData.addChild("huancat", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -11.0F, 6.0F, 5.0F, 14.0F, new Dilation(0.0F))
                .uv(3, 53).cuboid(-2.75F, -3.0F, -13.0F, 5.5F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 18.0F, 4.0F));

        ModelPartData leg4 = huancat.addChild("leg4", ModelPartBuilder.create().uv(22, 57).cuboid(-3.0F, 1.0F, 0.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg3 = huancat.addChild("leg3", ModelPartBuilder.create().uv(0, 61).cuboid(1.0F, 1.0F, 0.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg2 = huancat.addChild("leg2", ModelPartBuilder.create().uv(9, 72).cuboid(1.0F, 1.0F, -9.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg1 = huancat.addChild("leg1", ModelPartBuilder.create().uv(30, 70).cuboid(-3.0F, 1.0F, -9.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail1 = huancat.addChild("tail1", ModelPartBuilder.create().uv(30, 44).cuboid(-1.5F, -1.25F, -0.75F, 3.0F, 2.5F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 2.75F, 0.2182F, 0.0F, 0.0F));

        ModelPartData bone = tail1.addChild("bone", ModelPartBuilder.create().uv(95, 73).cuboid(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 6.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 2.25F, 0.4363F, 0.0F, 0.0F));

        ModelPartData bone2 = bone.addChild("bone2", ModelPartBuilder.create().uv(69, 20).cuboid(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(75, 58).cuboid(-2.25F, -1.75F, 7.0F, 4.5F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 5.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData tail2 = huancat.addChild("tail2", ModelPartBuilder.create().uv(93, 5).cuboid(-2.4751F, -1.25F, 7.0608F, 3.0F, 2.5F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, -2.0F, -4.0F, 0.0F, 0.8727F, 0.0F));

        ModelPartData bone3 = tail2.addChild("bone3", ModelPartBuilder.create().uv(63, 73).cuboid(-2.2251F, -1.5F, 0.0608F, 4.0F, 3.0F, 6.5F, new Dilation(0.0F)), ModelTransform.of(-0.75F, 0.0F, 10.0F, 0.48F, 0.0F, 0.0F));

        ModelPartData bone4 = bone3.addChild("bone4", ModelPartBuilder.create().uv(37, 20).cuboid(-2.7251F, -2.0F, 0.0608F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(40, 56).cuboid(-2.4751F, -1.75F, 7.0608F, 4.5F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 5.0F, 0.48F, 0.0F, 0.0F));

        ModelPartData tail3 = huancat.addChild("tail3", ModelPartBuilder.create().uv(51, 44).cuboid(3.6532F, -1.25F, 2.0815F, 3.0F, 2.5F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, -2.0F, -4.0F, 0.0F, -0.8727F, 0.0F));

        ModelPartData bone5 = tail3.addChild("bone5", ModelPartBuilder.create().uv(38, 85).cuboid(-2.0968F, -1.5F, 0.0815F, 4.0F, 3.0F, 6.5F, new Dilation(0.0F)), ModelTransform.of(5.25F, 0.0F, 5.0F, 0.48F, 0.0F, 0.0F));

        ModelPartData bone6 = bone5.addChild("bone6", ModelPartBuilder.create().uv(0, 32).cuboid(-2.5968F, -2.0F, 0.0815F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F))
                .uv(99, 56).cuboid(-2.3468F, -1.75F, 7.0815F, 4.5F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 5.0F, 0.48F, 0.0F, 0.0F));

        ModelPartData head = huancat.addChild("head", ModelPartBuilder.create().uv(47, 0).cuboid(-1.2441F, -3.7912F, -5.8646F, 8.0F, 5.0F, 8.0F, new Dilation(0.0F))
                .uv(80, 39).cuboid(-1.4941F, 1.2088F, -6.1146F, 8.5F, 2.0F, 8.5F, new Dilation(0.0F))
                .uv(3, 3).cuboid(2.2559F, -2.2912F, -5.9396F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.7559F, -6.2088F, -9.1354F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(29, 122).cuboid(4.6F, -9.4F, -5.4F, 0.8F, 2.4F, 0.8F, new Dilation(0.0F))
                .uv(4, 119).cuboid(4.2F, -7.8F, -5.8F, 1.6F, 4.0F, 1.6F, new Dilation(0.0F))
                .uv(18, 107).cuboid(3.8F, -4.6F, -6.2F, 2.4F, 4.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7025F, 0.2615F, 0.5582F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(63, 112).cuboid(2.418F, -9.672F, -6.882F, 0.744F, 2.232F, 0.744F, new Dilation(0.0F))
                .uv(43, 107).cuboid(2.046F, -8.184F, -7.254F, 1.488F, 3.72F, 1.488F, new Dilation(0.0F))
                .uv(61, 99).cuboid(1.674F, -5.208F, -7.626F, 2.232F, 3.72F, 2.232F, new Dilation(0.0F)), ModelTransform.of(0.1929F, 3.3246F, 1.557F, -0.7058F, 0.4981F, 0.8971F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(30, 99).cuboid(-5.4F, -9.4F, -5.4F, 0.8F, 2.4F, 0.8F, new Dilation(0.0F))
                .uv(6, 99).cuboid(-5.8F, -7.8F, -5.8F, 1.6F, 4.0F, 1.6F, new Dilation(0.0F))
                .uv(23, 84).cuboid(-6.2F, -4.6F, -6.2F, 2.4F, 4.0F, 2.4F, new Dilation(0.0F)), ModelTransform.of(5.5119F, 0.0F, 0.0F, -0.7025F, -0.2615F, -0.5582F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(80, 113).cuboid(-3.162F, -9.672F, -6.882F, 0.744F, 2.232F, 0.744F, new Dilation(0.0F))
                .uv(4, 86).cuboid(-3.534F, -8.184F, -7.254F, 1.488F, 3.72F, 1.488F, new Dilation(0.0F))
                .uv(52, 65).cuboid(-3.906F, -5.208F, -7.626F, 2.232F, 3.72F, 2.232F, new Dilation(0.0F)), ModelTransform.of(5.319F, 3.3246F, 1.557F, -0.7058F, -0.4981F, -0.8971F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public ModelPart getPart() {
        return huancat;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);
        this.animateMovement(ModAnimations.TIGER_STATIC, limbAngle, limbDistance, 2f, 2.5f);
        //this.updateAnimation(entity.idleAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
        //this.updateAnimation(entity.attackAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
        //this.updateAnimation(entity.sitAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        huancat.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
