package net.nikk.beyondcultivation.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;

public class ModItemGroup {
    public static final ItemGroup JIANGHU_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BCMod.MOD_ID, "jianghu_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.jianghu_group"))
                    .icon(() -> new ItemStack(ModItems.MARTIAL_MANUAL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MARTIAL_MANUAL);
                        entries.add(ModItems.TIGER_SPAWN_EGG);
                        entries.add(ModItems.RED_PANDA_SPAWN_EGG);
                        entries.add(ModItems.TIGER_SKIN);
                        entries.add(ModItems.TIGER_MEAT);
                        entries.add(ModItems.COOKED_TIGER);
                        entries.add(ModItems.PHOENIX_FEATHER);
                        entries.add(ModItems.PHEASANT_FEATHER);
                        entries.add(ModItems.PEACOCK_FEATHER);
                        entries.add(ModItems.QILIN_ANTLER);
                        entries.add(ModItems.RAT_TAIL);
                        entries.add(ModItems.BOAR_HORN);
                        entries.add(ModItems.SNAKE_VENOM);
                        entries.add(ModItems.TEST_POISON);
                    }).build());

    public static void registerItemGroups() {
        BCMod.LOGGER.info("registering item groups");
    }
}
