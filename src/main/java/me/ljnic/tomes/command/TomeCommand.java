package me.ljnic.tomes.command;

import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Children;
import com.atherys.core.command.annotation.Description;
import com.atherys.core.command.annotation.Permission;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

@Aliases("tome")
@Children({
        GiveTomeCommand.class,
        TomeListCommand.class
})
@Permission("tome")
@Description("Base tome command.")
public class TomeCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        return CommandResult.empty();
    }
}
