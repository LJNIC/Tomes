package me.ljnic.tomes;

import org.spongepowered.api.entity.living.player.Player;

import java.util.*;

public class TomeOwnerManager {
    private Map<UUID, TomeOwner> tomeOwners;
    private static TomeOwnerManager instance = new TomeOwnerManager();

    private TomeOwnerManager() {
        tomeOwners = new HashMap<>();
    }

    public static TomeOwnerManager getInstance() {
        return instance;
    }

    public TomeOwner createTomeOwner(Player player) {
        TomeOwner newOwner = new TomeOwner(player.getUniqueId());
        tomeOwners.put(player.getUniqueId(), newOwner);
        return newOwner;
    }

    public TomeOwner getOrCreate(Player player) {
        if (tomeOwners.containsKey(player.getUniqueId())) {
            return tomeOwners.get(player.getUniqueId());
        } else {
            return createTomeOwner(player);
        }
    }

    public boolean grantTome(Player player, String tomeId, List<Integer> pageIds) {
        Optional<Tome> tome = Tomes.getConfig().getTome(tomeId);

        if (tome.isPresent()) {
            getOrCreate(player).grantTome(tome.get(), pageIds);
            return true;
        } else {
            return false;
        }
    }
}
