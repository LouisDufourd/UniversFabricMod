package fr.plaglefleau.univers.screen;

import fr.plaglefleau.univers.Univers;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static final ScreenHandlerType<ScrollWriterScreenHandler> SCROLL_WRITER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Univers.MOD_ID, "scroll_writer"),
                    new ExtendedScreenHandlerType<>(ScrollWriterScreenHandler::new));


    public static void registerScreenHandlers() {
        Univers.LOGGER.info("Registering Screen Handlers for %s".formatted(Univers.MOD_ID));
    }
}
