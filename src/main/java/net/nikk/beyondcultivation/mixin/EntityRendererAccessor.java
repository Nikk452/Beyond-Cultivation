package net.nikk.beyondcultivation.mixin;

import com.mojang.datafixers.DataFixer;
import net.minecraft.client.render.entity.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EntityRenderer.class)
public interface EntityRendererAccessor {
    @Accessor(value = "shadowRadius")
    float getShadowRadius();
}
