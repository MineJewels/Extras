package org.minejewels.jewelsextras.listeners;

import net.abyssdev.abysschat.event.AbyssPlayerChatEvent;
import net.abyssdev.abysslib.listener.AbyssListener;
import net.abyssdev.abysslib.utils.PlayerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.eclipse.collections.api.factory.Lists;
import org.minejewels.jewelsextras.JewelsExtras;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChatListener extends AbyssListener<JewelsExtras> {

    public static final List<Player> PLAYERS = Lists.mutable.empty();

    public ChatListener(final JewelsExtras plugin) {
        super(plugin);
    }

    @EventHandler
    public void onChat(final AbyssPlayerChatEvent event) {

        if (!this.plugin.isGgwaveActive()) return;

        if (!event.getMessage().toLowerCase().contains("gg")) {
            return;
        }

        final Player player = event.getPlayer();

        if (!ChatListener.PLAYERS.contains(player)) {
            ChatListener.PLAYERS.add(player);
            this.plugin.getMessageCache().sendMessage(player, "messages.joined-gg-wave");
            PlayerUtils.dispatchCommands(player, this.plugin.getConstants().getEntryCommands());
        }

        event.setMessage(this.plugin.getConstants().getGGs().get(ThreadLocalRandom.current().nextInt(this.plugin.getConstants().getGGs().size())));
    }
}
