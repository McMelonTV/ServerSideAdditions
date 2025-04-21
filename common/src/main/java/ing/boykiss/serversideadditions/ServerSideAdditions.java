package ing.boykiss.serversideadditions;

import dev.architectury.event.events.common.InteractionEvent;
import ing.boykiss.serversideadditions.config.Config;
import ing.boykiss.serversideadditions.mobpickup.event.MobItemPlaceEvent;
import ing.boykiss.serversideadditions.mobpickup.event.MobPickupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ServerSideAdditions {
    public static final String MOD_ID = "serversideadditions";
    public static final Logger LOGGER = LoggerFactory.getLogger(ServerSideAdditions.class);

    public static void init() {
        Config.init();

        InteractionEvent.INTERACT_ENTITY.register(new MobPickupEvent());
        InteractionEvent.RIGHT_CLICK_BLOCK.register(new MobItemPlaceEvent());
    }
}
