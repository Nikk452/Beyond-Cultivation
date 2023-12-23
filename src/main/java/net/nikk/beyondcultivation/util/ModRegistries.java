package net.nikk.beyondcultivation.util;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.QilinEntity;
import net.nikk.beyondcultivation.entity.custom.RedPandaEntity;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;
import net.nikk.beyondcultivation.event.UseItemEvent;

public class ModRegistries {
    public static void registerModStuff(){
        registerFlammables();
        registerStrippables();
        registerAttributes();
        registerEvents();
    }
    private static void registerEvents(){
        UseItemCallback.EVENT.register(new UseItemEvent());
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.createTigerAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.RED_PANDA, RedPandaEntity.createRedPandaAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.QILIN, QilinEntity.createQilinAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SPIRIT_FOX, SpiritFoxEntity.createSpiritFoxAttributes());
    }
    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PEACHTREE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PEACHTREE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PLUM_BLOSSOM_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PLUM_BLOSSOM_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PLUM_BLOSSOM_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PLUM_BLOSSOM_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PEACHTREE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PLUM_BLOSSOM_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PLUM_BLOSSOM_LEAVES, 30, 60);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.PEACHTREE_LOG, ModBlocks.STRIPPED_PEACHTREE_LOG);
        StrippableBlockRegistry.register(ModBlocks.PEACHTREE_WOOD, ModBlocks.STRIPPED_PEACHTREE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.PLUM_BLOSSOM_LOG, ModBlocks.STRIPPED_PLUM_BLOSSOM_LOG);
        StrippableBlockRegistry.register(ModBlocks.PLUM_BLOSSOM_WOOD, ModBlocks.STRIPPED_PLUM_BLOSSOM_WOOD);
    }
}
