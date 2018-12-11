package me.ljnic.tomes.command;

import com.atherys.core.command.ParameterizedCommand;
import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Description;
import com.atherys.core.command.annotation.Permission;
import com.google.common.collect.ImmutableMap;
import me.ljnic.tomes.Tomes;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextTemplate;
import static org.spongepowered.api.text.TextTemplate.*;
import org.spongepowered.api.text.format.TextColors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Aliases("give")
@Description("Gives a tome to a player.")
@Permission("tomes.give")
public class GiveTomeCommand implements ParameterizedCommand {
    private static TextTemplate success = TextTemplate.of(
            "Granted player ", TextColors.GOLD, arg("player"), TextColors.NONE, " the tome ", arg("tome"), "."
    );

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[] {
                GenericArguments.player(Text.of("player")),
                GenericArguments.string(Text.of("tome")),
                GenericArguments.optional(GenericArguments.remainingJoinedStrings(Text.of("pages")))
        };
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Optional<Player> player = args.getOne("player");
        Optional<String> tomeId = args.getOne("tome");
        Optional<String> pages = args.getOne("pages");

        List<Integer> pageIds = Collections.emptyList();

        if (pages.isPresent()) {
            Optional<List<Integer>> parsed = parse(pages.get());
            if (parsed.isPresent()) {
                pageIds = parsed.get();
            } else {
                src.sendMessage(Text.of("Please enter integers for the page numbers."));
                return CommandResult.empty();
            }
        }

        if (player.isPresent() && tomeId.isPresent()) {
            if (Tomes.getTomeOwnerManager().grantTome(player.get(), tomeId.get(), pageIds)) {
                src.sendMessage(success.apply(ImmutableMap.of(
                        "player", Text.of(player.get().getName()),
                        "tome", Text.of(tomeId.get())
                    )).build()
                );
                return CommandResult.success();
            }
            return CommandResult.empty();
        }
        return CommandResult.empty();
    }

    private static Optional<List<Integer>> parse(String pages) {
        String[] split = pages.split(" ");
        List<Integer> pageIds = new ArrayList<>();
        for (String page : split) {
            try {
                pageIds.add(Integer.parseInt(page));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }

        return Optional.of(pageIds);
    }
}
