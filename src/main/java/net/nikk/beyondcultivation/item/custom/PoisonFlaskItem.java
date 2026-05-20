package net.nikk.beyondcultivation.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.entity.spells.SpellEntity;

public class PoisonFlaskItem extends Item {
    public PoisonFlaskItem(Settings settings) {
        super(settings.maxDamage(100));
    }
    @Override
    public Text getName(ItemStack stack) {
        return Text.of("Spirit Fox Gu");
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        World world = entity.getEntityWorld();
        ItemStack stack = entity.getStack();
        if(!world.isClient()){
            NbtCompound nbt = stack.getOrCreateNbt().getCompound("SavedEntity");
            var entitytype = ModEntities.SPIRIT_FOX;
            var living = entitytype.create(world);
            if(living != null){
                if(nbt!=null){
                    BCMod.LOGGER.debug("Debug: gu entity was spawned from item");
                    living.readCustomDataFromNbt(nbt);
                }
                Vec3d spawnPos = entity.getOwner() !=null ? getSafeSpawnPos(entity.getOwner(),1): entity.getPos();
                living.refreshPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0, 0);
                world.spawnEntity(living);
            }
        }
        super.onItemEntityDestroyed(entity);
    }
    public Vec3d getSafeSpawnPos(Entity owner, double maxDistance) {
        // 1. Check if owner is null

        Vec3d start = owner.getEyePos();
        Vec3d end = start.add(owner.getRotationVector().multiply(maxDistance));

        // Create a raycast context that looks for solid blocks (COLLIDER)
        RaycastContext context = new RaycastContext(
                start,
                end,
                RaycastContext.ShapeType.COLLIDER, // Detects solid blocks
                RaycastContext.FluidHandling.NONE,  // Ignores water/lava
                owner
        );

        BlockHitResult hit = owner.getWorld().raycast(context);

        if (hit.getType() == HitResult.Type.BLOCK) {
            // If we hit a block, return the position just before the wall
            // Using .subtract pushes it back slightly so it's not "inside" the face
            return hit.getPos().subtract(owner.getRotationVector().multiply(0.9));
        }

        return end; // No block in the way
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(itemStack.getOrCreateNbt().getInt("rank")>0){
            if(!world.isClient()){
                SpellEntity abstractarrowentity = createArrow(world, itemStack, user);
                abstractarrowentity.setVelocity(user, user.getPitch(), user.getYaw(),
                        0.0F, 3.0F, 0.0F);
                abstractarrowentity.setDamage(2.5);
                abstractarrowentity.age = 35;
                abstractarrowentity.hasNoGravity();
                world.spawnEntity(abstractarrowentity);
            }
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.getAbilities().creativeMode) {
                itemStack.damage(1, user, (p) -> p.sendToolBreakStatus(hand));
                if(isSingleUse()){
                    itemStack.decrement(1);
                    return TypedActionResult.consume(itemStack);
                }
            }
            return TypedActionResult.success(itemStack);
        }
        else return super.use(world, user, hand);
    }
    public SpellEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        SpellEntity arrowentity = new SpellEntity(worldIn, shooter);
        return arrowentity;
    }

    public void setEntityInfo(ItemStack stack, SpiritFoxEntity entity) {
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt("rank",entity.getTailsNumber());
    }

    public int getRank(ItemStack stack){
        NbtCompound nbt = stack.getOrCreateNbt();
        return nbt.getInt("rank");
    }

    public boolean isSingleUse(){
        return false;
    }
    //@Override
    //public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //ItemStack itemStack = user.getStackInHand(hand);
        //ItemStack itemStack2 = user.getMainHandStack();
        //if(itemStack2.isFood()){
        //    itemStack2.addEnchantment(Enchantments.AQUA_AFFINITY,2);
        //    return TypedActionResult.consume(itemStack);
        //}
        //return super.use(world, user, hand);
    //}
}
