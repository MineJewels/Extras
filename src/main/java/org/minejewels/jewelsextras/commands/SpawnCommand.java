package org.minejewels.jewelsextras.commands;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelsextras.JewelsExtras;

public class SpawnCommand extends AbyssCommand<JewelsExtras, Player> {

    public SpawnCommand(final JewelsExtras plugin) {
        super(plugin, "spawn", Player.class);

        this.setAliases(Lists.mutable.of("spawn", "hub"));
    }

    @Override
    public void execute(CommandContext<Player> context) {

        final Player player = context.getSender();

        player.teleport(this.plugin.getConstants().getSpawn());

        this.plugin.getMessageCache().sendMessage(player, "messages.spawn");
    }
}
