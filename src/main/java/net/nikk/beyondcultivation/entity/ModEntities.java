package net.nikk.beyondcultivation.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.entity.custom.*;
import net.nikk.beyondcultivation.entity.spells.SpellEntity;

public class ModEntities {
    public static final EntityType<TigerEntity> TIGER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "tiger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TigerEntity::new)
                    .dimensions(EntityDimensions.fixed(3.0f, 2.0f)).build());
    public static final EntityType<RedPandaEntity> RED_PANDA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "red_panda"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedPandaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.5f)).build());
    public static final EntityType<QilinEntity> QILIN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "qilin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, QilinEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.2f)).build());
    public static final EntityType<SpiritFoxEntity> SPIRIT_FOX = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "spirit_fox"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SpiritFoxEntity::new)
                    .dimensions(EntityDimensions.changing(1.5f, 1.2f)).build());
    public static final EntityType<BoarEntity> BOAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "boar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BoarEntity::new)
                    .dimensions(EntityDimensions.fixed(1.1f, 0.8f)).build());
    public static final EntityType<HuancatEntity> HUANCAT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "huancat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HuancatEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 0.6f)).build());
    public static final EntityType<DragonEntity> DRAGON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonEntity::new)
                    .dimensions(EntityDimensions.fixed(10.1f, 5.8f)).build());


    public static final EntityType<SpellEntity> SPELL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BCMod.MOD_ID, "spell"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, (EntityType.EntityFactory<SpellEntity>)SpellEntity::new)
                    .dimensions(EntityDimensions.changing(1.0f,1.0f)).build());


    public static void registerModEntities() {
        BCMod.LOGGER.info("Registering Mod Entities for " + BCMod.MOD_ID);
    }
}
