package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.nikk.beyondcultivation.entity.animations.ModAnimations;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;

public class SpiritFoxModel <T extends SpiritFoxEntity> extends SinglePartEntityModel<T> {

    private final ModelPart spirit_fox;

    public SpiritFoxModel(ModelPart root) {
        this.spirit_fox = root.getChild("spirit_fox");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData spirit_fox = modelPartData.addChild("spirit_fox", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -17.0F, -2.0F, 12.0F, 10.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 23.0F, -6.0F));

        ModelPartData head = spirit_fox.addChild("head", ModelPartBuilder.create().uv(37, 111).cuboid(-4.0F, -11.0F, -16.0F, 8.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(65, 0).cuboid(-8.0F, -19.0F, -10.0F, 16.0F, 12.0F, 8.0F, new Dilation(0.0F))
                .uv(98, 143).cuboid(-8.0F, -23.0F, -9.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(11, 156).cuboid(-6.0F, -23.0F, -8.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(87, 143).cuboid(-4.0F, -23.0F, -9.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(68, 149).cuboid(-8.0F, -25.0F, -9.0F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(20, 156).cuboid(4.0F, -23.0F, -8.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(109, 143).cuboid(6.0F, -23.0F, -9.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 156).cuboid(2.0F, -23.0F, -9.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(68, 143).cuboid(4.0F, -25.0F, -9.0F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = spirit_fox.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 4.0F));

        ModelPartData middle = tail.addChild("middle", ModelPartBuilder.create().uv(0, 111).cuboid(-3.0F, -13.5F, 17.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(123, 52).cuboid(-3.0F, -13.5F, 29.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F))
                .uv(125, 130).cuboid(-2.0F, -12.5F, 9.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData downright = tail.addChild("downright", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = downright.addChild("cube_r1", ModelPartBuilder.create().uv(0, 130).cuboid(-2.0F, -15.5F, 5.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(111, 73).cuboid(-3.0F, -16.5F, 13.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(82, 31).cuboid(-3.0F, -16.5F, 25.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3225F, -0.2815F, 0.1201F));

        ModelPartData downleft = tail.addChild("downleft", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r2 = downleft.addChild("cube_r2", ModelPartBuilder.create().uv(25, 130).cuboid(-2.0F, -15.5F, 5.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 92).cuboid(-3.0F, -16.5F, 13.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(123, 31).cuboid(-3.0F, -16.5F, 25.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3225F, 0.2815F, -0.1201F));

        ModelPartData upright = tail.addChild("upright", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r3 = upright.addChild("cube_r3", ModelPartBuilder.create().uv(75, 130).cuboid(0.0F, -14.5F, 9.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(41, 52).cuboid(-1.0F, -15.5F, 29.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F))
                .uv(74, 92).cuboid(-1.0F, -15.5F, 17.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0873F, -0.3491F, 0.0F));

        ModelPartData upleft = tail.addChild("upleft", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r4 = upleft.addChild("cube_r4", ModelPartBuilder.create().uv(100, 130).cuboid(-4.0F, -14.5F, 9.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(111, 92).cuboid(-5.0F, -15.5F, 17.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(82, 52).cuboid(-5.0F, -15.5F, 29.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0873F, 0.3491F, 0.0F));

        ModelPartData right = tail.addChild("right", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 1.0F));

        ModelPartData cube_r5 = right.addChild("cube_r5", ModelPartBuilder.create().uv(41, 31).cuboid(-3.0F, -16.5F, 25.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F))
                .uv(74, 73).cuboid(-3.0F, -16.5F, 13.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(116, 111).cuboid(-2.0F, -15.5F, 5.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2932F, -0.6098F, 0.2527F));

        ModelPartData left = tail.addChild("left", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData cube_r6 = left.addChild("cube_r6", ModelPartBuilder.create().uv(0, 31).cuboid(-3.0F, -16.5F, 25.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F))
                .uv(37, 73).cuboid(-3.0F, -16.5F, 13.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(91, 111).cuboid(-2.0F, -15.5F, 5.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2001F, 0.567F, -0.2421F));

        ModelPartData down = tail.addChild("down", ModelPartBuilder.create(), ModelTransform.of(0.25F, -7.0F, -8.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r7 = down.addChild("cube_r7", ModelPartBuilder.create().uv(0, 52).cuboid(-3.0F, -11.5F, 34.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F))
                .uv(37, 92).cuboid(-3.0F, -11.5F, 22.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F))
                .uv(50, 130).cuboid(-2.0F, -10.5F, 14.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData up = tail.addChild("up", ModelPartBuilder.create(), ModelTransform.of(0.0F, -7.0F, -8.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData cube_r8 = up.addChild("cube_r8", ModelPartBuilder.create().uv(114, 0).cuboid(-3.0F, -1.5F, 37.0F, 6.0F, 6.0F, 14.0F, new Dilation(0.0F))
                .uv(66, 111).cuboid(-2.0F, -0.5F, 17.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 73).cuboid(-3.0F, -1.5F, 25.0F, 6.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.0036F, 0.0F, 0.0F));

        ModelPartData bone8 = spirit_fox.addChild("bone8", ModelPartBuilder.create().uv(51, 143).cuboid(-6.0F, -7.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bone9 = spirit_fox.addChild("bone9", ModelPartBuilder.create().uv(34, 143).cuboid(2.0F, -7.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bone10 = spirit_fox.addChild("bone10", ModelPartBuilder.create().uv(0, 143).cuboid(-6.0F, -7.0F, 12.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bone11 = spirit_fox.addChild("bone11", ModelPartBuilder.create().uv(17, 143).cuboid(2.0F, -7.0F, 12.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Override
    public ModelPart getPart() {
        return spirit_fox;
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
        spirit_fox.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
