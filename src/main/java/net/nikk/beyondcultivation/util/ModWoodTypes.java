package net.nikk.beyondcultivation.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;

public class ModWoodTypes {
    public static final WoodType PEACHTREE = WoodTypeRegistry.register(new Identifier(BCMod.MOD_ID, "peachtree"), BlockSetType.CHERRY);
}
