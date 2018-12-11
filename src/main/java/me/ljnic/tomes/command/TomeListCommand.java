package me.ljnic.tomes.command;

import com.atherys.core.command.annotation.Aliases;
import me.ljnic.tomes.PlayerTome;
import me.ljnic.tomes.Tomes;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.Map;

@Aliases("list")
public class TomeListCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (!(src instanceof Player)) return CommandResult.empty();

        Text.Builder tomeList = Text.builder().append(Text.of("Your tomes: "));
        int i = 0;
        Map<String, PlayerTome> tomes = Tomes.getTomeOwnerManager().getOrCreate((Player) src).getTomes();
        for (Map.Entry<String, PlayerTome> tome : tomes.entrySet()) {
            tomeList.append(
                    Text.builder(
                        Text.of(TextColors.GOLD, TextStyles.BOLD), tome.getKey())
                            .onClick(TextActions.executeCallback(commandSource -> {
                                tome.getValue().createView().show((Player) commandSource);
                            })).build());
            if (i < tomes.size() - 1) {
                tomeList.append(Text.of(", "));
            } else {
                tomeList.append(Text.of("."));
            }
        }

        src.sendMessage(tomeList.build());
        return CommandResult.success();
    }
}
