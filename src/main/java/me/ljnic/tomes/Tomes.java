package me.ljnic.tomes;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import static me.ljnic.tomes.Tomes.*;

@Plugin(id = ID, version = VERSION, name = NAME, description = DESCRIPTION)
public class Tomes {
    public static final String ID = "atheryscore";
    public static final String NAME = "A'therys Core";
    public static final String DESCRIPTION = "The core utilities used on the A'therys Horizons server.";
    public static final String VERSION = "1.3.0";

    private static Tomes instance;

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Tomes loaded.");
    }
}
