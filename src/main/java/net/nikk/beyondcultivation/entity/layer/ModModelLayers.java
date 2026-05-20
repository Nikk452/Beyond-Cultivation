package net.nikk.beyondcultivation.entity.layer;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;

public class ModModelLayers {
    public static final EntityModelLayer TIGER =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "tiger"), "main");
    public static final EntityModelLayer RED_PANDA =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "red_panda"), "main");
    public static final EntityModelLayer QILIN =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "qilin"), "main");

    public static final EntityModelLayer SPIRIT_FOX =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "spirit_fox"), "main");
    public static final EntityModelLayer BOAR =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "boar"), "main");
    public static final EntityModelLayer RAT =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "rat"), "main");
    public static final EntityModelLayer DRAGON =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "dragon"), "main");
    public static final EntityModelLayer HUANCAT =
            new EntityModelLayer(new Identifier(BCMod.MOD_ID, "huancat"), "main");


    //public static final EntityModelLayer MAGIC_PROJECTILE =
    //        new EntityModelLayer(new Identifier(BCMod.MOD_ID, "magic_projectile"), "main");
}
