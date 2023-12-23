package net.nikk.beyondcultivation.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.spawner.Spawner;
import net.nikk.beyondcultivation.world.spawner.SpiritFoxSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @ModifyArg(method = "createWorlds(Lnet/minecraft/server/WorldGenerationProgressListener;)V", at = @At(value = "INVOKE", target = "net/minecraft/server/world/ServerWorld.<init> (Lnet/minecraft/server/MinecraftServer;Ljava/util/concurrent/Executor;Lnet/minecraft/world/level/storage/LevelStorage$Session;Lnet/minecraft/world/level/ServerWorldProperties;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/world/dimension/DimensionOptions;Lnet/minecraft/server/WorldGenerationProgressListener;ZJLjava/util/List;ZLnet/minecraft/util/math/random/RandomSequencesState;)V"), index = 9)
    private List<Spawner> injected(List<Spawner> spawners) {
        ArrayList<Spawner> list = new ArrayList<>(spawners);
        list.add(new SpiritFoxSpawner());
        return list;
    }
}
