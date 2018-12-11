package me.ljnic.tomes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TomeOwner {
    private Map<String, PlayerTome> tomes;
    private UUID player;

    public TomeOwner(UUID player) {
        this.player = player;
        tomes = new HashMap<>();
    }

    public Map<String, PlayerTome> getTomes() {
        return tomes;
    }

    public UUID getPlayer() {
        return player;
    }

    public void grantTome(Tome tome, List<Integer> pages) {
        tomes.put(tome.getId(), new PlayerTome(tome, pages));
    }

    public boolean addPages(Tome tome, List<Integer> newPages) {
        if (tomes.containsKey(tome.getId()))  {
            tomes.get(tome.getId()).addPages(newPages);
            return true;
        }
        return false;
    }
}
