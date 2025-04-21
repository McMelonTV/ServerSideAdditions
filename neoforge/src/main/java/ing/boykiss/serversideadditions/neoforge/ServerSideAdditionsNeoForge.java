package ing.boykiss.serversideadditions.neoforge;

import ing.boykiss.serversideadditions.ServerSideAdditions;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = ServerSideAdditions.MOD_ID, dist = Dist.DEDICATED_SERVER)
public final class ServerSideAdditionsNeoForge {
    public ServerSideAdditionsNeoForge() {
        // Run our common setup.
        ServerSideAdditions.init();
    }
}
