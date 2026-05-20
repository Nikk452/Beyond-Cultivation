package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nikk.beyondcultivation.entity.animations.ModAnimations;
import net.nikk.beyondcultivation.entity.custom.DragonEntity;

public class DragonModel<T extends DragonEntity> extends SinglePartEntityModel<T> {
    private final ModelPart dragon;
    //private final ModelPart head;
    public DragonModel(ModelPart root) {
        this.dragon = root.getChild("everything");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData everything = modelPartData.addChild("everything", ModelPartBuilder.create(), ModelTransform.pivot(423.0F, -13.0F, 0.0F));

        ModelPartData Wholebody = everything.addChild("Wholebody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData ten = Wholebody.addChild("ten", ModelPartBuilder.create().uv(242, 44).cuboid(-55.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-376.0F, 0.0F, 0.0F));

        ModelPartData nine = Wholebody.addChild("nine", ModelPartBuilder.create().uv(234, 120).cuboid(-55.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-329.0F, 0.0F, 0.0F));

        ModelPartData eight = Wholebody.addChild("eight", ModelPartBuilder.create().uv(134, 228).cuboid(-8.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-329.0F, 0.0F, 0.0F));

        ModelPartData seven = Wholebody.addChild("seven", ModelPartBuilder.create().uv(0, 228).cuboid(-8.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-282.0F, 0.0F, 0.0F));

        ModelPartData six = Wholebody.addChild("six", ModelPartBuilder.create().uv(204, 0).cuboid(-55.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-188.0F, 0.0F, 0.0F));

        ModelPartData five = Wholebody.addChild("five", ModelPartBuilder.create().uv(134, 184).cuboid(-46.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-150.0F, 0.0F, 0.0F));

        ModelPartData four = Wholebody.addChild("four", ModelPartBuilder.create().uv(0, 184).cuboid(-8.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-141.0F, 0.0F, 0.0F));

        ModelPartData three = Wholebody.addChild("three", ModelPartBuilder.create().uv(100, 140).cuboid(-8.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-94.0F, 0.0F, 0.0F));

        ModelPartData two = Wholebody.addChild("two", ModelPartBuilder.create().uv(120, 96).cuboid(-8.0F, -20.0F, -10.0F, 47.0F, 24.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(-47.0F, 0.0F, 0.0F));

        ModelPartData one = Wholebody.addChild("one", ModelPartBuilder.create().uv(0, 307).cuboid(-8.0F, -20.0F, -11.0F, 26.0F, 24.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData WholeTail = Wholebody.addChild("WholeTail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Tail2 = WholeTail.addChild("Tail2", ModelPartBuilder.create().uv(240, 304).cuboid(39.0F, -10.0F, -6.0F, 47.0F, 16.0F, 11.0F, new Dilation(0.0F))
                .uv(124, 293).cuboid(86.0F, -10.0F, -6.0F, 47.0F, 16.0F, 11.0F, new Dilation(0.0F))
                .uv(234, 88).cuboid(-8.0F, -10.0F, -6.0F, 47.0F, 16.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(-705.0F, -6.0F, 0.0F));

        ModelPartData Tail1 = WholeTail.addChild("Tail1", ModelPartBuilder.create().uv(0, 272).cuboid(39.0F, -16.0F, -8.0F, 47.0F, 20.0F, 15.0F, new Dilation(0.0F))
                .uv(268, 199).cuboid(86.0F, -16.0F, -8.0F, 47.0F, 20.0F, 15.0F, new Dilation(0.0F))
                .uv(248, 164).cuboid(-8.0F, -16.0F, -8.0F, 47.0F, 20.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(-564.0F, -2.0F, 0.0F));

        ModelPartData Tail3 = WholeTail.addChild("Tail3", ModelPartBuilder.create().uv(314, 234).cuboid(39.0F, -6.0F, -4.0F, 47.0F, 12.0F, 7.0F, new Dilation(0.0F))
                .uv(124, 272).cuboid(-8.0F, -6.0F, -4.0F, 47.0F, 12.0F, 7.0F, new Dilation(0.0F))
                .uv(106, 0).cuboid(39.0F, -6.0F, -4.0F, 47.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-799.0F, -8.0F, 0.0F));

        ModelPartData Tail4 = WholeTail.addChild("Tail4", ModelPartBuilder.create().uv(318, 0).cuboid(39.0F, -6.0F, -3.0F, 47.0F, 10.0F, 5.0F, new Dilation(0.0F))
                .uv(314, 253).cuboid(-8.0F, -6.0F, -3.0F, 47.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-893.0F, -7.0F, 0.0F));

        ModelPartData wholehead = everything.addChild("wholehead", ModelPartBuilder.create(), ModelTransform.pivot(-398.0F, 40.0F, 0.0F));

        ModelPartData Hair = wholehead.addChild("Hair", ModelPartBuilder.create(), ModelTransform.pivot(450.7F, -41.4709F, 18.4847F));

        ModelPartData SmallhairR = Hair.addChild("SmallhairR", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -5.4F, -1.0F));

        ModelPartData SmallHair3 = SmallhairR.addChild("SmallHair3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r1 = SmallHair3.addChild("cube_r1", ModelPartBuilder.create().uv(95, 158).cuboid(-9.0F, -1.0F, 0.0F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r2 = SmallHair3.addChild("cube_r2", ModelPartBuilder.create().uv(326, 115).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair16 = SmallhairR.addChild("SmallHair16", ModelPartBuilder.create(), ModelTransform.of(38.4F, 10.0F, -8.0F, 0.0136F, 0.1915F, 0.202F));

        ModelPartData cube_r3 = SmallHair16.addChild("cube_r3", ModelPartBuilder.create().uv(225, 277).cuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.3F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r4 = SmallHair16.addChild("cube_r4", ModelPartBuilder.create().uv(338, 35).cuboid(-9.0F, -2.0F, -1.0F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair17 = SmallhairR.addChild("SmallHair17", ModelPartBuilder.create(), ModelTransform.of(38.3F, -9.0F, -8.0F, 0.0136F, 0.1915F, 0.202F));

        ModelPartData cube_r5 = SmallHair17.addChild("cube_r5", ModelPartBuilder.create().uv(84, 98).cuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.9F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r6 = SmallHair17.addChild("cube_r6", ModelPartBuilder.create().uv(338, 31).cuboid(-9.0F, -2.0F, -1.0F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair5 = SmallhairR.addChild("SmallHair5", ModelPartBuilder.create(), ModelTransform.of(16.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r7 = SmallHair5.addChild("cube_r7", ModelPartBuilder.create().uv(172, 291).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r8 = SmallHair5.addChild("cube_r8", ModelPartBuilder.create().uv(318, 15).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair15 = SmallhairR.addChild("SmallHair15", ModelPartBuilder.create(), ModelTransform.of(-23.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r9 = SmallHair15.addChild("cube_r9", ModelPartBuilder.create().uv(156, 291).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r10 = SmallHair15.addChild("cube_r10", ModelPartBuilder.create().uv(314, 268).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair6 = SmallhairR.addChild("SmallHair6", ModelPartBuilder.create(), ModelTransform.of(-18.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r11 = SmallHair6.addChild("cube_r11", ModelPartBuilder.create().uv(124, 291).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(140, 291).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r12 = SmallHair6.addChild("cube_r12", ModelPartBuilder.create().uv(302, 115).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair7 = SmallhairR.addChild("SmallHair7", ModelPartBuilder.create(), ModelTransform.of(-1.0F, -14.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r13 = SmallHair7.addChild("cube_r13", ModelPartBuilder.create().uv(286, 234).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(287, 241).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r14 = SmallHair7.addChild("cube_r14", ModelPartBuilder.create().uv(286, 236).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair8 = SmallhairR.addChild("SmallHair8", ModelPartBuilder.create(), ModelTransform.of(-21.0F, -5.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r15 = SmallHair8.addChild("cube_r15", ModelPartBuilder.create().uv(248, 245).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData SmallHair9 = SmallhairR.addChild("SmallHair9", ModelPartBuilder.create(), ModelTransform.of(12.0F, -10.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r16 = SmallHair9.addChild("cube_r16", ModelPartBuilder.create().uv(114, 245).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(130, 245).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r17 = SmallHair9.addChild("cube_r17", ModelPartBuilder.create().uv(278, 115).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair10 = SmallhairR.addChild("SmallHair10", ModelPartBuilder.create(), ModelTransform.of(3.0F, 11.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r18 = SmallHair10.addChild("cube_r18", ModelPartBuilder.create().uv(226, 74).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(240, 61).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r19 = SmallHair10.addChild("cube_r19", ModelPartBuilder.create().uv(264, 238).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair11 = SmallhairR.addChild("SmallHair11", ModelPartBuilder.create(), ModelTransform.of(-23.0F, -11.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r20 = SmallHair11.addChild("cube_r20", ModelPartBuilder.create().uv(219, 79).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(224, 72).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r21 = SmallHair11.addChild("cube_r21", ModelPartBuilder.create().uv(264, 234).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair12 = SmallhairR.addChild("SmallHair12", ModelPartBuilder.create(), ModelTransform.of(-23.0F, 14.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r22 = SmallHair12.addChild("cube_r22", ModelPartBuilder.create().uv(0, 202).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(204, 78).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r23 = SmallHair12.addChild("cube_r23", ModelPartBuilder.create().uv(254, 115).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair13 = SmallhairR.addChild("SmallHair13", ModelPartBuilder.create(), ModelTransform.of(16.0F, -14.0F, 0.1F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r24 = SmallHair13.addChild("cube_r24", ModelPartBuilder.create().uv(72, 181).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(186, 40).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r25 = SmallHair13.addChild("cube_r25", ModelPartBuilder.create().uv(248, 199).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair14 = SmallhairR.addChild("SmallHair14", ModelPartBuilder.create(), ModelTransform.of(-12.9F, 18.0F, 1.4F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r26 = SmallHair14.addChild("cube_r26", ModelPartBuilder.create().uv(40, 181).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(56, 181).cuboid(-6.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.5F, -0.0154F, -0.1739F, 0.0886F));

        ModelPartData cube_r27 = SmallHair14.addChild("cube_r27", ModelPartBuilder.create().uv(204, 74).cuboid(-9.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

        ModelPartData BigHairR = Hair.addChild("BigHairR", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData BigHair1 = BigHairR.addChild("BigHair1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData five_r1 = BigHair1.addChild("five_r1", ModelPartBuilder.create().uv(0, 81).cuboid(0.0F, -7.0F, -7.0F, 1.0F, 9.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-32.9107F, -34.4227F, 19.0699F, 0.0226F, 0.0407F, -1.5708F));

        ModelPartData four_r1 = BigHair1.addChild("four_r1", ModelPartBuilder.create().uv(194, 23).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 15.0F, 1.0F, new Dilation(0.01F)), ModelTransform.of(-19.2107F, -29.0227F, 18.0699F, -0.0791F, -0.0368F, -1.1766F));

        ModelPartData three_r1 = BigHair1.addChild("three_r1", ModelPartBuilder.create().uv(89, 307).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-6.5107F, -20.9227F, 13.8699F, -0.3025F, -0.0226F, -1.0026F));

        ModelPartData two_r1 = BigHair1.addChild("two_r1", ModelPartBuilder.create().uv(204, 55).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 13.8699F, 0.0F, 0.0F, -0.48F));

        ModelPartData one_r1 = BigHair1.addChild("one_r1", ModelPartBuilder.create().uv(134, 184).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair2 = BigHairR.addChild("BigHair2", ModelPartBuilder.create(), ModelTransform.of(-5.0F, -15.0F, 0.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData six_r1 = BigHair2.addChild("six_r1", ModelPartBuilder.create().uv(4, 22).cuboid(0.0F, -7.0F, -7.0F, 1.0F, 9.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-34.3107F, -34.5227F, 15.9699F, 0.0226F, 0.0407F, -1.5708F));

        ModelPartData five_r2 = BigHair2.addChild("five_r2", ModelPartBuilder.create().uv(135, 96).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 15.0F, 1.0F, new Dilation(0.01F)), ModelTransform.of(-20.5107F, -29.0227F, 14.9699F, -0.0791F, -0.0368F, -1.1766F));

        ModelPartData four_r2 = BigHair2.addChild("four_r2", ModelPartBuilder.create().uv(144, 320).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-7.7107F, -21.6227F, 13.8699F, -0.0843F, -0.0226F, -1.0026F));

        ModelPartData three_r2 = BigHair2.addChild("three_r2", ModelPartBuilder.create().uv(328, 331).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 13.7699F, 0.0F, 0.0F, -0.48F));

        ModelPartData two_r2 = BigHair2.addChild("two_r2", ModelPartBuilder.create().uv(114, 184).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair3 = BigHairR.addChild("BigHair3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 10.0F, 0.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData five_r3 = BigHair3.addChild("five_r3", ModelPartBuilder.create().uv(234, 164).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.5107F, -14.4227F, 22.3699F, -0.8671F, -0.0518F, -0.769F));

        ModelPartData four_r3 = BigHair3.addChild("four_r3", ModelPartBuilder.create().uv(0, 228).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.6893F, -7.2227F, 11.8699F, -0.9163F, 0.0F, -0.48F));

        ModelPartData three_r3 = BigHair3.addChild("three_r3", ModelPartBuilder.create().uv(0, 175).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair9 = BigHairR.addChild("BigHair9", ModelPartBuilder.create(), ModelTransform.of(-36.0F, 4.0F, -6.2F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData eight_r1 = BigHair9.addChild("eight_r1", ModelPartBuilder.create().uv(0, 22).cuboid(0.0F, -7.0F, -7.0F, 1.0F, 9.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-33.6107F, -35.4227F, 20.2699F, 0.0379F, 0.027F, -1.1257F));

        ModelPartData seven_r1 = BigHair9.addChild("seven_r1", ModelPartBuilder.create().uv(32, 81).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 15.0F, 1.0F, new Dilation(0.01F)), ModelTransform.of(-19.7107F, -28.8227F, 19.3699F, -0.0791F, -0.0368F, -1.1766F));

        ModelPartData six_r2 = BigHair9.addChild("six_r2", ModelPartBuilder.create().uv(101, 307).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-7.7107F, -21.4227F, 16.8699F, -0.0859F, -0.0151F, -0.9156F));

        ModelPartData five_r4 = BigHair9.addChild("five_r4", ModelPartBuilder.create().uv(214, 140).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 13.8699F, -0.2618F, 0.0F, -0.48F));

        ModelPartData four_r4 = BigHair9.addChild("four_r4", ModelPartBuilder.create().uv(166, 19).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair7 = BigHairR.addChild("BigHair7", ModelPartBuilder.create(), ModelTransform.of(0.0F, 10.0F, 0.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData six_r3 = BigHair7.addChild("six_r3", ModelPartBuilder.create().uv(198, 23).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 15.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.0107F, -20.7227F, 32.8699F, -0.7444F, -0.1127F, -0.9199F));

        ModelPartData four_r5 = BigHair7.addChild("four_r5", ModelPartBuilder.create().uv(80, 155).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair4 = BigHairR.addChild("BigHair4", ModelPartBuilder.create(), ModelTransform.of(24.5F, 0.6F, -3.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData seven_r2 = BigHair4.addChild("seven_r2", ModelPartBuilder.create().uv(272, 199).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-12.9107F, -45.2227F, 14.3699F, 0.0F, 0.0F, -0.7854F));

        ModelPartData six_r4 = BigHair4.addChild("six_r4", ModelPartBuilder.create().uv(254, 164).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.8107F, -33.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData five_r5 = BigHair4.addChild("five_r5", ModelPartBuilder.create().uv(280, 331).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0107F, -22.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData four_r6 = BigHair4.addChild("four_r6", ModelPartBuilder.create().uv(73, 307).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 14.7699F, 0.0F, 0.0F, -0.1745F));

        ModelPartData three_r4 = BigHair4.addChild("three_r4", ModelPartBuilder.create().uv(60, 155).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(0.3893F, 3.1773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair12 = BigHairR.addChild("BigHair12", ModelPartBuilder.create(), ModelTransform.of(24.5F, 0.6F, -3.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData eight_r2 = BigHair12.addChild("eight_r2", ModelPartBuilder.create().uv(8, 272).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-12.9107F, -45.2227F, 14.3699F, 0.0F, 0.0F, -0.7854F));

        ModelPartData seven_r3 = BigHair12.addChild("seven_r3", ModelPartBuilder.create().uv(250, 164).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.8107F, -33.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData six_r5 = BigHair12.addChild("six_r5", ModelPartBuilder.create().uv(94, 325).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0107F, -22.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData five_r6 = BigHair12.addChild("five_r6", ModelPartBuilder.create().uv(0, 307).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 14.7699F, 0.0F, 0.0F, -0.1745F));

        ModelPartData four_r7 = BigHair12.addChild("four_r7", ModelPartBuilder.create().uv(40, 155).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(0.3893F, 3.1773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair10 = BigHairR.addChild("BigHair10", ModelPartBuilder.create(), ModelTransform.of(35.6F, -11.4F, -8.8F, -1.1521F, -0.4941F, 0.3522F));

        ModelPartData eight_r3 = BigHair10.addChild("eight_r3", ModelPartBuilder.create().uv(4, 272).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-12.9107F, -45.2227F, 14.3699F, 0.0F, 0.0F, -0.7854F));

        ModelPartData seven_r4 = BigHair10.addChild("seven_r4", ModelPartBuilder.create().uv(246, 164).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.6107F, -32.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData six_r6 = BigHair10.addChild("six_r6", ModelPartBuilder.create().uv(224, 320).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.1107F, -21.2227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData five_r7 = BigHair10.addChild("five_r7", ModelPartBuilder.create().uv(20, 93).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.4107F, -9.0227F, 14.5699F, 0.0F, 0.0F, -0.1745F));

        ModelPartData four_r8 = BigHair10.addChild("four_r8", ModelPartBuilder.create().uv(106, 19).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(0.3893F, 3.1773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair5 = BigHairR.addChild("BigHair5", ModelPartBuilder.create(), ModelTransform.of(23.0F, -12.0F, -3.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData eight_r4 = BigHair5.addChild("eight_r4", ModelPartBuilder.create().uv(0, 272).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-12.9107F, -45.2227F, 14.3699F, 0.0F, 0.0F, -0.7854F));

        ModelPartData seven_r5 = BigHair5.addChild("seven_r5", ModelPartBuilder.create().uv(150, 228).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.8107F, -33.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData six_r7 = BigHair5.addChild("six_r7", ModelPartBuilder.create().uv(316, 331).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0107F, -22.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData five_r8 = BigHair5.addChild("five_r8", ModelPartBuilder.create().uv(248, 228).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 14.7699F, 0.0F, 0.0F, -0.1745F));

        ModelPartData four_r9 = BigHair5.addChild("four_r9", ModelPartBuilder.create().uv(20, 155).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair13 = BigHairR.addChild("BigHair13", ModelPartBuilder.create(), ModelTransform.of(23.0F, -12.0F, -3.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData nine_r1 = BigHair13.addChild("nine_r1", ModelPartBuilder.create().uv(258, 164).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-12.9107F, -45.2227F, 14.3699F, 0.0F, 0.0F, -0.7854F));

        ModelPartData eight_r5 = BigHair13.addChild("eight_r5", ModelPartBuilder.create().uv(146, 228).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.8107F, -33.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData seven_r6 = BigHair13.addChild("seven_r6", ModelPartBuilder.create().uv(304, 331).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0107F, -22.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData six_r8 = BigHair13.addChild("six_r8", ModelPartBuilder.create().uv(240, 44).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 14.7699F, 0.0F, 0.0F, -0.1745F));

        ModelPartData five_r9 = BigHair13.addChild("five_r9", ModelPartBuilder.create().uv(0, 155).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair8 = BigHairR.addChild("BigHair8", ModelPartBuilder.create(), ModelTransform.of(23.0F, -12.0F, -3.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData nine_r2 = BigHair8.addChild("nine_r2", ModelPartBuilder.create().uv(256, 44).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-12.9107F, -45.2227F, 14.3699F, 0.0F, 0.0F, -0.7854F));

        ModelPartData eight_r6 = BigHair8.addChild("eight_r6", ModelPartBuilder.create().uv(218, 6).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.8107F, -33.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData seven_r7 = BigHair8.addChild("seven_r7", ModelPartBuilder.create().uv(292, 331).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0107F, -22.9227F, 14.3699F, 0.0F, 0.0F, -0.4363F));

        ModelPartData six_r9 = BigHair8.addChild("six_r9", ModelPartBuilder.create().uv(130, 228).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -10.7227F, 14.7699F, 0.0F, 0.0F, -0.1745F));

        ModelPartData five_r10 = BigHair8.addChild("five_r10", ModelPartBuilder.create().uv(146, 19).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair11 = BigHairR.addChild("BigHair11", ModelPartBuilder.create(), ModelTransform.of(-13.5F, -33.0291F, 6.8153F, 0.0F, 0.0F, -0.1309F));

        ModelPartData cube_r28 = BigHair11.addChild("cube_r28", ModelPartBuilder.create().uv(84, 109).cuboid(-13.0F, -4.0F, 1.0F, 14.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.9F, 0.8F, 0.1166F, 0.1483F, 0.4753F));

        ModelPartData cube_r29 = BigHair11.addChild("cube_r29", ModelPartBuilder.create().uv(84, 115).cuboid(-13.0F, -3.0F, 2.0F, 14.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.1F, -6.5F, 2.6F, 0.1295F, 0.2383F, 0.5314F));

        ModelPartData cube_r30 = BigHair11.addChild("cube_r30", ModelPartBuilder.create().uv(0, 33).cuboid(-13.0F, -4.0F, 0.0F, 14.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, 5.2F, -2.3F, 0.1423F, 0.2951F, 0.5668F));

        ModelPartData cube_r31 = BigHair11.addChild("cube_r31", ModelPartBuilder.create().uv(0, 0).cuboid(-13.0F, -5.0F, -1.0F, 14.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(22.1F, 11.6F, -5.1F, 0.1177F, 0.2003F, 0.4815F));

        ModelPartData cube_r32 = BigHair11.addChild("cube_r32", ModelPartBuilder.create().uv(0, 11).cuboid(-13.0F, -5.0F, -1.0F, 14.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(31.3F, 17.0F, -11.3F, 0.1318F, 0.5034F, 0.5218F));

        ModelPartData BigHair6 = BigHairR.addChild("BigHair6", ModelPartBuilder.create(), ModelTransform.of(23.0F, 9.0F, -3.0F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData eight_r7 = BigHair6.addChild("eight_r7", ModelPartBuilder.create().uv(104, 81).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.9107F, -20.5227F, 30.5699F, -0.8928F, -0.2452F, -0.6199F));

        ModelPartData seven_r8 = BigHair6.addChild("seven_r8", ModelPartBuilder.create().uv(168, 320).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.7107F, -14.0227F, 21.1699F, -0.925F, 0.0F, -0.4363F));

        ModelPartData six_r10 = BigHair6.addChild("six_r10", ModelPartBuilder.create().uv(114, 228).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -6.3227F, 12.1699F, -0.8727F, 0.0F, -0.1745F));

        ModelPartData five_r11 = BigHair6.addChild("five_r11", ModelPartBuilder.create().uv(126, 19).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-1.1107F, 1.5773F, 5.2699F, -0.6545F, 0.0F, 0.0F));

        ModelPartData BigHair14 = BigHairR.addChild("BigHair14", ModelPartBuilder.create(), ModelTransform.of(39.7F, 8.7F, -7.5F, -1.1037F, -0.6519F, 0.2632F));

        ModelPartData nine_r3 = BigHair14.addChild("nine_r3", ModelPartBuilder.create().uv(214, 6).cuboid(0.0F, -13.0F, -7.0F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.1107F, -18.6227F, 28.8699F, -1.123F, -0.0159F, -0.4141F));

        ModelPartData eight_r8 = BigHair14.addChild("eight_r8", ModelPartBuilder.create().uv(156, 320).cuboid(-1.0F, -13.0F, -8.0F, 3.0F, 13.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.7107F, -12.9227F, 19.9699F, -1.0437F, 0.058F, -0.3672F));

        ModelPartData seven_r9 = BigHair14.addChild("seven_r9", ModelPartBuilder.create().uv(224, 55).cuboid(-1.0F, -13.0F, -9.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.4107F, -6.3227F, 10.9699F, -1.0016F, -0.0227F, -0.1731F));

        ModelPartData six_r11 = BigHair14.addChild("six_r11", ModelPartBuilder.create().uv(0, 93).cuboid(-2.0F, -13.0F, -9.0F, 5.0F, 15.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(-3.5107F, 1.5773F, 5.2699F, -0.6504F, 0.0795F, 0.1041F));

        ModelPartData TinyHairR = Hair.addChild("TinyHairR", ModelPartBuilder.create(), ModelTransform.pivot(11.3F, -2.5291F, 2.5153F));

        ModelPartData TinyHair1 = TinyHairR.addChild("TinyHair1", ModelPartBuilder.create().uv(84, 83).cuboid(0.1391F, -2.0F, -1.2654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r33 = TinyHair1.addChild("cube_r33", ModelPartBuilder.create().uv(166, 30).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(0.1391F, -3.2F, 6.6346F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair8 = TinyHairR.addChild("TinyHair8", ModelPartBuilder.create().uv(84, 71).cuboid(0.1391F, 10.7F, -1.3654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(15.4F, -14.6F, -3.6F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r34 = TinyHair8.addChild("cube_r34", ModelPartBuilder.create().uv(35, 165).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(0.1391F, 9.5F, 6.5346F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair10 = TinyHairR.addChild("TinyHair10", ModelPartBuilder.create().uv(84, 74).cuboid(0.1391F, 10.7F, -1.3654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(28.8F, -11.6F, -10.7F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r35 = TinyHair10.addChild("cube_r35", ModelPartBuilder.create().uv(15, 165).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(0.1391F, 9.5F, 6.5346F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair2 = TinyHairR.addChild("TinyHair2", ModelPartBuilder.create().uv(84, 80).cuboid(0.1391F, -2.0F, -1.2654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(-1.0F, -10.0F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r36 = TinyHair2.addChild("cube_r36", ModelPartBuilder.create().uv(75, 165).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(0.1391F, -3.2F, 6.6346F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair7 = TinyHairR.addChild("TinyHair7", ModelPartBuilder.create().uv(84, 77).cuboid(0.1391F, -2.0F, -1.2654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, 11.0F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r37 = TinyHair7.addChild("cube_r37", ModelPartBuilder.create().uv(55, 165).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(0.1391F, -3.2F, 6.6346F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair3 = TinyHair7.addChild("TinyHair3", ModelPartBuilder.create().uv(0, 103).cuboid(4.8391F, -2.0F, -8.7654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(-33.0F, -4.0F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r38 = TinyHair3.addChild("cube_r38", ModelPartBuilder.create().uv(20, 171).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(4.8391F, -3.2F, -0.8654F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair6 = TinyHairR.addChild("TinyHair6", ModelPartBuilder.create().uv(146, 29).cuboid(4.8391F, -2.0F, -8.7654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(-36.0F, -16.6F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r39 = TinyHair6.addChild("cube_r39", ModelPartBuilder.create().uv(80, 168).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(4.8391F, -3.2F, -0.8654F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair5 = TinyHairR.addChild("TinyHair5", ModelPartBuilder.create().uv(95, 145).cuboid(4.8391F, -2.0F, -8.7654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(-37.2F, -8.6F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r40 = TinyHair5.addChild("cube_r40", ModelPartBuilder.create().uv(60, 168).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(4.8391F, -3.2F, -0.8654F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair4 = TinyHairR.addChild("TinyHair4", ModelPartBuilder.create().uv(118, 102).cuboid(4.8391F, -2.0F, -8.7654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(-46.0F, 3.4F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r41 = TinyHair4.addChild("cube_r41", ModelPartBuilder.create().uv(40, 168).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(4.8391F, -3.2F, -0.8654F, 0.0F, -0.2269F, 0.0F));

        ModelPartData TinyHair9 = TinyHairR.addChild("TinyHair9", ModelPartBuilder.create().uv(115, 99).cuboid(4.8391F, -2.0F, -8.7654F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(-33.0F, 7.4F, 0.0F, 0.0F, -1.1345F, 0.0F));

        ModelPartData cube_r42 = TinyHair9.addChild("cube_r42", ModelPartBuilder.create().uv(20, 168).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 10.0F, new Dilation(0.1F)), ModelTransform.of(4.8391F, -3.2F, -0.8654F, 0.0F, -0.2269F, 0.0F));

        ModelPartData Head = wholehead.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -49.0F, -20.0F, 33.0F, 41.0F, 40.0F, new Dilation(0.0F))
                .uv(0, 81).cuboid(32.0F, -47.0F, -18.0F, 24.0F, 38.0F, 36.0F, new Dilation(0.0F))
                .uv(94, 320).cuboid(56.0F, -42.0F, -11.0F, 14.0F, 30.0F, 22.0F, new Dilation(0.1F))
                .uv(239, 243).cuboid(-24.0F, -44.0F, -15.0F, 23.0F, 32.0F, 29.0F, new Dilation(0.0F)), ModelTransform.pivot(423.0F, -20.0F, 0.0F));

        ModelPartData cube_r43 = Head.addChild("cube_r43", ModelPartBuilder.create().uv(108, 43).cuboid(58.0F, -3.0F, -19.0F, 29.0F, 15.0F, 38.0F, new Dilation(0.0F)), ModelTransform.of(-44.7F, -81.4F, 0.0F, 0.0F, 0.0F, 0.4363F));

        ModelPartData Nose = wholehead.addChild("Nose", ModelPartBuilder.create().uv(338, 25).cuboid(0.0F, -4.0F, -5.0F, 5.0F, 1.0F, 5.0F, new Dilation(0.01F))
                .uv(109, 279).cuboid(0.0F, -3.0F, 0.0F, 5.0F, 4.0F, 1.0F, new Dilation(0.01F))
                .uv(222, 48).cuboid(0.0F, -3.0F, -5.0F, 5.0F, 4.0F, 2.0F, new Dilation(0.01F))
                .uv(225, 272).cuboid(0.0F, -3.0F, -1.0F, 5.0F, 4.0F, 1.0F, new Dilation(0.01F))
                .uv(207, 0).cuboid(0.0F, -3.0F, 3.0F, 5.0F, 4.0F, 2.0F, new Dilation(0.01F))
                .uv(15, 111).cuboid(0.0F, -4.0F, 0.0F, 5.0F, 1.0F, 5.0F, new Dilation(0.01F)), ModelTransform.of(504.6408F, -54.3179F, 0.0F, 0.0F, 0.0F, 0.2705F));

        ModelPartData cube_r44 = Nose.addChild("cube_r44", ModelPartBuilder.create().uv(0, 81).cuboid(2.5611F, -4.5326F, -5.0F, 6.0F, 2.0F, 10.0F, new Dilation(-0.01F))
                .uv(176, 29).cuboid(-1.3389F, -4.3326F, -5.0F, 4.0F, 1.0F, 10.0F, new Dilation(-0.01F))
                .uv(204, 44).cuboid(4.6611F, -5.3326F, -5.0F, 4.0F, 1.0F, 10.0F, new Dilation(-0.01F))
                .uv(0, 22).cuboid(-6.4389F, -3.5326F, -5.0F, 10.0F, 1.0F, 10.0F, new Dilation(0.01F))
                .uv(84, 96).cuboid(-6.4389F, -2.5326F, -5.0F, 15.0F, 3.0F, 10.0F, new Dilation(-0.01F)), ModelTransform.of(-6.9999F, 3.4616F, 0.0F, 0.0F, 0.0F, -0.2531F));

        ModelPartData Jaw = wholehead.addChild("Jaw", ModelPartBuilder.create(), ModelTransform.pivot(-115.2F, -5.0F, 0.0F));

        ModelPartData UpperJaw = Jaw.addChild("UpperJaw", ModelPartBuilder.create(), ModelTransform.of(605.8409F, -48.3562F, 0.0F, 0.0F, 0.0F, 0.1309F));

        ModelPartData cube_r45 = UpperJaw.addChild("cube_r45", ModelPartBuilder.create().uv(20, 22).cuboid(86.4039F, -5.6658F, -5.0F, 4.0F, 0.0F, 10.0F, new Dilation(-0.01F))
                .uv(166, 320).cuboid(75.3039F, -0.8658F, -11.0F, 18.0F, 8.0F, 22.0F, new Dilation(-0.001F)), ModelTransform.of(-74.5F, 10.7F, 0.0F, 0.0F, 0.0F, -0.1309F));

        ModelPartData cube_r46 = UpperJaw.addChild("cube_r46", ModelPartBuilder.create().uv(0, 195).cuboid(67.0F, -5.0F, -6.9F, 10.0F, 7.0F, 0.0F, new Dilation(0.1F))
                .uv(109, 272).cuboid(67.0F, -5.0F, -29.0F, 10.0F, 7.0F, 0.0F, new Dilation(-0.01F)), ModelTransform.of(-67.2F, 16.9F, 18.0F, 0.0F, 0.0F, -0.1309F));

        ModelPartData LowerJaw = Jaw.addChild("LowerJaw", ModelPartBuilder.create(), ModelTransform.pivot(603.0F, -27.0F, -1.0F));

        ModelPartData cube_r47 = LowerJaw.addChild("cube_r47", ModelPartBuilder.create().uv(224, 331).cuboid(7.0807F, -7.8706F, -12.0F, 17.0F, 8.0F, 22.0F, new Dilation(-0.01F)), ModelTransform.of(-6.031F, -0.9434F, 2.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData cube_r48 = LowerJaw.addChild("cube_r48", ModelPartBuilder.create().uv(0, 0).cuboid(5.0F, -5.0F, -7.0F, 3.0F, 5.0F, 0.0F, new Dilation(-0.01F)), ModelTransform.of(10.3F, -2.1F, 19.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData cube_r49 = LowerJaw.addChild("cube_r49", ModelPartBuilder.create().uv(0, 11).cuboid(5.0F, -5.0F, -7.0F, 3.0F, 5.0F, 0.0F, new Dilation(0.01F)), ModelTransform.of(10.5F, -2.1F, -3.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData cube_r50 = LowerJaw.addChild("cube_r50", ModelPartBuilder.create().uv(224, 336).cuboid(-2.0F, -1.0F, -7.0F, 10.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(338, 19).cuboid(-2.0F, -1.0F, 14.9F, 10.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.8F, -9.1F, -3.0F, 0.0F, 0.0F, 0.2182F));

        ModelPartData SmallHair18 = LowerJaw.addChild("SmallHair18", ModelPartBuilder.create(), ModelTransform.of(13.7F, 2.5291F, -3.9153F, -1.5018F, -0.0188F, -0.9187F));

        ModelPartData cube_r51 = SmallHair18.addChild("cube_r51", ModelPartBuilder.create().uv(22, 89).cuboid(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-14.7188F, -7.0026F, 5.2311F, -0.2939F, 0.0853F, -1.3634F));

        ModelPartData cube_r52 = SmallHair18.addChild("cube_r52", ModelPartBuilder.create().uv(32, 35).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-15.7188F, -3.9026F, 5.5311F, -0.2864F, -0.1083F, -1.9897F));

        ModelPartData cube_r53 = SmallHair18.addChild("cube_r53", ModelPartBuilder.create().uv(234, 182).cuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.8188F, 0.2974F, 4.3311F, 0.0891F, 0.2928F, 0.2331F));

        ModelPartData cube_r54 = SmallHair18.addChild("cube_r54", ModelPartBuilder.create().uv(22, 85).cuboid(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5188F, 0.3974F, 3.3311F, 0.0079F, 0.3056F, -0.0406F));

        ModelPartData cube_r55 = SmallHair18.addChild("cube_r55", ModelPartBuilder.create().uv(222, 44).cuboid(-9.0F, -2.0F, -1.0F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.0188F, 0.9974F, -0.0689F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair20 = LowerJaw.addChild("SmallHair20", ModelPartBuilder.create(), ModelTransform.of(6.7F, 0.5291F, 8.0847F, -3.0959F, 0.3374F, -1.1554F));

        ModelPartData cube_r56 = SmallHair20.addChild("cube_r56", ModelPartBuilder.create().uv(84, 96).cuboid(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-14.7188F, -7.0026F, 5.2311F, -0.2939F, 0.0853F, -1.3634F));

        ModelPartData cube_r57 = SmallHair20.addChild("cube_r57", ModelPartBuilder.create().uv(15, 93).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-15.7188F, -3.9026F, 5.5311F, -0.2864F, -0.1083F, -1.9897F));

        ModelPartData cube_r58 = SmallHair20.addChild("cube_r58", ModelPartBuilder.create().uv(227, 77).cuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.8188F, 0.2974F, 4.3311F, 0.0891F, 0.2928F, 0.2331F));

        ModelPartData cube_r59 = SmallHair20.addChild("cube_r59", ModelPartBuilder.create().uv(22, 83).cuboid(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5188F, 0.3974F, 3.3311F, 0.0079F, 0.3056F, -0.0406F));

        ModelPartData cube_r60 = SmallHair20.addChild("cube_r60", ModelPartBuilder.create().uv(181, 19).cuboid(-9.0F, -2.0F, -1.0F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.0188F, 0.9974F, -0.0689F, 0.0F, 0.4363F, 0.0F));

        ModelPartData SmallHair19 = LowerJaw.addChild("SmallHair19", ModelPartBuilder.create(), ModelTransform.of(14.1F, 2.5291F, 3.8847F, -0.054F, -0.4636F, -1.184F));

        ModelPartData cube_r61 = SmallHair19.addChild("cube_r61", ModelPartBuilder.create().uv(22, 87).cuboid(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-14.7F, -8.0F, 5.3F, -0.2939F, 0.0853F, -1.3634F));

        ModelPartData cube_r62 = SmallHair19.addChild("cube_r62", ModelPartBuilder.create().uv(32, 33).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-15.7F, -4.9F, 5.6F, -0.2864F, -0.1083F, -1.9897F));

        ModelPartData cube_r63 = SmallHair19.addChild("cube_r63", ModelPartBuilder.create().uv(88, 181).cuboid(-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.8F, -0.7F, 4.4F, 0.0891F, 0.2928F, 0.2331F));

        ModelPartData cube_r64 = SmallHair19.addChild("cube_r64", ModelPartBuilder.create().uv(22, 81).cuboid(-3.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.5F, -0.6F, 3.4F, 0.0079F, 0.3056F, -0.0406F));

        ModelPartData cube_r65 = SmallHair19.addChild("cube_r65", ModelPartBuilder.create().uv(154, 336).cuboid(-9.0F, -2.0F, -1.0F, 9.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));
        return TexturedModelData.of(modelData, 512, 512);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        //this.setHeadAngles(headYaw, headPitch);
        this.animateMovement(ModAnimations.TIGER_STATIC, limbAngle, limbDistance, 2f, 2.5f);
        //this.updateAnimation(entity.idleAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
        //this.updateAnimation(entity.attackAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
        //this.updateAnimation(entity.sitAnimationState, ModAnimations.TIGER_STATIC, animationProgress, 1f);
    }
    /*private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }*/
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        dragon.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return dragon;
    }
}
