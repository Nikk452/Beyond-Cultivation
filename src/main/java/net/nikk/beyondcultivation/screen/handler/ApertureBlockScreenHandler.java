package net.nikk.beyondcultivation.screen.handler;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.nikk.beyondcultivation.screen.ModScreenHandlers;

public class ApertureBlockScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    // Client-side constructor
    public ApertureBlockScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf byteBuf) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(byteBuf.readBlockPos()),
                new ArrayPropertyDelegate(4)); //amount of delegates
    }

    // Server-side constructor
    public ApertureBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.APERTURE_BLOCK_SCREEN_HANDLER, syncId);
        //storage
        checkSize(((Inventory) blockEntity), 81);
        this.inventory = (Inventory) blockEntity;
        inventory.onOpen(playerInventory.player);
        int startX = 12;
        int startY = 8;

        // Storage Grid (9x9)
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // We use 18 because each slot is 18x18 pixels including the border
                this.addSlot(new Slot(inventory, col + row * 9, startX + col * 18, startY + row * 18));
            }
        }

        // Player Inventory (Must move relative to the grid above)
        // If your grid ends at startY + (9 * 18), let's put the player inv below it
        int playerInvY = startY + (9 * 18) + 4; // Adding a 4-pixel gap

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, startX + col * 18, playerInvY + row * 18));
            }
        }

        // Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, startX + col * 18, playerInvY + 58));
        }

        addProperties(arrayPropertyDelegate);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < 81) { // Moving from storage to player
                if (!this.insertItem(originalStack, 81, this.slots.size(), true)) return ItemStack.EMPTY;
            } else { // Moving from player to storage
                if (!this.insertItem(originalStack, 0, 81, false)) return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
