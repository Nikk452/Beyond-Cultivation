package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nikk.beyondcultivation.entity.animations.ModAnimations;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;

public class TigerModel<T extends TigerEntity> extends SinglePartEntityModel<T> {
    private final ModelPart tiger;
    private final ModelPart head;
    public TigerModel(ModelPart root) {
        this.tiger = root.getChild("body");
        this.head = tiger.getChild("bodyfront").getChild("neck").getChild("neck2");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -8.5F, -11.0F, 16.0F, 16.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

        ModelPartData bodyfront = body.addChild("bodyfront", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, -9.0F));

        ModelPartData cube26_r1 = bodyfront.addChild("cube26_r1", ModelPartBuilder.create().uv(0, 37).cuboid(-10.0F, -20.0F, 0.0F, 18.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 10.405F, -2.6591F, 0.3927F, 0.0F, 0.0F));

        ModelPartData legLF = bodyfront.addChild("legLF", ModelPartBuilder.create(), ModelTransform.pivot(12.0F, -2.0F, 0.0F));

        ModelPartData cube7_r1 = legLF.addChild("cube7_r1", ModelPartBuilder.create().uv(0, 87).cuboid(7.0F, -11.75F, 5.0F, 7.0F, 10.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 12.405F, -2.6591F, 0.7854F, 0.0F, 0.0F));

