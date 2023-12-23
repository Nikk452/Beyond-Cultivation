package net.nikk.beyondcultivation.entity.ai;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.util.math.Box;
import net.minecraft.village.VillagerType;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpiritFoxDisguiseGoal extends Goal {
    private final SpiritFoxEntity spiritFox;
    public SpiritFoxDisguiseGoal(SpiritFoxEntity spiritFoxEntity) {
        this.spiritFox = spiritFoxEntity;
    }

    public boolean canStart() {
        if (this.spiritFox.isDisguised() || this.spiritFox.actionCooldown>0) {
            return false;
        } else {
            return this.spiritFox.getRandom().nextBetween(0,1000)==499;
        }
    }

    public boolean shouldContinue() {
        return false;
    }

    public void start() {
        List<LivingEntity> livingEntityList = List.of(new FoxEntity(EntityType.FOX, spiritFox.getWorld()),new VillagerEntity(EntityType.VILLAGER,spiritFox.getWorld(), VillagerType.forBiome(this.spiritFox.getEntityWorld().getBiome(this.spiritFox.getBlockPos()))));
        Box box = (new Box(this.spiritFox.getBlockPos())).expand(10 * this.spiritFox.getTailsNumber()).stretch(0.0, (double)this.spiritFox.getWorld().getHeight(), 0.0);
        List<PlayerEntity> list = this.spiritFox.getWorld().getNonSpectatingEntities(PlayerEntity.class, box);
        LivingEntity livingEntity;
        if(list.isEmpty()){
            livingEntity = Util.getRandom(livingEntityList,this.spiritFox.getRandom());
            if(livingEntity instanceof VillagerEntity) ;
        }
        else{
            PlayerEntity player = Util.getRandom(list,this.spiritFox.getRandom());
            livingEntity = Util.getRandom(List.of(livingEntityList.get(0),livingEntityList.get(1),player), this.spiritFox.getRandom());
        }
        this.spiritFox.setDisguise(livingEntity);
    }
}
