package net.nikk.beyondcultivation.entity.client;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.DisguisePlayer;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.entity.layer.ModModelLayers;
import net.nikk.beyondcultivation.entity.variant.SpiritFoxVariant;
import net.nikk.beyondcultivation.mixin.EntityRendererAccessor;
import net.nikk.beyondcultivation.mixin.LimbAnimatorAccessor;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class SpiritFoxRenderer extends MobEntityRenderer<SpiritFoxEntity, SpiritFoxModel<SpiritFoxEntity>> {
    private LivingEntity disguiseEntity;
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
        this.getModel().getPart().getChild("tail").getChild("upright").visible = tails_number > 1;
        this.getModel().getPart().getChild("tail").getChild("up").visible = tails_number > 6 || tails_number==3 || tails_number==5;
        this.getModel().getPart().getChild("tail").getChild("upleft").visible = tails_number > 1;
        this.getModel().getPart().getChild("tail").getChild("right").visible = tails_number > 3;
        this.getModel().getPart().getChild("tail").getChild("middle").visible = tails_number ==1 || tails_number>8;
        this.getModel().getPart().getChild("tail").getChild("left").visible = tails_number > 3;
        this.getModel().getPart().getChild("tail").getChild("downright").visible = tails_number > 5;
        this.getModel().getPart().getChild("tail").getChild("down").visible = tails_number > 7;
        this.getModel().getPart().getChild("tail").getChild("downleft").visible =  tails_number > 5;
        if(mobEntity.shouldSmokeScreen()){
            for(double iz = 0;iz<90;iz+=5)mobEntity.getWorld().addParticle(ParticleTypes.CLOUD,mobEntity.getX()+Math.cos(iz)/2,mobEntity.getY(),mobEntity.getZ()+Math.sin(iz)/2,0,0.1,0);
            mobEntity.setSmokeScreen(false);
        }
        if(mobEntity.isDisguised()) {
            var entityType = EntityType.get(mobEntity.getDisguiseID()).orElse(EntityType.ZOMBIE);
            LivingEntity disguise;
            if(mobEntity.getDisguiseID().equals("minecraft:player")){
                disguise = new DisguisePlayer((ClientWorld) mobEntity.getWorld(),new GameProfile(mobEntity.getDisguise().getUuid("UUID"), mobEntity.getDisguise().getString("FoxName")));
                disguise.readNbt(mobEntity.getDisguise());
            } else{
                disguise = (LivingEntity) entityType.create(mobEntity.getWorld());
            }
            if(disguise!=null){
                LimbAnimatorAccessor target = (LimbAnimatorAccessor) disguise.limbAnimator;
                LimbAnimatorAccessor source = (LimbAnimatorAccessor) mobEntity.limbAnimator;
                target.setPrevSpeed(source.getPrevSpeed());
                target.setSpeed(source.getSpeed());
                target.setPos(source.getPos());
                mobEntity.calculateDimensions();
                disguise.handSwinging = mobEntity.handSwinging;
                disguise.handSwingTicks = mobEntity.handSwingTicks;
                disguise.lastHandSwingProgress = mobEntity.lastHandSwingProgress;
                disguise.handSwingProgress = mobEntity.handSwingProgress;
                disguise.bodyYaw = mobEntity.bodyYaw;
                disguise.prevBodyYaw = mobEntity.prevBodyYaw;
                disguise.headYaw = mobEntity.headYaw;
                disguise.prevHeadYaw = mobEntity.prevHeadYaw;
                disguise.age = mobEntity.age;
                disguise.preferredHand = mobEntity.preferredHand;
                disguise.setPitch(mobEntity.getPitch());
                disguise.prevPitch = mobEntity.prevPitch;
                disguise.setOnGround(mobEntity.isOnGround());
                disguise.setVelocity(mobEntity.getVelocity());
                disguise.equipStack(EquipmentSlot.MAINHAND, mobEntity.getEquippedStack(EquipmentSlot.MAINHAND));
                disguise.equipStack(EquipmentSlot.OFFHAND, mobEntity.getEquippedStack(EquipmentSlot.OFFHAND));
                disguise.equipStack(EquipmentSlot.HEAD, mobEntity.getEquippedStack(EquipmentSlot.HEAD));
                disguise.equipStack(EquipmentSlot.CHEST, mobEntity.getEquippedStack(EquipmentSlot.CHEST));
                disguise.equipStack(EquipmentSlot.LEGS, mobEntity.getEquippedStack(EquipmentSlot.LEGS));
                disguise.equipStack(EquipmentSlot.FEET, mobEntity.getEquippedStack(EquipmentSlot.FEET));
                disguise.setPose(mobEntity.getPose());
                disguise.hurtTime = mobEntity.hurtTime;
                disguise.maxHurtTime = mobEntity.maxHurtTime;
                if (disguise instanceof MobEntity) {
                    ((MobEntity) disguise).setAttacking(mobEntity.isAttacking());
                }
                disguise.setCurrentHand(mobEntity.getActiveHand() == null ? Hand.MAIN_HAND : mobEntity.getActiveHand());
                shadowRadius = ((EntityRendererAccessor) dispatcher.getRenderer(disguise)).getShadowRadius();
                matrixStack.scale(1,1,1);
                dispatcher.getRenderer(disguise).render(disguise, f, g, matrixStack, vertexConsumerProvider, i);
            }else {
                BCMod.LOGGER.info("entity is null");
                matrixStack.scale(size, size, size);
                super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
            }
        } else {
            mobEntity.calculateDimensions();
            matrixStack.scale(size, size, size);
            super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        }
    }
}
