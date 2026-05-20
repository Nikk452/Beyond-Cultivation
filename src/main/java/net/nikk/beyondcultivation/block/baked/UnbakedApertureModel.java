package net.nikk.beyondcultivation.block.baked;

import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class UnbakedApertureModel implements UnbakedModel {
    private final UnbakedModel unbakedModel;
    public UnbakedApertureModel(UnbakedModel base){
        this.unbakedModel = base;
    }
    @Override
    public Collection<Identifier> getModelDependencies() {
        return unbakedModel.getModelDependencies();
    }

    @Override
    public void setParents(Function<Identifier, UnbakedModel> modelLoader) {
        unbakedModel.setParents(modelLoader);
    }

    @Override
    public @Nullable BakedModel bake(Baker baker, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {
        return new BakedApertureModel(unbakedModel.bake(baker,textureGetter, rotationContainer, modelId));
    }
}
