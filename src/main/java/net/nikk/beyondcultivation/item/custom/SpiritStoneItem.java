package net.nikk.beyondcultivation.item.custom;

import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.nikk.beyondcultivation.screen.handler.ApertureScreenHandler;

public class SpiritStoneItem extends Item {
    private static final String TAG_ITEMS = "Items";
    public SpiritStoneItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            user.openHandledScreen(new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
                ItemStack book = user.getStackInHand(hand);
                NbtList itemsTag = book.getOrCreateNbt().getList(TAG_ITEMS, NbtType.COMPOUND);
                return new ApertureScreenHandler(i, playerInventory);
            }, Text.of("Spell Book")));

            return TypedActionResult.success(user.getStackInHand(hand));
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
