package net.nikk.beyondcultivation.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Optional;

public class ThousandLeeSpawnEgg extends SpawnEggItem {
    public ThousandLeeSpawnEgg(int primaryColor, int secondaryColor, Settings settings) {
        super(EntityType.HORSE, primaryColor, secondaryColor, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        NbtCompound entityTag = new NbtCompound();
        entityTag.putString("id","minecraft:horse");
        entityTag.putBoolean("Glowing",true);
        NbtCompound nbt1 = new NbtCompound();
        nbt1.putBoolean("thousand_lee", true);
        entityTag.put("beyondcultivation.custom",nbt1);
        context.getStack().getOrCreateNbt().put("EntityTag",entityTag);
        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        NbtCompound entityTag = new NbtCompound();
        entityTag.putString("id","minecraft:horse");
        //entityTag.putBoolean("Glowing",true);
        NbtCompound nbt1 = new NbtCompound();
        nbt1.putBoolean("thousand_lee", true);
        entityTag.put("beyondcultivation.custom",nbt1);
        user.getStackInHand(hand).getOrCreateNbt().put("EntityTag",entityTag);
        return super.use(world, user, hand);
    }

    /*@Override
    public ItemStack getDefaultStack() {
        ItemStack itemStack = super.getDefaultStack();
        NbtCompound nbt = itemStack.getOrCreateNbt();
        NbtCompound entityTag = new NbtCompound();
        entityTag.putString("id","minecraft:horse");
        entityTag.putBoolean("Glowing",true);
        NbtCompound nbt1 = new NbtCompound();
        nbt1.putBoolean("thousand_lee", true);
        entityTag.put("beyondcultivation.custom",nbt1);
        nbt.put("EntityTag",entityTag);
        return itemStack;
    }*/
}
