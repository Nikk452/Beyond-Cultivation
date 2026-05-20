package net.nikk.beyondcultivation.entity.spells;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nikk.beyondcultivation.entity.ModEntities;

import java.util.List;

public class SpellEntity extends PersistentProjectileEntity {
    private int ticksInAir;
    public SpellEntity(EntityType<? extends SpellEntity> entityEntityType, World world) {
        super(entityEntityType, world);
        this.calculateDimensions();
    }
    public SpellEntity(World world, LivingEntity owner) {
        super(ModEntities.SPELL, owner, world);
    }

    @Override
    public void age() {
        ++this.ticksInAir;
        if (this.ticksInAir >= 30) {
            this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void onHit(LivingEntity living) {
        super.onHit(living);
        if (!(living instanceof PlayerEntity)) {
            living.setVelocity(0, 0, 0);
            living.timeUntilRegen = 0;
        }
    }

    @Override
    public void setVelocity(double x, double y, double z, float speed, float divergence) {
        super.setVelocity(x, y, z, speed, divergence);
        this.ticksInAir = 0;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putShort("life", (short) this.ticksInAir);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.ticksInAir = tag.getShort("life");
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected ItemStack asItemStack() {
        return Items.AIR.getDefaultStack();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient) {
            this.doDamage();
            this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient) {
            this.doDamage();
            this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        return super.getDimensions(pose).scaled(10);
    }

    public void doDamage() {
        float q = 4.0F;
        int k = MathHelper.floor(this.getX() - (double) q - 1.0D);
        int l = MathHelper.floor(this.getX() + (double) q + 1.0D);
        int t = MathHelper.floor(this.getY() - (double) q - 1.0D);
        int u = MathHelper.floor(this.getY() + (double) q + 1.0D);
        int v = MathHelper.floor(this.getZ() - (double) q - 1.0D);
        int w = MathHelper.floor(this.getZ() + (double) q + 1.0D);
        List<Entity> list = this.getWorld().getOtherEntities(this,
                new Box((double) k, (double) t, (double) v, (double) l, (double) u, (double) w));
        Vec3d vec3d = new Vec3d(this.getX(), this.getY(), this.getZ());
        for (int x = 0; x < list.size(); ++x) {
            Entity entity = (Entity) list.get(x);
            double y = (double) (MathHelper.sqrt((float) entity.squaredDistanceTo(vec3d)) / q);
            if (y <= 1.0D) {
                if (entity instanceof LivingEntity) {
                    entity.damage(this.getDamageSources().mobAttack((LivingEntity) this.getOwner()), 20);
                }
                this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 0.0F,
                        World.ExplosionSourceType.NONE);
            }
        }
    }
}

