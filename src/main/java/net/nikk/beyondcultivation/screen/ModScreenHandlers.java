package net.nikk.beyondcultivation.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.nikk.beyondcultivation.BCMod;
import net.nikk.beyondcultivation.screen.handler.ApertureBlockScreenHandler;
import net.nikk.beyondcultivation.screen.handler.ApertureScreenHandler;

public class ModScreenHandlers {
    public static ScreenHandlerType<ApertureScreenHandler> APERTURE_SCREEN_HANDLER =
            new ScreenHandlerType<ApertureScreenHandler>(ApertureScreenHandler::new, FeatureFlags.VANILLA_FEATURES);

    public static ScreenHandlerType<ApertureBlockScreenHandler> APERTURE_BLOCK_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(ApertureBlockScreenHandler::new);

    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(BCMod.MOD_ID, "aperture_screen"),
                APERTURE_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(BCMod.MOD_ID, "aperture_block_screen"),
                APERTURE_BLOCK_SCREEN_HANDLER);
    }
}
