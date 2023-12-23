package net.nikk.beyondcultivation.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.spawner.CatSpawner;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;
import net.nikk.beyondcultivation.entity.custom.TigerEntity;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                SpawnGroup.CREATURE, ModEntities.TIGER, 10, 1, 2);
        SpawnRestriction.register(ModEntities.TIGER, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TigerEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST,BiomeKeys.BAMBOO_JUNGLE,BiomeKeys.CHERRY_GROVE,BiomeKeys.DARK_FOREST,BiomeKeys.DESERT,BiomeKeys.JUNGLE,BiomeKeys.TAIGA,BiomeKeys.SWAMP,BiomeKeys.STONY_PEAKS,BiomeKeys.SAVANNA,BiomeKeys.CRIMSON_FOREST),
                SpawnGroup.CREATURE, ModEntities.SPIRIT_FOX, 1, 1, 1);
        SpawnRestriction.register(ModEntities.SPIRIT_FOX, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpiritFoxEntity::isValidNaturalSpawn);

    }
}
