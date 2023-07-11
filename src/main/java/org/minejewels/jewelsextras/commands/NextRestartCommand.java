package org.minejewels.jewelsextras.commands;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import net.abyssdev.abysslib.placeholder.PlaceholderReplacer;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelsextras.JewelsExtras;

public class NextRestartCommand extends AbyssCommand<JewelsExtras, Player> {

    public NextRestartCommand(final JewelsExtras plugin) {
        super(plugin, "nextrestart", Player.class);

        this.setAliases(Lists.mutable.of("nextrestart", "restartcountdown"));
    }

    @Override
    public void execute(CommandContext<Player> context) {

        final Player player = context.getSender();

        final PlaceholderReplacer replacer = new PlaceholderReplacer()
                .addPlaceholder("%time%", Utils.getTimeFormat(this.plugin.getAutoRestart().getTimeRemainingInSeconds() * 1000));

        this.plugin.getMessageCache().sendMessage(player, "messages.next-restart", replacer);
    }
}
