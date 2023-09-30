package net.nikk.beyondcultivation.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.mixin.TrunkPlacerTypeInvoker;
import net.nikk.beyondcultivation.world.tree.custom.PeachtreeTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> PEACHTREE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("peachtree_trunk_placer",
            PeachtreeTrunkPlacer.CODEC);

    public static void register() {
        BCMod.LOGGER.info("Registering Trunk Placer for " + BCMod.MOD_ID);
    }
}
