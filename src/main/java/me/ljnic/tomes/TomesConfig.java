package me.ljnic.tomes;

import com.atherys.core.utils.PluginConfig;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ConfigSerializable
public class TomesConfig extends PluginConfig {

    protected TomesConfig(String directory, String filename) throws IOException {
        super(directory, filename);
    }

    @Setting("tomes")
    private Map<String, Tome> tomes = generateDefaults();

    private Map<String,Tome> generateDefaults() {
        tomes = new HashMap<>();
        tomes.put("a-tome", new Tome("a-tome", new Page("&cThis is a page. You can read it. This text is even red.")));
        return tomes;
    }

    public Map<String, Tome> getTomes() {
        return tomes;
    }

    public Optional<Tome> getTome(String tomeId) {
        return Optional.ofNullable(tomes.get(tomeId));
    }
}
