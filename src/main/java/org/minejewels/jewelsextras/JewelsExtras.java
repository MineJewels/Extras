package org.minejewels.jewelsextras;

import lombok.Getter;
import net.abyssdev.abysslib.config.AbyssConfig;
import net.abyssdev.abysslib.plugin.AbyssPlugin;
import net.abyssdev.abysslib.text.MessageCache;
import org.minejewels.jewelsextras.listeners.PlayerJoin;

@Getter
public final class JewelsExtras extends AbyssPlugin {

    private static JewelsExtras api;

    private final AbyssConfig langConfig = this.getAbyssConfig("lang");
    private final AbyssConfig settingsConfig = this.getAbyssConfig("settings");

    private final MessageCache messageCache = new MessageCache(langConfig);

    @Override
    public void onEnable() {
        JewelsExtras.api = this;

        this.loadMessages(this.messageCache, langConfig);

        new PlayerJoin(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JewelsExtras get() {
        return JewelsExtras.api;
    }
}
