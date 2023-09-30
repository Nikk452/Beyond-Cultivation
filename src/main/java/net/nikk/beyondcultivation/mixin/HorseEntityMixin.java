package net.nikk.beyondcultivation.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorseEntity.class)
public abstract class HorseEntityMixin extends LivingEntity {
    protected HorseEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    @Inject(method = "createBaseHorseAttributes", at = @At("RETURN"), cancellable = true)
    private static void setMaxHealthAttribute(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir){
        DefaultAttributeContainer.Builder builder = cir.getReturnValue();
        builder.add(EntityAttributes.HORSE_JUMP_STRENGTH,1.5f).add(EntityAttributes.GENERIC_MAX_HEALTH, 530.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.45);
    }
}
