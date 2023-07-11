package org.minejewels.jewelsextras.constants;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.minejewels.jewelsextras.JewelsExtras;

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
}
