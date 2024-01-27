package fr.plaglefleau.univers;

import fr.plaglefleau.univers.screen.ModScreenHandlers;
import fr.plaglefleau.univers.screen.ScrollWriterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class UniversClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.SCROLL_WRITER_SCREEN_HANDLER, ScrollWriterScreen::new);
    }
}
