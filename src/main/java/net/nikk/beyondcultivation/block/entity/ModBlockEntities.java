package net.nikk.beyondcultivation.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.block.ModBlocks;

public class ModBlockEntities {
    //public static final BlockEntityType<GemEmpoweringStationBlockEntity> GEM_EMPOWERING_STATION_BE =
    //        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MCCourseMod.MOD_ID, "gem_empowering_block_entity"),
    //                FabricBlockEntityTypeBuilder.create(GemEmpoweringStationBlockEntity::new,
    //                        ModBlocks.GEM_EMPOWERING_STATION).build(null));
    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                    ModBlocks.PEACHTREE_SIGN, ModBlocks.PEACHTREE_WALL_SIGN).build());

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                    ModBlocks.PEACHTREE_HANGING_SIGN, ModBlocks.PEACHTREE_HANGING_WALL_SIGN).build(null));
    public static void registerBlockEntities() {
        BCMod.LOGGER.info("Registering Block Entities for " + BCMod.MOD_ID);

        //EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, GEM_EMPOWERING_STATION_BE);
        //FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, GEM_EMPOWERING_STATION_BE);
    }
}
