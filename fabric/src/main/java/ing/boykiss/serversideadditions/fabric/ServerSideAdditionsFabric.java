package ing.boykiss.serversideadditions.fabric;

import ing.boykiss.serversideadditions.ServerSideAdditions;
import net.fabricmc.api.ModInitializer;

public final class ServerSideAdditionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        ServerSideAdditions.init();
    }
}
