package net.nikk.beyondcultivation.entity.custom;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.types.Type;
import net.fabricmc.fabric.api.entity.FakePlayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.StructureTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.VillageGossipType;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.ai.SpiritFoxAttackGoal;
import net.nikk.beyondcultivation.entity.ai.SpiritFoxDisguiseGoal;
import net.nikk.beyondcultivation.entity.variant.SpiritFoxVariant;
import net.nikk.beyondcultivation.util.AttributeData;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpiritFoxEntity extends AnimalEntity{
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> TAILS_NUMBER =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<NbtCompound> DISGUISE_ENTITY =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.NBT_COMPOUND);
    private LivingEntity disguisedEntity;
    private static final TrackedData<String> DISGUISE_ID =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.STRING);
    private static final TrackedData<Boolean> SMOKESCREEN =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    public int actionCooldown = 0;
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState sitAnimationState = new AnimationState();

    public SpiritFoxEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1,new SpiritFoxDisguiseGoal(this));

        this.goalSelector.add(1, new SpiritFoxAttackGoal(this, 1.1D, true));

        this.goalSelector.add(2, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(3, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.COOKED_BEEF), false));

        this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));

        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
        this.dataTracker.startTracking(TAILS_NUMBER,1);
        this.dataTracker.startTracking(DISGUISE_ENTITY,new NbtCompound());
        this.dataTracker.startTracking(DISGUISE_ID,"minecraft:empty");
        this.dataTracker.startTracking(SMOKESCREEN,false);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40; // THIS IS LENGTH OF ANIMATION IN TICKS
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        if(this.isDisguised()){
            if(this.getDisguisedEntity() instanceof VillagerEntity){
                return SoundEvents.ENTITY_VILLAGER_HURT;
            } else if (this.getDisguisedEntity() instanceof PlayerEntity) {
                return SoundEvents.ENTITY_PLAYER_HURT;
            }
        }
        return SoundEvents.ENTITY_FOX_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if(this.isDisguised()){
            if(this.getDisguisedEntity() instanceof VillagerEntity){
                return SoundEvents.ENTITY_VILLAGER_AMBIENT;
            } else if (this.getDisguisedEntity() instanceof PlayerEntity) {
                return super.getAmbientSound();
            }
        }
        if (!this.getWorld().isDay() && this.random.nextFloat() < 0.1F) {
            List<PlayerEntity> list = this.getWorld().getEntitiesByClass(PlayerEntity.class, this.getBoundingBox().expand(16.0, 16.0, 16.0), EntityPredicates.EXCEPT_SPECTATOR);
            if (list.isEmpty()) {
                return SoundEvents.ENTITY_FOX_SCREECH;
            }
        }

        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    protected void updateLimbs(float v) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
        if(this.actionCooldown>0) this.actionCooldown-=this.getTailsNumber();
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if(this.isDisguised()) {
            if(this.getTailsNumber()<=3 || amount>20 || random.nextInt(99)>90){
                this.setDisguise((LivingEntity) null);
            }else if(this.getDisguisedEntity() instanceof VillagerEntity && source.getAttacker()!=null) if(source.getAttacker().isPlayer()){
                for(int i = 0; i < 5; ++i) {
                    double d = this.random.nextGaussian() * 0.02;
                    double e = this.random.nextGaussian() * 0.02;
                    double f = this.random.nextGaussian() * 0.02;
                    this.getWorld().addParticle(ParticleTypes.ANGRY_VILLAGER, this.getParticleX(1.0), this.getRandomBodyY() + 1.0, this.getParticleZ(1.0), d, e, f);
                }
                ((VillagerEntity) this.getDisguisedEntity()).getGossip().startGossip(source.getAttacker().getUuid(), VillageGossipType.MINOR_NEGATIVE, 25);
            }
        }
        return super.damage(source, amount);
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        if(this.isDisguised()){
            return new EntityDimensions(0.6F,this.getDisguiseID().equals("minecraft:player")?1.8F:this.getDisguiseID().equals("minecraft:fox")?0.7F:1.95F,false);
        }else return super.getDimensions(pose);
    }

    @Override
    public float getEyeHeight(EntityPose pose) {
        if(this.getDisguisedEntity() !=null) {
            return this.getDisguisedEntity().getEyeHeight(this.getPose());
        }
        else return this.getEyeHeight(pose,this.getDimensions(this.getPose()));
    }
    private LivingEntity getDisguisedEntity(){
        if(this.isDisguised()) {
            if(disguisedEntity==null) {
                var entityType = EntityType.get(this.getDisguiseID()).orElse(EntityType.ZOMBIE);
                if (this.getDisguiseID().equals("minecraft:player")) {
                    disguisedEntity = this.getEntityWorld().getPlayerByUuid(this.getDisguise().getUuid("UUID"));
                } else {
                    disguisedEntity = (LivingEntity) entityType.create(this.getWorld());
                }
                if(disguisedEntity!=null) disguisedEntity.writeNbt(this.getDisguise());
            }
            return disguisedEntity;
        }
        return null;
    }
    public static DefaultAttributeContainer.Builder createSpiritFoxAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1);
    }
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
    /* VARIANT */

    public SpiritFoxVariant getVariant() {
        return SpiritFoxVariant.byId(this.getTypeVariant() & 255);
    }
    public boolean shouldSmokeScreen(){return this.dataTracker.get(SMOKESCREEN);}
    public int getTailsNumber(){
        return this.dataTracker.get(TAILS_NUMBER);
    }
    public int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }
    public NbtCompound getDisguise() {
        return this.dataTracker.get(DISGUISE_ENTITY);
    }
    public String getDisguiseID(){return this.dataTracker.get(DISGUISE_ID);}
    private void setVariant(SpiritFoxVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    //private void setDisguise(NbtCompound nbtCompound) {
    //    this.dataTracker.set(DISGUISE_ENTITY, nbtCompound);
    //}
    public void setSmokeScreen(boolean b){this.dataTracker.set(SMOKESCREEN,b);}
    private void setDisguiseId(String string){this.dataTracker.set(DISGUISE_ID,string);}
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        SpiritFoxVariant variant = Util.getRandom(SpiritFoxVariant.values(), this.random);
        setVariant(variant);
        this.dataTracker.set(TAILS_NUMBER, Util.getRandom(
                        new int[]{
                                1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,
                                4,4,4,4,4,4,5,5,5,5,5,6,6,6,6,7,7,7,8,8,9},
                        this.random));
        BCMod.LOGGER.info("Debug: summoned a fox with "+this.getTailsNumber()+" tails skin version "+this.getTypeVariant() + " at "+this.getBlockPos().toShortString());
        AttributeData.addHealth(this,110*this.getTailsNumber(),"qi_health_boost","56056c4f-f20c-40e1-836d-7e64ea6717a8");
        AttributeData.addAttribute(this,0.22499999403953552 * (0.1*this.getTailsNumber()) ,"qi_speed_boost","ed99bf06-6201-4ca4-a84c-ca810730d9d3", EntityAttributes.GENERIC_MOVEMENT_SPEED);
        AttributeData.addAttribute(this,11.0 *this.getTailsNumber(),"qi_attack_boost","7c6fbb29-ba0b-4306-ac51-523b7497c524", EntityAttributes.GENERIC_ATTACK_DAMAGE);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
        this.dataTracker.set(TAILS_NUMBER,nbt.getInt("Tails"));
        this.dataTracker.set(DISGUISE_ENTITY,nbt.getCompound("Disguise"));
        this.dataTracker.set(DISGUISE_ID,nbt.getString("DisguiseID"));
        this.dataTracker.set(SMOKESCREEN,nbt.getBoolean("SmokeScreen"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
        nbt.putInt("Tails",this.getTailsNumber());
        nbt.put("Disguise",this.getDisguise());
        nbt.putString("DisguiseID",this.getDisguiseID());
        nbt.putBoolean("SmokeScreen",this.shouldSmokeScreen());
    }

    public boolean isDisguised() {
        return !(this.getDisguise().isEmpty());
    }

    public void setDisguise(LivingEntity livingEntity) {
        this.setSmokeScreen(true);
        if(livingEntity!=null){
            this.disguisedEntity = livingEntity;
            NbtCompound nbtCompound = new NbtCompound();
            livingEntity.writeNbt(nbtCompound);
            if(livingEntity instanceof PlayerEntity) {
                String[] d = {"Kitsu", "Kitsune", "Hulijing", "Kumiho", "Fox", "SpiritFox"};
                String s = Util.getRandom(d, random) + (random.nextBoolean() ? random.nextBetween(0, 900) : "");
                s = random.nextBoolean() ? s : new StringBuilder(s).reverse().toString();
                nbtCompound.putString("CustomName", Text.Serializer.toJson(Text.literal(s)));
                nbtCompound.putString("FoxName",s);
            }
            String entityId = EntityType.getId(livingEntity.getType()).toString();
            this.dataTracker.set(DISGUISE_ID, entityId);
            this.dataTracker.set(DISGUISE_ENTITY,nbtCompound);
            this.actionCooldown = 1000;
        }
        else{
            this.dataTracker.set(DISGUISE_ENTITY,new NbtCompound());
            this.dataTracker.set(DISGUISE_ID, "minecraft:empty");
        }
    }
}
