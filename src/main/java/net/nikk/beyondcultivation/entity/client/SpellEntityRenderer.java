package net.nikk.beyondcultivation.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.entity.spells.SpellEntity;

public class SpellEntityRenderer extends EntityRenderer<SpellEntity> {
    public SpellEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(SpellEntity entity) {
        return null;
    }

    @Override
    public void render(SpellEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        // Spawn flame particles in a sphere around the entity

        double radius = 2.0;
        double density = 0.25;
        double rotationOffset = Math.toRadians(45);

        for (double angle = 0; angle <= Math.PI; angle += density) {
            double xzRadius = radius * Math.sin(angle);
            double yRadius = radius * Math.cos(angle);
            for (double rot = 0; rot < Math.PI * 2; rot += density) {
                if(entity.getWorld().random.nextBoolean()){
                    double xPos = entity.getX() + xzRadius * Math.cos(rot + rotationOffset);
                    double yPos = entity.getY() + yRadius;
                    double zPos = entity.getZ() + xzRadius * Math.sin(rot + rotationOffset);
                    entity.getWorld().addParticle(ParticleTypes.FLAME, xPos, yPos, zPos, 0.0, 0.0, 0.0);
                }
            }
        }
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }
}
