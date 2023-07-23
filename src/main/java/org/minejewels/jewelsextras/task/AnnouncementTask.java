package org.minejewels.jewelsextras.task;

import net.abyssdev.abysslib.runnable.AbyssTask;
import net.abyssdev.abysslib.text.Color;
import org.bukkit.Bukkit;
import org.minejewels.jewelsextras.JewelsExtras;

import java.util.concurrent.atomic.AtomicInteger;

public class AnnouncementTask extends AbyssTask<JewelsExtras> {

    private final AtomicInteger count;

    public AnnouncementTask(final JewelsExtras plugin) {
        super(plugin);

        this.count = new AtomicInteger(0);
        this.runTaskTimer(plugin, 0L, plugin.getConstants().getAnnouncementTime() * 1200L);
    }

    @Override
    public void run() {

        final int size = plugin.getAnnounceService().getService().size();

        if (size <= count.get()) {
            count.set(0);
        }

        for (String string : this.plugin.getAnnounceService().get(count.getAndAdd(1))) {
            Bukkit.broadcastMessage(Color.parse(string));
        }
    }
}
