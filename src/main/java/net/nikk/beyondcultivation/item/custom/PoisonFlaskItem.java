package net.nikk.beyondcultivation.item.custom;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PoisonFlaskItem extends Item {
    public PoisonFlaskItem(Settings settings) {
        super(settings);
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
