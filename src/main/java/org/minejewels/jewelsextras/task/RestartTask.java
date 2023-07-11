package org.minejewels.jewelsextras.task;

import net.abyssdev.abysslib.runnable.AbyssTask;
import org.bukkit.Bukkit;
import org.minejewels.jewelsextras.JewelsExtras;

public class RestartTask extends AbyssTask<JewelsExtras> {

    public RestartTask(final JewelsExtras plugin) {
        super(plugin);

        this.runTaskLater(plugin, plugin.getConstants().getRestartTime() * 72000);
    }

    @Override
    public void run() {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
    }
}
