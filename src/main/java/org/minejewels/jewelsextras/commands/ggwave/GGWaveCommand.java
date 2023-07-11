package org.minejewels.jewelsextras.commands.ggwave;

import net.abyssdev.abysslib.command.AbyssCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelsextras.JewelsExtras;
import org.minejewels.jewelsextras.commands.ggwave.sub.GGWaveStartCommand;

public class GGWaveCommand extends AbyssCommand<JewelsExtras, CommandSender> {

    public GGWaveCommand(final JewelsExtras plugin) {
        super(plugin, "ggwave", CommandSender.class);

        this.setAliases(Lists.mutable.of("ggwave"));

        this.register(new GGWaveStartCommand(plugin));
    }

    @Override
    public void execute(CommandContext<CommandSender> context) {
        final CommandSender sender = context.getSender();

        if (!sender.hasPermission("ggwave.admin")) {
            return;
        }

        this.plugin.getMessageCache().sendMessage(sender, "messages.ggwave-help");
    }
}
