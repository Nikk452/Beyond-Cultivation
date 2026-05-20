package net.nikk.beyondcultivation.block.entity.renderer;

import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.block.entity.ApertureBlockEntity;
import net.nikk.beyondcultivation.util.ModRenderLayers;

public class ApertureBlockEntityRenderer implements BlockEntityRenderer<ApertureBlockEntity> {
    public ApertureBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}
    int layerIndex = 12;
    int waterLayerIndex = 21;
    @Override
    public void render(ApertureBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        int fullBright = LightmapTextureManager.MAX_LIGHT_COORDINATE;

        // This renders the block model itself at full brightness
        // It will ignore shadows and look like it's glowing
        BlockState state = entity.getCachedState();
        Sprite sprite = MinecraftClient.getInstance().getBlockRenderManager()
                .getModel(state)
                .getParticleSprite();

        // 2. Use itemCount as the index for your switch (limit it to your 13 cases)



        RenderLayer blocklayer = ModRenderLayers.getTestLayer(layerIndex, sprite.getAtlasId());
        VertexConsumer blockBuffer = vertexConsumers.getBuffer(blocklayer);
        float rgba = entity.getWallsRGB();
        // Use the internal ModelRenderer to draw the block state into our specific buffer
        MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(
                matrices.peek(),
                blockBuffer,
                state,
                MinecraftClient.getInstance().getBlockRenderManager().getModel(state),
                rgba, rgba, rgba, // RGB (White/Normal)
                fullBright,
                overlay
        );

        DefaultedList<ItemStack> inventory = entity.getItems();

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.get(i);
            if (stack.isEmpty()) continue;

            matrices.push();
            // Calculate a grid position (e.g., 8x8 grid for 64 items)
            double xOffset = (i % 8) * 0.12;
            double zOffset = (i / 8) * 0.12;

            matrices.translate(0.1 + xOffset, 0.1, 0.1 + zOffset); // Move items above the block
            matrices.scale(0.2f, 0.2f, 0.2f); // Scale down to fit 64 items

            // Render the item
            int light2 = getLightLevel(entity.getWorld(), entity.getPos().up());
            MinecraftClient.getInstance().getItemRenderer().renderItem(stack,
                    ModelTransformationMode.GROUND, light2, overlay, matrices, vertexConsumers, entity.getWorld(), 0);
            matrices.pop();
        }

        long amount = entity.fluidStorage.amount;
        if (amount <= 0) return;
        FluidVariant variant = entity.fluidStorage.variant;
        if(variant.isBlank()) return;
        // Calculate height based on storage capacity
        float heightRatio = (float) amount / entity.fluidStorage.getCapacity();
        //float waterHeight = 0.1f + (heightRatio * 0.8f); // Stay within the tank bounds
        float time = (entity.getWorld().getTime() + tickDelta) * 0.1f;
        float bobbing = (float) Math.sin(time) * 0.01f; // Subtle 2% movement
        float waterHeight = (heightRatio * 0.78f);
        if(heightRatio<1) waterHeight += bobbing;

        matrices.push();
        matrices.translate(0.11, 0.11, 0.11);
        matrices.scale(0.78f, waterHeight, 0.78f);

        Sprite[] sprites = FluidVariantRendering.getSprites(variant);
        int color = entity.getWaterColor();

        //VertexConsumer buffer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(FluidVariantRendering.getSprites(variant)[0].getAtlasId()));
        if (sprites != null && sprites.length > 0) {
            RenderLayer water_layer = ModRenderLayers.getTestLayer(waterLayerIndex,sprites[0].getAtlasId());
            VertexConsumer buffer = vertexConsumers.getBuffer(
                    water_layer
                    //RenderLayer.getTranslucent()
                    //RenderLayer.getEntityCutoutNoCull(sprites[0].getAtlasId())
            );
            drawFluid(matrices, buffer, sprites[0], color, fullBright);
        }
        matrices.pop();
    }
    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
    private void drawFluid(MatrixStack matrices, VertexConsumer buffer, Sprite sprite, int color, int light) {
        MatrixStack.Entry entry = matrices.peek();

        float minU = sprite.getMinU();
        float maxU = sprite.getMaxU();
        float minV = sprite.getMinV();
        float maxV = sprite.getMaxV();

        int r = (color >> 16 & 255);
        int g = (color >> 8 & 255);
        int b = (color & 255);
        int a = 150;

        drawVertex(entry, buffer, 0, 1, 0, r, g, b, a, minU, minV, light, 0, 1, 0);
        drawVertex(entry, buffer, 0, 1, 1, r, g, b, a, minU, maxV, light, 0, 1, 0);
        drawVertex(entry, buffer, 1, 1, 1, r, g, b, a, maxU, maxV, light, 0, 1, 0);
        drawVertex(entry, buffer, 1, 1, 0, r, g, b, a, maxU, minV, light, 0, 1, 0);
        // NORTH SIDE
        drawVertex(entry, buffer, 0, 1, 0, r, g, b, a, minU, minV, light, 0, 0, -1);
        drawVertex(entry, buffer, 1, 1, 0, r, g, b, a, maxU, minV, light, 0, 0, -1);
        drawVertex(entry, buffer, 1, 0, 0, r, g, b, a, maxU, maxV, light, 0, 0, -1);
        drawVertex(entry, buffer, 0, 0, 0, r, g, b, a, minU, maxV, light, 0, 0, -1);

        // SOUTH SIDE
        drawVertex(entry, buffer, 0, 1, 1, r, g, b, a, minU, minV, light, 0, 0, 1);
        drawVertex(entry, buffer, 0, 0, 1, r, g, b, a, minU, maxV, light, 0, 0, 1);
        drawVertex(entry, buffer, 1, 0, 1, r, g, b, a, maxU, maxV, light, 0, 0, 1);
        drawVertex(entry, buffer, 1, 1, 1, r, g, b, a, maxU, minV, light, 0, 0, 1);

        // EAST SIDE
        drawVertex(entry, buffer, 1, 1, 0, r, g, b, a, minU, minV, light, 1, 0, 0);
        drawVertex(entry, buffer, 1, 1, 1, r, g, b, a, maxU, minV, light, 1, 0, 0);
        drawVertex(entry, buffer, 1, 0, 1, r, g, b, a, maxU, maxV, light, 1, 0, 0);
        drawVertex(entry, buffer, 1, 0, 0, r, g, b, a, minU, maxV, light, 1, 0, 0);

        // WEST SIDE
        drawVertex(entry, buffer, 0, 1, 0, r, g, b, a, minU, minV, light, -1, 0, 0);
        drawVertex(entry, buffer, 0, 0, 0, r, g, b, a, minU, maxV, light, -1, 0, 0);
        drawVertex(entry, buffer, 0, 0, 1, r, g, b, a, maxU, maxV, light, -1, 0, 0);
        drawVertex(entry, buffer, 0, 1, 1, r, g, b, a, maxU, minV, light, -1, 0, 0);
        // BOTTOM SIDE (Visible from below the block)
        drawVertex(entry, buffer, 0, 0, 0, r, g, b, a, minU, minV, light, 0, -1, 0);
        drawVertex(entry, buffer, 1, 0, 0, r, g, b, a, maxU, minV, light, 0, -1, 0);
        drawVertex(entry, buffer, 1, 0, 1, r, g, b, a, maxU, maxV, light, 0, -1, 0);
        drawVertex(entry, buffer, 0, 0, 1, r, g, b, a, minU, maxV, light, 0, -1, 0);
        //now inverse
        // TOP SIDE (Inverted - Looking from bottom up)
        drawVertex(entry, buffer, 0, 1, 0, r, g, b, a, minU, minV, light, 0, -1, 0);
        drawVertex(entry, buffer, 1, 1, 0, r, g, b, a, maxU, minV, light, 0, -1, 0); // Swapped
        drawVertex(entry, buffer, 1, 1, 1, r, g, b, a, maxU, maxV, light, 0, -1, 0);
        drawVertex(entry, buffer, 0, 1, 1, r, g, b, a, minU, maxV, light, 0, -1, 0); // Swapped

// NORTH SIDE (Inverted - Looking from South to North)
        drawVertex(entry, buffer, 0, 1, 0, r, g, b, a, minU, minV, light, 0, 0, 1);
        drawVertex(entry, buffer, 0, 0, 0, r, g, b, a, minU, maxV, light, 0, 0, 1); // Swapped
        drawVertex(entry, buffer, 1, 0, 0, r, g, b, a, maxU, maxV, light, 0, 0, 1);
        drawVertex(entry, buffer, 1, 1, 0, r, g, b, a, maxU, minV, light, 0, 0, 1); // Swapped

// SOUTH SIDE (Inverted - Looking from North to South)
        drawVertex(entry, buffer, 0, 1, 1, r, g, b, a, minU, minV, light, 0, 0, -1);
        drawVertex(entry, buffer, 1, 1, 1, r, g, b, a, maxU, minV, light, 0, 0, -1); // Swapped
        drawVertex(entry, buffer, 1, 0, 1, r, g, b, a, maxU, maxV, light, 0, 0, -1);
        drawVertex(entry, buffer, 0, 0, 1, r, g, b, a, minU, maxV, light, 0, 0, -1); // Swapped

// EAST SIDE (Inverted - Looking from West to East)
        drawVertex(entry, buffer, 1, 1, 0, r, g, b, a, minU, minV, light, -1, 0, 0);
        drawVertex(entry, buffer, 1, 0, 0, r, g, b, a, minU, maxV, light, -1, 0, 0); // Swapped
        drawVertex(entry, buffer, 1, 0, 1, r, g, b, a, maxU, maxV, light, -1, 0, 0);
        drawVertex(entry, buffer, 1, 1, 1, r, g, b, a, maxU, minV, light, -1, 0, 0); // Swapped

// WEST SIDE (Inverted - Looking from East to West)
        drawVertex(entry, buffer, 0, 1, 0, r, g, b, a, minU, minV, light, 1, 0, 0);
        drawVertex(entry, buffer, 0, 1, 1, r, g, b, a, maxU, minV, light, 1, 0, 0); // Swapped
        drawVertex(entry, buffer, 0, 0, 1, r, g, b, a, maxU, maxV, light, 1, 0, 0);
        drawVertex(entry, buffer, 0, 0, 0, r, g, b, a, minU, maxV, light, 1, 0, 0);
        // BOTTOM SIDE (Visible from inside looking down)
        drawVertex(entry, buffer, 0, 0, 0, r, g, b, a, minU, minV, light, 0, 1, 0);
        drawVertex(entry, buffer, 0, 0, 1, r, g, b, a, minU, maxV, light, 0, 1, 0); // Swapped
        drawVertex(entry, buffer, 1, 0, 1, r, g, b, a, maxU, maxV, light, 0, 1, 0);
        drawVertex(entry, buffer, 1, 0, 0, r, g, b, a, maxU, minV, light, 0, 1, 0);
    }

    private void drawVertex(MatrixStack.Entry entry, VertexConsumer buffer, float x, float y, float z, int r, int g, int b, int a, float u, float v, int light, float nx, float ny, float nz) {
        buffer.vertex(entry.getPositionMatrix(), x, y, z)
                .color(r, g, b, a)
                .texture(u, v)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(entry.getNormalMatrix(), nx, ny, nz)
                .next();
    }
}
