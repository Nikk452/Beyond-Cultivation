package net.nikk.beyondcultivation.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.nikk.beyondcultivation.BCMod;

import java.util.UUID;

public class AttributeData {
    public static void addHealth(LivingEntity entity, int amount, String name, String uuid){
        EntityAttributeModifier STAT_HEALTH_BOOST = new EntityAttributeModifier(UUID.fromString(uuid),
                BCMod.MOD_ID+":" +name, amount, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeInstance health = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if(health!=null && !health.hasModifier(STAT_HEALTH_BOOST)){
            health.addPersistentModifier(STAT_HEALTH_BOOST);
            entity.setHealth(entity.getMaxHealth());
        }
    }
    public static void addAttribute(LivingEntity entity, double amount, String name, String uuid, EntityAttribute attribute){
        EntityAttributeModifier STAT_ATTR_BOOST = new EntityAttributeModifier(UUID.fromString(uuid),
                BCMod.MOD_ID+":" +name, amount, EntityAttributeModifier.Operation.ADDITION);
        EntityAttributeInstance attr = entity.getAttributeInstance(attribute);
        if(attr!=null && !attr.hasModifier(STAT_ATTR_BOOST)){
            attr.addPersistentModifier(STAT_ATTR_BOOST);
        }
    }

}
