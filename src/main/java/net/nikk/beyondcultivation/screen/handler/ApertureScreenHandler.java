package net.nikk.beyondcultivation.screen.handler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.nikk.beyondcultivation.item.ModItems;
import net.nikk.beyondcultivation.item.custom.PoisonFlaskItem;
import net.nikk.beyondcultivation.screen.ModScreenHandlers;
import net.nikk.beyondcultivation.util.IEntityDataSaver;

public class ApertureScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public ApertureScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9)); // 9 slots for your custom UI
    }

    public ApertureScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModScreenHandlers.APERTURE_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        // 1. CONSTRUCTOR: Only sets up the static slots (Hotbar)
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        // Required logic for shift-clicking items
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        IEntityDataSaver dataSaver = (IEntityDataSaver) player;
        NbtCompound data = dataSaver.getPersistentData();
        NbtList list = data.getList("ApertureEntities", NbtElement.COMPOUND_TYPE);

        if (id == -1) {
            // CAPTURE logic goes here...
            return handleCapture(list, data, id);
        } else if (id >= 0) {
            // RELEASE logic goes here...
            return handleRelease(list, data, id);
        }
        return false;
    }
    private boolean handleCapture(NbtList list, NbtCompound data, int id) {
        ItemStack cursorStack = this.getCursorStack();
        if (cursorStack.isOf(ModItems.TEST_POISON) && 64 > list.size()) {
            NbtCompound nbt = cursorStack.getOrCreateNbt().getCompound("SavedEntity");
            if(!nbt.isEmpty()){
                list.add(nbt);
                data.put("ApertureEntities", list);
                this.setCursorStack(ItemStack.EMPTY);
                return true;
            }
        }
        return false;
    }

    private boolean handleRelease(NbtList list, NbtCompound data, int index) {
        if (this.getCursorStack().isEmpty() && index < list.size()) {
            ItemStack stack = ModItems.TEST_POISON.getDefaultStack();
            NbtCompound entityData = list.getCompound(0);
            stack.getOrCreateNbt().put("SavedEntity",entityData);
            list.remove(0);
            data.put("ApertureEntities", list);
            // ... release code ...
            // this.setCursorStack(newStack);
            return true;
        }
        return false;
    }
}
