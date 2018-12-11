package me.ljnic.tomes;

import com.atherys.core.command.CommandService;
import com.google.inject.Inject;
import me.ljnic.tomes.command.TomeCommand;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import java.io.IOException;

import static me.ljnic.tomes.Tomes.*;

@Plugin(id = ID, version = VERSION, name = NAME, description = DESCRIPTION)
public class Tomes {
    public static final String ID = "tomes";
    public static final String NAME = "Tomes";
    public static final String DESCRIPTION = "The core utilities used on the A'therys Horizons server.";
    public static final String VERSION = "0.0.1";

    private static Tomes instance;
    private static TomesConfig config;
    private static TomeOwnerManager tomeOwnerManager;

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        instance = this;
        tomeOwnerManager = TomeOwnerManager.getInstance();

        try {
            config = new TomesConfig("config/" + ID, "config.conf");
            config.init();
        } catch (IOException e) {
            logger.error("Error creating config!");
            e.printStackTrace();
            return;
        }

        try {
            CommandService.getInstance().register(new TomeCommand(), this);
        } catch (CommandService.AnnotatedCommandException e) {
            e.printStackTrace();
        }

        printLogo();
        logger.info("       Loaded successfully!");

        logger.info(config.getTome("a-tome").get().getPages().get(0).getContent().toString());
    }

    private void printLogo() {
        logger.info("  ________   ,__ __    ___      ");
        logger.info(" (_) | /\\_\\//|  |  |  / (_)  () ");
        logger.info("     ||    | |  |  |  \\__    /\\ ");
        logger.info("   _ ||    | |  |  |  /     /  \\");
        logger.info("  (_/  \\__/  |  |  |_/\\___//(__/");
    }

    public static TomeOwnerManager getTomeOwnerManager() {
        return tomeOwnerManager;
    }

    public static TomesConfig getConfig() {
        return config;
    }

    public static Logger getLogger() {
        return instance.logger;
    }
}
