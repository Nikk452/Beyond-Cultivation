package net.nikk.beyondcultivation.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.mixin.FoliagePlacerTypeInvoker;
import net.nikk.beyondcultivation.world.tree.custom.PeachtreeFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> PEACHTREE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
            "peachtree_foliage_placer", PeachtreeFoliagePlacer.CODEC);

    public static void register() {
        BCMod.LOGGER.info("Registering the Foliage Placers for " + BCMod.MOD_ID);
    }
}
