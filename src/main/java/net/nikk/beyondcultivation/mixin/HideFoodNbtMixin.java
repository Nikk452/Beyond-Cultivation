package net.nikk.beyondcultivation.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(targets = {"net/minecraft/server/network/ServerPlayerEntity$1"})
public abstract class HideFoodNbtMixin {
    private boolean x = false;
    @ModifyVariable(method = "updateState(Lnet/minecraft/screen/ScreenHandler;Lnet/minecraft/util/collection/DefaultedList;Lnet/minecraft/item/ItemStack;[I)V", at = @At("HEAD"), ordinal = 0)
    private DefaultedList<ItemStack> injected(DefaultedList<ItemStack> stacks) {
        DefaultedList<ItemStack> newList = DefaultedList.ofSize(stacks.size(), ItemStack.EMPTY);
        for (int i = 0;i<stacks.size();i++) {
            ItemStack stack = stacks.get(i).copy();
            if(stack.isFood() && stack.hasNbt()){
                stack.setNbt(new NbtCompound());
            }
            newList.set(i,stack);
        }
        if(this.x) return newList;
        else {
            this.x = true;
            return stacks;
        }
    }
    @ModifyVariable(method = "updateSlot(Lnet/minecraft/screen/ScreenHandler;ILnet/minecraft/item/ItemStack;)V", at = @At("HEAD"), ordinal = 0)
    private ItemStack injected(ItemStack oldStack) {
        ItemStack stack = oldStack.copy();
        if(stack.isFood() && stack.hasNbt()){
            stack.setNbt(new NbtCompound());
        }
        return stack;
    }
}
