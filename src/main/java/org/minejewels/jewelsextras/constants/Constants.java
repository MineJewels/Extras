package org.minejewels.jewelsextras.constants;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.minejewels.jewelsextras.JewelsExtras;

import java.util.List;

public class Constants {

    private final JewelsExtras plugin;

    public Constants(final JewelsExtras plugin) {
        this.plugin = plugin;
    }

    public Location getSpawn() {
        return(new Location(
                Bukkit.getWorld(this.plugin.getSettingsConfig().getString("spawn-location.world")),
                this.plugin.getSettingsConfig().getInt("spawn-location.x") + 0.5,
                this.plugin.getSettingsConfig().getInt("spawn-location.y"),
                this.plugin.getSettingsConfig().getInt("spawn-location.z") + 0.5,
                this.plugin.getSettingsConfig().getInt("spawn-location.yaw"),
                this.plugin.getSettingsConfig().getInt("spawn-location.pitch")
        ));
    }

    public long getRestartTime() {
        return this.plugin.getSettingsConfig().getLong("duration");
    }

    public long getGGWaveTime() {
        return this.plugin.getSettingsConfig().getLong("ggwave-time");
    }

    public List<String> getGGs() {
        return this.plugin.getSettingsConfig().getColoredStringList("gg-list");
    }

    public List<String> getEntryCommands() {
        return this.plugin.getSettingsConfig().getStringList("entry-commands");
    }

    public List<String> getPlayerCommands() {
        return this.plugin.getSettingsConfig().getStringList("player-commands");
    }

    public List<String> getSystemCommands() {
        return this.plugin.getSettingsConfig().getStringList("system-commands");
    }
}
