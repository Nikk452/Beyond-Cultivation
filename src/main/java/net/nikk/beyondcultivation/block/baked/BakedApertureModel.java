package net.nikk.beyondcultivation.block.baked;

import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.nikk.beyondcultivation.block.entity.ApertureBlockEntity;

import java.util.function.Supplier;

public class BakedApertureModel extends ForwardingBakedModel {
    public BakedApertureModel(BakedModel bakedModel){
        this.wrapped = bakedModel;
    }
    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    @Override
    public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
        super.emitBlockQuads(blockView, state, pos, randomSupplier, context);

        BlockEntity be = blockView.getBlockEntity(pos);
        if (be instanceof ApertureBlockEntity ap && !ap.fluidStorage.isResourceBlank()) {
            float fillRatio = (float) ap.fluidStorage.amount / ap.fluidStorage.getCapacity();

            // Get the actual fluid sprite (water, lava, etc.)
            Sprite sprite = FluidVariantRendering.getSprite(ap.fluidStorage.variant);

            renderFluid(fillRatio, sprite, context);
        }
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
        super.emitItemQuads(stack, randomSupplier, context);

        NbtCompound nbt = stack.getNbt();
        if (nbt != null && nbt.contains("fluid_level")) {
            float fillRatio = nbt.getFloat("fluid_level");
            // You'll need a way to get the sprite from NBT data here
            // For now, let's assume a default or pass it in
            Sprite sprite = FluidVariantRendering.getSprite(FluidVariant.fromNbt(nbt.getCompound("fluidVariant")));
            renderFluid(fillRatio, sprite, context);
        }
    }
    private void renderFluid(float fillRatio, Sprite sprite, RenderContext context) {
        // Calculate height: Starts at 0.1, ends at 0.9 (0.8 total range)
        float fluidY = 3+ 0.1f + (fillRatio * 0.8f);

        var emitter = context.getEmitter();

        // Build the top face quad (horizontal)
        // Vertices: (x, y, z)
        emitter.pos(0, 0.1f, fluidY, 0.1f); // Bottom Left
        emitter.pos(1, 0.1f, fluidY, 0.9f); // Top Left
        emitter.pos(2, 0.9f, fluidY, 0.9f); // Top Right
        emitter.pos(3, 0.9f, fluidY, 0.1f); // Bottom Right

        // Apply texture and color logic
        emitter.spriteBake(0, sprite, MutableQuadView.BAKE_LOCK_UV);
        emitter.colorIndex(1); // Link to BlockColor for fluid tinting

        // Ensure it doesn't cull if there is a block above
        emitter.cullFace(null);

        emitter.emit();
    }
}
