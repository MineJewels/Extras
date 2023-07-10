package org.minejewels.jewelsextras.listeners;

import net.abyssdev.abysslib.listener.AbyssListener;
import net.abyssdev.abysslib.placeholder.PlaceholderReplacer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.minejewels.jewelsextras.JewelsExtras;

public class PlayerJoin extends AbyssListener<JewelsExtras> {

    private final String spawnCommand;

    public PlayerJoin(final  JewelsExtras plugin) {
        super(plugin);

        this.spawnCommand = plugin.getSettingsConfig().getString("spawn-command");
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        final Player player = event.getPlayer();

        player.teleport(this.plugin.getConstants().getSpawn());

        final PlaceholderReplacer replacer = new PlaceholderReplacer()
                .addPlaceholder("%player%", player.getName());

        this.plugin.getMessageCache().sendMessage(player, "messages.welcome", replacer);
    }
}
