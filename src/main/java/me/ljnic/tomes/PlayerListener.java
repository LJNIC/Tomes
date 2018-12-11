package me.ljnic.tomes;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Optional;

public class PlayerListener {

    @Listener
    public void onRightClick(InteractItemEvent.Secondary event, @Root Player player) {
        ItemStackSnapshot item = event.getItemStack();
        Optional<String> command = item.get(TomeKeys.TOME_COMMAND);
        command.ifPresent(s -> Sponge.getCommandManager().process(player, s));
    }
}
