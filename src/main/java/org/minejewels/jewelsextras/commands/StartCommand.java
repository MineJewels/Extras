package org.minejewels.jewelsextras.commands;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import net.abyssdev.abysslib.permission.PermissionUtils;
import net.abyssdev.abysslib.placeholder.PlaceholderReplacer;
import net.abyssdev.abysslib.utils.PlayerUtils;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelsextras.JewelsExtras;

public class StartCommand extends AbyssCommand<JewelsExtras, Player> {

    public StartCommand(final JewelsExtras plugin) {
        super(plugin, "start", Player.class);

        this.setAliases(Lists.mutable.of("start", "begin"));
    }

    @Override
    public void execute(CommandContext<Player> context) {

        final Player player = context.getSender();

        if (player.hasPermission("jewelsextra.start")) {
            this.plugin.getMessageCache().sendMessage(player, "messages.already-started");
            return;
        }

        this.plugin.getMessageCache().sendMessage(player, "messages.started");
        PlayerUtils.dispatchCommands(player, this.plugin.getConstants().getSystemCommands());

        for (final String command : this.plugin.getConstants().getPlayerCommands()) {
            player.performCommand(command);
        }

        PermissionUtils.get().setPermission(player, "jewelsextra.start");
    }
}
