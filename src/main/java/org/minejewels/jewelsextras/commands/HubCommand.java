package org.minejewels.jewelsextras.commands;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelsextras.JewelsExtras;

public class HubCommand extends AbyssCommand<JewelsExtras, Player> {

    public HubCommand(final JewelsExtras plugin) {
        super(plugin, "lobby", Player.class);

        this.setAliases(Lists.mutable.of("lobby", "hub"));
    }

    @Override
    public void execute(CommandContext<Player> context) {

        final Player player = context.getSender();

        this.plugin.getBungeeUtils().sendPlayerToServer(player, "hub");
    }
}
