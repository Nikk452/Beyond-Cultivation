package net.nikk.beyondcultivation.entity.custom;

import com.mojang.datafixers.types.Type;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.ai.SpiritFoxAttackGoal;
import net.nikk.beyondcultivation.entity.variant.SpiritFoxVariant;
import net.nikk.beyondcultivation.util.AttributeData;
import org.jetbrains.annotations.Nullable;

public class SpiritFoxEntity extends AnimalEntity{
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> TAILS_NUMBER =
            DataTracker.registerData(SpiritFoxEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public final AnimationState idleAnimationState = new AnimationState();
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
    public int getTailsNumber(){
        return this.dataTracker.get(TAILS_NUMBER);
    }
    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(SpiritFoxVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

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
        BCMod.LOGGER.info("Debug: summoned a fox with "+this.getTailsNumber()+" tails skin version "+this.getTypeVariant());
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
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
        nbt.putInt("Tails",this.getTailsNumber());
    }
}
