package net.nikk.beyondcultivation.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.spawner.Spawner;
import net.nikk.beyondcultivation.util.AttributeData;
import net.nikk.beyondcultivation.util.IEntityDataSaver;
import net.nikk.beyondcultivation.world.spawner.SpiritFoxSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
    /*@ModifyArg(method = "spawnEntity", at = @At(value = "INVOKE", target = "net/minecraft/server/world/ServerWorld.addEntity (Lnet/minecraft/entity/Entity;)Z"), index = 0)
    private Entity injected2(Entity entity4) {
        NbtCompound nbt = ((IEntityDataSaver)entity).getPersistentData();
        return entity;
    }*/
    @ModifyVariable(method = "spawnEntity", at = @At(value = "HEAD"), ordinal = 0)
    private Entity injected(Entity entity) {
        if(entity instanceof HorseEntity){
            NbtCompound nbt = ((IEntityDataSaver)entity).getPersistentData();
            Random random = Random.create();
            if(nbt.getBoolean("thousand_lee") || entity.isInvulnerable() || random.nextBetween(1,100)>99){
                nbt.putBoolean("thousand_lee",true);
                int stat_amount = random.nextBetween(50,110);
                AttributeData.addHealth((LivingEntity) entity,1000*stat_amount/100,"qi_health_boost","56056c4f-f20c-40e1-836d-7e64ea6717a8");
                AttributeData.addAttribute((LivingEntity) entity,0.22499999403953552 * stat_amount/100,"qi_speed_boost","ed99bf06-6201-4ca4-a84c-ca810730d9d3", EntityAttributes.GENERIC_MOVEMENT_SPEED);
                AttributeData.addAttribute((LivingEntity) entity,1.0 * stat_amount/100,"qi_jump_boost","7c6fbb29-ba0b-4306-ac51-523b7497c524", EntityAttributes.HORSE_JUMP_STRENGTH);
            }
        }
        return entity;
    }
}
