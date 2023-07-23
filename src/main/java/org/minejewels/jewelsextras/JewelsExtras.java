package org.minejewels.jewelsextras;

import lombok.Getter;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.text.MessageCache;
import org.minejewels.jewelsextras.announcement.AnnounceService;
import org.minejewels.jewelsextras.autorestart.AutoRestart;
import org.minejewels.jewelsextras.commands.HubCommand;
import org.minejewels.jewelsextras.commands.NextRestartCommand;
import org.minejewels.jewelsextras.commands.SpawnCommand;
import org.minejewels.jewelsextras.commands.StartCommand;
import org.minejewels.jewelsextras.commands.ggwave.GGWaveCommand;
import org.minejewels.jewelsextras.constants.Constants;
import org.minejewels.jewelsextras.listeners.ChatListener;
import org.minejewels.jewelsextras.listeners.PlayerJoin;
import org.minejewels.jewelsextras.task.AnnouncementTask;
import org.minejewels.jewelsextras.task.RestartTask;
import org.minejewels.jewelsextras.utils.BungeeUtils;

@Getter
public final class JewelsExtras extends AbyssPlugin {

    private static JewelsExtras api;

    private final AbyssConfig langConfig = this.getAbyssConfig("lang");
    private final AbyssConfig settingsConfig = this.getAbyssConfig("settings");
    private final AbyssConfig announcementsConfig = this.getAbyssConfig("announcements");

    private final MessageCache messageCache = new MessageCache(langConfig);

    private final Constants constants = new Constants(this);

    private final AutoRestart autoRestart = new AutoRestart(this.settingsConfig.getLong("duration")*3600);

    private final AnnounceService announceService = new AnnounceService();

    private final BungeeUtils bungeeUtils = new BungeeUtils(this);

    private boolean ggwaveActive;

    @Override
    public void onEnable() {
        JewelsExtras.api = this;

        this.loadMessages(this.messageCache, langConfig);

        this.loadListeners();
        this.loadCommands();
        this.loadAnnouncements();

        new RestartTask(this);
        new AnnouncementTask(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadCommands() {
        new SpawnCommand(this).register();
        new NextRestartCommand(this).register();
        new GGWaveCommand(this).register();
        new StartCommand(this).register();
        new HubCommand(this).register();
    }

    private void loadListeners() {
        new PlayerJoin(this);
        new ChatListener(this);
    }

    private void loadAnnouncements() {
        for (final String announcements : this.getAnnouncementsConfig().getSectionKeys("announcements")) {
            this.announceService.add(this.getAnnouncementsConfig().getStringList("announcements." + announcements));
        }
    }

    public void setGGWave(final boolean result) {
        this.ggwaveActive = result;
    }

    public static JewelsExtras get() {
        return JewelsExtras.api;
    }
}
