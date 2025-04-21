package ing.boykiss.serversideadditions.config;

import com.google.gson.Gson;
import dev.architectury.platform.Platform;
import ing.boykiss.serversideadditions.ServerSideAdditions;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Getter
@Setter
public class Config {
    public static Config INSTANCE;
    private static final Path CONFIG_PATH = Platform.getConfigFolder().resolve(ServerSideAdditions.MOD_ID + ".json");
    private static final Gson GSON = new Gson();

    private MobPickup mobPickup = new MobPickup();

    private Config() {
    }

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = load();
            INSTANCE.save();
        }
    }

//    public static void reload() {
//        INSTANCE = load();
//    }

    public static Config load() {
        if (CONFIG_PATH.toFile().exists()) {
            try {
                String json = Files.readString(CONFIG_PATH);
                Config config = GSON.fromJson(json, Config.class);
                if (config == null) {
                    ServerSideAdditions.LOGGER.error("Failed to load config file, creating a new one.");
                    return createDefaultConfig();
                }
                return config;
            } catch (Exception e) {
                ServerSideAdditions.LOGGER.error("Failed to load config file: " + e.getMessage());
                return createDefaultConfig();
            }
        } else {
            return createDefaultConfig();
        }
    }

    public void save() {
        try {
            String json = GSON.toJson(this);
            Files.writeString(CONFIG_PATH, json);
        } catch (Exception e) {
            ServerSideAdditions.LOGGER.error("Failed to save config file: " + e.getMessage());
        }
    }

    private static Config createDefaultConfig() {
        Config config = new Config();
        config.save();
        return config;
    }

    @Getter
    @Setter
    public static class MobPickup {
        private boolean enabled = true;
        private boolean dropItemOnFullInventory = true;
        private boolean allVillagersAsPlushies = false;
        private List<String> allowedEntityTypes = List.of("minecraft:villager");
        //TODO: add a setting for disabling anvil renaming
    }
}
