package net.nikk.beyondcultivation.item;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.item.custom.PoisonFlaskItem;

import java.util.Optional;

public class ModItemRendererRegistry implements BuiltinItemRendererRegistry.DynamicItemRenderer{
    public static final ModItemRendererRegistry INSTANCE = new ModItemRendererRegistry();

    private final MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(stack.getItem() instanceof PoisonFlaskItem) {
            LivingEntity entity;
            //Optional<Entity> entity = EntityType.getEntityFromNbt(stack.getNbt(),client.world);
            if(client.world != null){
                entity = new SpiritFoxEntity(ModEntities.SPIRIT_FOX,client.world);
                NbtCompound nbt = stack.getOrCreateNbt().getCompound("SavedEntity");;
                if(nbt!=null) entity.readCustomDataFromNbt(nbt);
                matrices.push();
                // 1. Adjust for GUI/Hand positioning
                matrices.translate(0.5, 0.0, 0.5); // Center the entity
                //matrices.scale(0.5f, 0.5f, 0.5f);  // Scale to fit the item slot
                // 2. Use the Dispatcher to render
                EntityRenderDispatcher dispatcher = client.getEntityRenderDispatcher();
                dispatcher.setRenderShadows(false); // Items usually don't have shadows
                // The render method takes: entity, x, y, z, yaw, tickDelta, matrices, consumers, light
                dispatcher.render(entity, 0, 0, 0, 0.0f, 1.0f, matrices, vertexConsumers, light);
                matrices.pop();
            }
        } else if(stack.isOf(ModBlocks.APERTURE.asItem())){
            matrices.push();

            matrices.pop();
        } else return;
    }
}
