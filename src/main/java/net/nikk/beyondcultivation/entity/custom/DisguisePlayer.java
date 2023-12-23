package net.nikk.beyondcultivation.entity.custom;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DisguisePlayer extends AbstractClientPlayerEntity {
    private String name;
    public DisguisePlayer(ClientWorld world, GameProfile profile) {
        super(world, profile);
        name = profile.getName();
    }

    @Override
    public boolean isSpectator() {
        return false;
    }

    @Override
    public boolean isCreative() {
        return false;
    }

    @Override
    public Text getName() {
        return Text.literal(new StringBuilder(this.name).reverse().toString());
    }

    public void setName(String s){
        this.name = s;
    }
}
