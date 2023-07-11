package org.minejewels.jewelsextras;

import lombok.Getter;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.text.MessageCache;
import org.minejewels.jewelsextras.autorestart.AutoRestart;
import org.minejewels.jewelsextras.commands.NextRestartCommand;
import org.minejewels.jewelsextras.commands.SpawnCommand;
import org.minejewels.jewelsextras.constants.Constants;
import org.minejewels.jewelsextras.listeners.PlayerJoin;
import org.minejewels.jewelsextras.task.RestartTask;

@Getter
public final class JewelsExtras extends AbyssPlugin {

    private static JewelsExtras api;

    private final AbyssConfig langConfig = this.getAbyssConfig("lang");
    private final AbyssConfig settingsConfig = this.getAbyssConfig("settings");

    private final MessageCache messageCache = new MessageCache(langConfig);

    private final Constants constants = new Constants(this);

    private final AutoRestart autoRestart = new AutoRestart(this.settingsConfig.getLong("duration")*3600);

    @Override
    public void onEnable() {
        JewelsExtras.api = this;

        this.loadMessages(this.messageCache, langConfig);

        this.loadListeners();
        this.loadCommands();

        new RestartTask(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadCommands() {
        new SpawnCommand(this).register();
        new NextRestartCommand(this).register();
    }

    private void loadListeners() {
        new PlayerJoin(this);
    }

    public static JewelsExtras get() {
        return JewelsExtras.api;
    }
}
