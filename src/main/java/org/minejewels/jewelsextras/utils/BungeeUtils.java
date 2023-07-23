package org.minejewels.jewelsextras.utils;

import org.bukkit.entity.Player;
import org.minejewels.jewelsextras.JewelsExtras;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class BungeeUtils {

    private final JewelsExtras plugin;
    public BungeeUtils(final JewelsExtras plugin) {
        this.plugin = plugin;

        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
    }

    public void sendPlayerToServer(final Player player, final String server) {
        try {
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            final DataOutputStream output = new DataOutputStream(stream);

            output.writeUTF("Connect");
            output.writeUTF(server);

            player.sendPluginMessage(this.plugin, "BungeeCord", stream.toByteArray());
            stream.close();
            output.close();
        }
        catch (Exception e) {
            this.plugin.getMessageCache().sendMessage(player, "messages.sending-error");
        }
    }
}
