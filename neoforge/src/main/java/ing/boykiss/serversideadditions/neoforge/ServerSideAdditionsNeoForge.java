package ing.boykiss.serversideadditions.neoforge;

import ing.boykiss.serversideadditions.ServerSideAdditions;
import net.neoforged.fml.common.Mod;

@Mod(ServerSideAdditions.MOD_ID)
public final class ServerSideAdditionsNeoForge {
    public ServerSideAdditionsNeoForge() {
        // Run our common setup.
        ServerSideAdditions.init();
    }
}
