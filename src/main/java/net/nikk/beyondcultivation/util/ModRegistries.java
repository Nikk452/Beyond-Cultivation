package net.nikk.beyondcultivation.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.QilinEntity;
import net.nikk.beyondcultivation.entity.custom.RedPandaEntity;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;

public class ModRegistries {
    public static void registerModStuff(){
        registerFlammables();
        registerStrippables();
        registerAttributes();
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.createTigerAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.RED_PANDA, RedPandaEntity.createRedPandaAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.QILIN, QilinEntity.createQilinAttributes());
    }
    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PEACHTREE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PEACHTREE_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_LEAVES, 30, 60);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.PEACHTREE_LOG, ModBlocks.STRIPPED_PEACHTREE_LOG);
        StrippableBlockRegistry.register(ModBlocks.PEACHTREE_WOOD, ModBlocks.STRIPPED_PEACHTREE_WOOD);
    }
}
