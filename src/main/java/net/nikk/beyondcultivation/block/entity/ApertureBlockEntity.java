package net.nikk.beyondcultivation.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.nikk.beyondcultivation.screen.handler.ApertureBlockScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ApertureBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(81, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int max_water = 100;
    private int rank_progress = 1;
    private int break_progress = 0;
    private static final int[] essence_colorsf = {43115,38513,25671,6929,
                                                16764107,16720896,14423100,9109504,
                                                13882323,14869218,14737632,16775930,
                                                16772235,16766720,13413376,14329120,
                                                14725375,9371903,3152180,6488880};
    private static final int[] essence_colors = {8454079,6750105,3381555,26112,
                                                16743014,16720896,16720896,9109504,
                                                13882323,15987711,15987699,15396077,
                                                16772235,16766720,13413376,14329120,
                                                14725375,8608163,9260747,9371903};
    public Map<Item, Position> entityPositions = new HashMap<>();

    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<>() {
        @Override
        protected FluidVariant getBlankVariant() { return FluidVariant.blank(); }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return (1L << (rank_progress-1))* max_water;
        }

        @Override
        protected void onFinalCommit() {
            update();
        }
    };

    public ApertureBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.APERTURE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> (int)ApertureBlockEntity.this.fluidStorage.amount;
                    case 1 -> ApertureBlockEntity.this.max_water;
                    case 2 -> ApertureBlockEntity.this.rank_progress;
                    case 3 -> ApertureBlockEntity.this.break_progress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ApertureBlockEntity.this.fluidStorage.amount = value;
                    case 1 -> ApertureBlockEntity.this.max_water = value;
                    case 2 -> ApertureBlockEntity.this.rank_progress = value;
                    case 3 -> ApertureBlockEntity.this.break_progress = value;
                }
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.of("Mortal Aperture");
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("aperture.rank", rank_progress);
        nbt.putInt("aperture.progress", break_progress);
        nbt.put("fluidVariant", fluidStorage.variant.toNbt());
        nbt.putLong("amount", fluidStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        rank_progress = nbt.getInt("aperture.rank");
        break_progress = nbt.getInt("aperture.progress");
        fluidStorage.variant = FluidVariant.fromNbt(nbt.getCompound("fluidVariant"));
        fluidStorage.amount = nbt.getLong("amount");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ApertureBlockScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    private void update() {
        markDirty();
        // Force a sync to nearby clients so the BER updates the water level
        if (world != null && !world.isClient) {
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }
        if (world.getTime() % 20 == 0) { //1200 for per minute
            try (Transaction transaction = Transaction.openOuter()) {
                // Insert 81 droplets (approx. 1mb or 1/1000th of a bucket)
                this.fluidStorage.insert(FluidVariant.of(Fluids.WATER), (1L << (rank_progress-1)) , transaction);
                transaction.commit();
                update();
            }
        }
    }

    public float getWallsRGB(){
        return ((float) (4- (this.rank_progress - 1) % 4) / 8) +0.5f;
    }
    public int getWaterColor(){
        //return FluidVariantRendering.getColor(this.fluidStorage.variant, world, pos);
        return essence_colors[this.rank_progress-1];
    }
}
