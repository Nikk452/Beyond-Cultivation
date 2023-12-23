package net.nikk.beyondcultivation;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.nikk.beyondcultivation.block.ModBlocks;
import net.nikk.beyondcultivation.block.entity.ModBlockEntities;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.RedPandaEntity;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;
import net.nikk.beyondcultivation.item.ModItemGroup;
import net.nikk.beyondcultivation.item.ModItems;
import net.nikk.beyondcultivation.util.ModRegistries;
import net.nikk.beyondcultivation.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BCMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "beyondcultivation";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModRegistries.registerModStuff();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModWorldGeneration.generateModWorldGeneration();
		LOGGER.info("Hello Fabric world!");
	}
}