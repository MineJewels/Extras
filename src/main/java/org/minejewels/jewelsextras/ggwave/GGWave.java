package org.minejewels.jewelsextras.ggwave;

import lombok.Data;
import net.abyssdev.abysslib.placeholder.PlaceholderReplacer;
import net.abyssdev.abysslib.scheduler.AbyssScheduler;
import net.abyssdev.abysslib.text.message.Message;
import net.abyssdev.abysslib.utils.Utils;
import org.bukkit.entity.Player;
import org.minejewels.jewelsextras.JewelsExtras;
import org.minejewels.jewelsextras.listeners.ChatListener;

@Data
public class GGWave {

    private final Player player;
    private final int cost;
    private final StringBuilder packagePurchased;

    public void activate(final JewelsExtras plugin) {

        final PlaceholderReplacer replacer = new PlaceholderReplacer()
                .addPlaceholder("%player%", this.player.getName())
                .addPlaceholder("%cost%", Utils.format(this.cost))
                .addPlaceholder("%package%", this.packagePurchased.toString());

        final Message message = plugin.getMessageCache().getMessage("messages.ggwave-started");

        message.broadcast(replacer);

        if (!plugin.isGgwaveActive()) {
            plugin.setGGWave(true);

            AbyssScheduler.sync().runLater(() -> {
                plugin.setGGWave(false);
                plugin.getMessageCache().getMessage("messages.ggwave-ended").broadcast();
                ChatListener.PLAYERS.clear();
            }, plugin.getConstants().getGGWaveTime() * 20L);
        }
    }
}
