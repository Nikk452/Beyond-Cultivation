package net.nikk.beyondcultivation.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> PEACH_TREES = TagKey.of(RegistryKeys.ITEM, new Identifier("beyondcultivation","peach_trees"));
}
