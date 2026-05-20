package net.nikk.beyondcultivation.util;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

public class ModRenderLayers extends RenderLayer {
    public ModRenderLayers(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }

    public static RenderLayer getCustomGlow(Identifier texture){
        MultiPhaseParameters builder = RenderLayer.MultiPhaseParameters.builder()
                .texture(new RenderPhase.Texture(texture,false,false))
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .lightmap(ENABLE_LIGHTMAP)
                .cull(DISABLE_CULLING)
                .overlay(DISABLE_OVERLAY_COLOR)
                .program(RenderPhase.TRANSLUCENT_PROGRAM)
                .writeMaskState(COLOR_MASK)
                .build(false);
        return RenderLayer.of(
                "custom_glow_layer",
                VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL,
                VertexFormat.DrawMode.QUADS,
                256,false,true ,
                builder);
    }

    public static RenderLayer getWaterGlow(Identifier texture){
        return RenderLayer.of("koniava_solar_glow", VertexFormats.POSITION_COLOR, VertexFormat.DrawMode.QUADS, 2048, false, true,
                RenderLayer.MultiPhaseParameters.builder()
                        .lightmap(ENABLE_LIGHTMAP)
                        .program(COLOR_PROGRAM)
                        .transparency(TRANSLUCENT_TRANSPARENCY)
                        .writeMaskState(COLOR_MASK)
                        .texture(new RenderPhase.Texture(texture,false,false))
                        .build(false));
    }

    public static RenderLayer getTestLayer(int index, Identifier tex) {
        return switch (index) {
            case 0 -> RenderLayer.getSolid();               // Standard solid (No transparency)
            case 1 -> RenderLayer.getCutout();              // Binary transparency (Glass)
            case 2 -> RenderLayer.getCutoutMipped(); //0/10 // Cutout + Distance smoothing
            case 3 -> RenderLayer.getTranslucent(); //?     // Standard world translucency
            case 4 -> RenderLayer.getTranslucentNoCrumbling(); // What worked before (No break-cracks)
            case 5 -> RenderLayer.getTripwire();            // Specific for thin objects
            case 6 -> RenderLayer.getWaterMask();           // Special depth-only layer
            case 7 -> RenderLayer.getGlint();               // Glowing enchantment effect
            case 8 -> RenderLayer.getDirectEntityGlint();   // Stronger direct glow
            case 9 -> RenderLayer.getEntityTranslucent(tex); // Best for slimes/entities
            case 10 -> RenderLayer.getEntityCutout(tex);     // Solid-feeling glass
            case 11 -> RenderLayer.getEyes(tex);             // Glowing in the dark (Enderman eyes)
            case 12 -> RenderLayer.getBeaconBeam(tex, true); // True volume glow
            case 13 -> RenderLayer.getArmorCutoutNoCull(tex);
            case 14 -> RenderLayer.getArmorEntityGlint();
            case 15 -> RenderLayer.getBlockBreaking(tex);
            case 16 -> RenderLayer.getEntityNoOutline(tex);
            case 17 -> RenderLayer.getCutoutMipped();
            case 18 -> RenderLayer.getArmorGlint();
            case 19 -> RenderLayer.getEntityTranslucentEmissive(tex);
            case 20 -> ModRenderLayers.getCustomGlow(tex);
            case 21 -> ModRenderLayers.getWaterGlow(tex);
            default -> RenderLayer.getTranslucent();
        };
    }
}
