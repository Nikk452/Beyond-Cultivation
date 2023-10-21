package net.nikk.beyondcultivation.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;
import net.nikk.beyondcultivation.entity.variant.SpiritFoxVariant;

import java.util.Map;

public class SpiritFoxRenderer extends MobEntityRenderer<SpiritFoxEntity, SpiritFoxModel<SpiritFoxEntity>> {
    private static final Map<SpiritFoxVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SpiritFoxVariant.class), map -> {
                map.put(SpiritFoxVariant.WHITE,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox0.png"));
                map.put(SpiritFoxVariant.WHITE_RED,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox1.png"));
                map.put(SpiritFoxVariant.WHITE2_RED,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox1.png"));
                map.put(SpiritFoxVariant.WHITE_ORANGE,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox3.png"));
                map.put(SpiritFoxVariant.WHITE_BLACK,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox4.png"));
                map.put(SpiritFoxVariant.RED,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox5.png"));
                map.put(SpiritFoxVariant.GOLD,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox6.png"));
                map.put(SpiritFoxVariant.DEFAULT_RED,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox7.png"));
                map.put(SpiritFoxVariant.CYAN_FOX,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox8.png"));
                map.put(SpiritFoxVariant.DEFAULT,
                        new Identifier(BCMod.MOD_ID, "textures/entity/spiritfox9.png"));
            });

    public SpiritFoxRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SpiritFoxModel<>(ctx.getPart(ModModelLayers.SPIRIT_FOX)), 1.0f);
    }

    @Override
    public Identifier getTexture(SpiritFoxEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(SpiritFoxEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        int tails_number = mobEntity.getTailsNumber();
        float size = 0.3f + tails_number*0.05f;
        matrixStack.scale(size, size, size);
        this.getModel().getPart().getChild("tail").getChild("upright").visible = tails_number > 1;
        this.getModel().getPart().getChild("tail").getChild("up").visible = tails_number > 6 || tails_number==3 || tails_number==5;
        this.getModel().getPart().getChild("tail").getChild("upleft").visible = tails_number > 1;
        this.getModel().getPart().getChild("tail").getChild("right").visible = tails_number > 3;
        this.getModel().getPart().getChild("tail").getChild("middle").visible = tails_number ==1 || tails_number>8;
        this.getModel().getPart().getChild("tail").getChild("left").visible = tails_number > 3;
        this.getModel().getPart().getChild("tail").getChild("downright").visible = tails_number > 5;
        this.getModel().getPart().getChild("tail").getChild("down").visible = tails_number > 7;
        this.getModel().getPart().getChild("tail").getChild("downleft").visible =  tails_number > 5;
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