        ModelPartData legLF2 = legLF.addChild("legLF2", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 1.0F, 0.0F));

        ModelPartData cube6_r1 = legLF2.addChild("cube6_r1", ModelPartBuilder.create().uv(112, 66).cuboid(8.0F, -9.0F, 2.0F, 5.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, 11.405F, -2.6591F, 0.3927F, 0.0F, 0.0F));

        ModelPartData legLF3 = legLF2.addChild("legLF3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.0F, -3.0F, 4.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 7.0F, 2.0F));

        ModelPartData pawLF = legLF3.addChild("pawLF", ModelPartBuilder.create().uv(105, 125).cuboid(-0.55F, -1.0F, -7.0F, 5.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 10.0F, 1.0F));

        ModelPartData cube4_r1 = pawLF.addChild("cube4_r1", ModelPartBuilder.create().uv(53, 0).cuboid(3.6089F, -6.485F, -2.0F, 3.0F, 2.975F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.5589F, 5.5F, -0.7605F, 0.0F, 0.3927F, 0.0F));

        ModelPartData legRF = bodyfront.addChild("legRF", ModelPartBuilder.create(), ModelTransform.pivot(-12.0F, -2.0F, 0.0F));

        ModelPartData cube_r1 = legRF.addChild("cube_r1", ModelPartBuilder.create().uv(25, 97).cuboid(-14.0F, -11.75F, 5.0F, 7.0F, 10.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(13.0F, 12.405F, -2.6591F, 0.7854F, 0.0F, 0.0F));

        ModelPartData legRF2 = legRF.addChild("legRF2", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 1.0F, 0.0F));

        ModelPartData cube12_r1 = legRF2.addChild("cube12_r1", ModelPartBuilder.create().uv(87, 114).cuboid(-13.0F, -9.0F, 2.0F, 5.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(11.0F, 11.405F, -2.6591F, 0.3927F, 0.0F, 0.0F));

        ModelPartData legRF3 = legRF2.addChild("legRF3", ModelPartBuilder.create().uv(26, 118).cuboid(-2.5F, -2.0F, -3.0F, 4.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 7.0F, 2.0F));

        ModelPartData pawRF = legRF3.addChild("pawRF", ModelPartBuilder.create().uv(64, 126).cuboid(-4.45F, -1.0F, -7.0F, 5.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 10.0F, 1.0F));

        ModelPartData cube11_r1 = pawRF.addChild("cube11_r1", ModelPartBuilder.create().uv(53, 7).cuboid(-6.6089F, -6.485F, -2.0F, 3.0F, 2.975F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.5589F, 5.5F, -0.7605F, 0.0F, -0.3927F, 0.0F));

        ModelPartData neck = bodyfront.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, -9.0F));

        ModelPartData cube10_r1 = neck.addChild("cube10_r1", ModelPartBuilder.create().uv(0, 69).cuboid(-6.0F, -18.095F, 4.0127F, 14.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 16.9674F, 5.5F, 0.7854F, 0.0F, 0.0F));

        ModelPartData neck2 = neck.addChild("neck2", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 1.9674F, 1.5F));

        ModelPartData cube13_r1 = neck2.addChild("cube13_r1", ModelPartBuilder.create().uv(99, 0).cuboid(-6.0F, -16.0F, -7.0F, 10.0F, 9.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 13.4376F, 4.8409F, 0.3927F, 0.0F, 0.0F));

        ModelPartData head = neck2.addChild("head", ModelPartBuilder.create().uv(93, 97).cuboid(-7.0F, -3.6334F, -7.8051F, 12.0F, 9.0F, 8.0F, new Dilation(0.0F))
                .uv(100, 53).cuboid(-5.0F, 0.3666F, -11.5551F, 8.0F, 4.0F, 9.25F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 4.5326F, -4.5F));

        ModelPartData cube25_r1 = head.addChild("cube25_r1", ModelPartBuilder.create().uv(0, 18).cuboid(16.85F, -24.6F, -23.0449F, 4.0F, 2.0F, 0.1F, new Dilation(0.0F)), ModelTransform.of(-6.0366F, 24.859F, 15.1699F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube23_r1 = head.addChild("cube23_r1", ModelPartBuilder.create().uv(8, 18).cuboid(-20.85F, -24.6F, -23.0449F, 4.0F, 2.0F, 0.1F, new Dilation(0.0F)), ModelTransform.of(4.0366F, 24.859F, 15.1699F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube22_r1 = head.addChild("cube22_r1", ModelPartBuilder.create().uv(130, 61).cuboid(17.1F, -21.1F, -23.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-6.2694F, 24.0354F, 15.2199F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube21_r1 = head.addChild("cube21_r1", ModelPartBuilder.create().uv(130, 91).cuboid(-22.1F, -21.1F, -23.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(4.2694F, 24.0354F, 15.2199F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube20_r1 = head.addChild("cube20_r1", ModelPartBuilder.create().uv(115, 35).cuboid(-12.5F, -22.25F, -22.975F, 6.5F, 2.0F, 7.975F, new Dilation(0.0F)), ModelTransform.of(2.039F, 19.2191F, 15.2199F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube19_r1 = head.addChild("cube19_r1", ModelPartBuilder.create().uv(113, 114).cuboid(-13.0F, -22.25F, -22.975F, 6.5F, 3.0F, 7.98F, new Dilation(0.0F)), ModelTransform.of(13.5251F, 11.9481F, 15.2199F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube18_r1 = head.addChild("cube18_r1", ModelPartBuilder.create().uv(101, 84).cuboid(-5.025F, -28.425F, -18.075F, 8.05F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 19.6166F, 15.1949F, 0.3927F, 0.0F, 0.0F));

        ModelPartData ears = head.addChild("ears", ModelPartBuilder.create(), ModelTransform.of(-1.0001F, -7.5F, -6.2801F, -0.3927F, 0.0F, 0.0F));

        ModelPartData cube15_r1 = ears.addChild("cube15_r1", ModelPartBuilder.create().uv(52, 37).cuboid(10.1945F, -24.7197F, -17.8128F, 4.0F, 5.0F, 0.35F, new Dilation(0.0F)), ModelTransform.of(-14.525F, 15.9481F, 21.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube14_r1 = ears.addChild("cube14_r1", ModelPartBuilder.create().uv(52, 42).cuboid(-14.1945F, -24.7197F, -17.8128F, 4.0F, 5.0F, 0.35F, new Dilation(0.0F)), ModelTransform.of(14.5253F, 15.9481F, 21.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(102, 23).cuboid(-5.0F, -0.5384F, -9.1459F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.905F, -2.6591F));

        ModelPartData bodyback = body.addChild("bodyback", ModelPartBuilder.create().uv(65, 28).cuboid(-7.0F, -27.5F, 10.0F, 14.0F, 14.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, 0.0F));

        ModelPartData bodyback2 = bodyback.addChild("bodyback2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 3.5F, -6.0F));

        ModelPartData cube28_r1 = bodyback2.addChild("cube28_r1", ModelPartBuilder.create().uv(56, 57).cuboid(-8.0F, -14.0F, -5.0F, 16.0F, 15.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -18.0F, 21.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData tail = bodyback2.addChild("tail", ModelPartBuilder.create().uv(53, 0).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -25.5F, 29.0F));

        ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(77, 4).cuboid(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 14.0F));

        ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(95, 35).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 14.0F));

        ModelPartData legRB = bodyback.addChild("legRB", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, -20.0F, 18.0F));

        ModelPartData cube36_r1 = legRB.addChild("cube36_r1", ModelPartBuilder.create().uv(65, 84).cuboid(-14.0F, -11.75F, 5.0F, 7.0F, 10.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, 12.405F, -3.2341F, 0.7854F, 0.0F, 0.0F));

        ModelPartData legRB2 = legRB.addChild("legRB2", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 1.0F, 0.0F));

        ModelPartData cube35_r1 = legRB2.addChild("cube35_r1", ModelPartBuilder.create().uv(0, 110).cuboid(-13.0F, -9.0F, 2.0F, 5.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 11.405F, -3.2341F, 0.3927F, 0.0F, 0.0F));

        ModelPartData legRB3 = legRB2.addChild("legRB3", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 8.0F, 3.0F));

        ModelPartData cube34_r1 = legRB3.addChild("cube34_r1", ModelPartBuilder.create().uv(130, 12).cuboid(-12.0F, -5.75F, 3.25F, 4.0F, 10.7F, 5.0F, new Dilation(0.0F)), ModelTransform.of(10.5F, 2.06F, -5.9171F, -0.3927F, 0.0F, 0.0F));

        ModelPartData pawRB = legRB3.addChild("pawRB", ModelPartBuilder.create().uv(125, 45).cuboid(-4.45F, -1.0F, -7.0F, 5.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 9.0F, -1.0F));

        ModelPartData cube33_r1 = pawRB.addChild("cube33_r1", ModelPartBuilder.create().uv(0, 44).cuboid(-6.6089F, -6.485F, -2.0F, 3.0F, 2.975F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.5589F, 5.5F, -0.7605F, 0.0F, -0.3927F, 0.0F));

        ModelPartData legLB = bodyback.addChild("legLB", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, -20.0F, 18.0F));

        ModelPartData cube3_r1 = legLB.addChild("cube3_r1", ModelPartBuilder.create().uv(29, 76).cuboid(7.0F, -11.75F, 5.0F, 7.0F, 10.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, 12.405F, -3.2341F, 0.7854F, 0.0F, 0.0F));

        ModelPartData legLB2 = legLB.addChild("legLB2", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 1.0F, 0.0F));

        ModelPartData cube40_r1 = legLB2.addChild("cube40_r1", ModelPartBuilder.create().uv(61, 105).cuboid(8.0F, -9.0F, 2.0F, 5.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 11.405F, -3.2341F, 0.3927F, 0.0F, 0.0F));

        ModelPartData legLB3 = legLB2.addChild("legLB3", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 8.0F, 3.0F));

        ModelPartData cube39_r1 = legLB3.addChild("cube39_r1", ModelPartBuilder.create().uv(0, 128).cuboid(8.0F, -5.75F, 3.25F, 4.0F, 10.7F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-10.5F, 2.06F, -5.9171F, -0.3927F, 0.0F, 0.0F));

        ModelPartData pawLB = legLB3.addChild("pawLB", ModelPartBuilder.create().uv(46, 123).cuboid(-0.55F, -1.0F, -7.0F, 5.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 9.0F, -1.0F));

        ModelPartData cube38_r1 = pawLB.addChild("cube38_r1", ModelPartBuilder.create().uv(0, 37).cuboid(3.6089F, -6.485F, -2.0F, 3.0F, 2.975F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.5589F, 5.5F, -0.7605F, 0.0F, 0.3927F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Override
    public void setAngles(TigerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ModAnimations.TIGER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.TIGER_IDLE, ageInTicks, 1f);
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
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        tiger.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return tiger;
    }
}
