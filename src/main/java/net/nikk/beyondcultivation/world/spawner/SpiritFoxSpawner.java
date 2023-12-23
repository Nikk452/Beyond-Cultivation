package net.nikk.beyondcultivation.world.spawner;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.minecraft.world.spawner.Spawner;
import net.nikk.beyondcultivation.entity.ModEntities;
import net.nikk.beyondcultivation.entity.custom.SpiritFoxEntity;

import java.util.List;
@SuppressWarnings("all")
public class SpiritFoxSpawner implements Spawner {
    private static final int SPAWN_INTERVAL = 1200;
    private int cooldown;
    public SpiritFoxSpawner(){}
    @Override
    public int spawn(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals) {
        if (spawnAnimals && world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
            --this.cooldown;
            if (this.cooldown > 0) {
                return 0;
            } else {
                this.cooldown = 1200;
                PlayerEntity playerEntity = world.getRandomAlivePlayer();
                if (playerEntity == null) {
                    return 0;
                } else {
                    Random random = world.random;
                    int i = (8 + random.nextInt(24)) * (random.nextBoolean() ? -1 : 1);
                    int j = (8 + random.nextInt(24)) * (random.nextBoolean() ? -1 : 1);
                    BlockPos blockPos = playerEntity.getBlockPos().add(i, 0, j);
                    if (!world.isRegionLoaded(blockPos.getX() - 10, blockPos.getZ() - 10, blockPos.getX() + 10, blockPos.getZ() + 10)) {
                        return 0;
                    } else {
                        if (SpawnHelper.canSpawn(SpawnRestriction.Location.ON_GROUND, world, blockPos, EntityType.CAT)) {
                            if (world.isNearOccupiedPointOfInterest(blockPos, 2)) {
                                return this.spawnInHouse(world, blockPos);
                            }
                        }

                        return 0;
                    }
                }
            }
        } else {
            return 0;
        }
    }
    private int spawnInHouse(ServerWorld world, BlockPos pos) {
        if (world.getPointOfInterestStorage().count((entry) -> {
            return entry.matchesKey(PointOfInterestTypes.HOME);
        }, pos, 48, PointOfInterestStorage.OccupationStatus.IS_OCCUPIED) > 4L) {
            List<SpiritFoxEntity> list = world.getNonSpectatingEntities(SpiritFoxEntity.class, (new Box(pos)).expand(48.0, 8.0, 48.0));
            if (list.size() < 1) {
                return this.spawn(pos, world);
            }
        }

        return 0;
    }
    private int spawn(BlockPos pos, ServerWorld world) {
        SpiritFoxEntity spiritFoxEntity = (SpiritFoxEntity) ModEntities.SPIRIT_FOX.create(world);
        if (spiritFoxEntity == null) {
            return 0;
        } else {
            spiritFoxEntity.initialize(world, world.getLocalDifficulty(pos), SpawnReason.NATURAL, (EntityData)null, (NbtCompound)null);
            spiritFoxEntity.refreshPositionAndAngles(pos, 0.0F, 0.0F);
            world.spawnEntityAndPassengers(spiritFoxEntity);
            return 1;
        }
    }
}
