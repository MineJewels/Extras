package org.minejewels.jewelsextras.commands.ggwave.sub;

import net.abyssdev.abysslib.command.AbyssSubCommand;
import net.abyssdev.abysslib.command.context.CommandContext;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.set.ImmutableSet;
import org.minejewels.jewelsextras.JewelsExtras;
import org.minejewels.jewelsextras.ggwave.GGWave;

public class GGWaveStartCommand extends AbyssSubCommand<JewelsExtras> {

    public GGWaveStartCommand(final JewelsExtras plugin) {
        super(plugin, 2, Sets.immutable.of("start", "run"));
    }

    @Override
    public void execute(CommandContext<?> context) {
        final CommandSender sender = context.getSender();

        if (!context.isPlayer(0) || !context.isInt(1)) {
            this.plugin.getMessageCache().sendMessage(sender, "messages.ggwave-help");
            return;
        }

        final StringBuilder builder = new StringBuilder();

        for (int i = 2; i < context.getArguments().length; i++) {
            if (!builder.toString().isEmpty()) {
                builder.append(" ");
            }

            builder.append(context.getArguments()[i]);
        }

        final Player target = context.asPlayer(0);

        final GGWave ggWave = new GGWave(target, context.asInt(1), builder);

        ggWave.activate(this.plugin);
    }
}
