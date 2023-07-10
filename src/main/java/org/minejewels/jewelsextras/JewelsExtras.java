package org.minejewels.jewelsextras;

import lombok.Getter;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.text.MessageCache;
import org.minejewels.jewelsextras.commands.SpawnCommand;
import org.minejewels.jewelsextras.constants.Constants;
import org.minejewels.jewelsextras.listeners.PlayerJoin;

@Getter
public final class JewelsExtras extends AbyssPlugin {

    private static JewelsExtras api;

    private final AbyssConfig langConfig = this.getAbyssConfig("lang");
    private final AbyssConfig settingsConfig = this.getAbyssConfig("settings");

    private final MessageCache messageCache = new MessageCache(langConfig);

    private final Constants constants = new Constants(this);

    @Override
    public void onEnable() {
        JewelsExtras.api = this;

        this.loadMessages(this.messageCache, langConfig);

        new PlayerJoin(this);
        new SpawnCommand(this).register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JewelsExtras get() {
        return JewelsExtras.api;
    }
}
