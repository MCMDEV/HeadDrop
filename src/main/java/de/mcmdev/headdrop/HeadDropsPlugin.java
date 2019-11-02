package de.mcmdev.headdrop;

import de.mcmdev.headdrop.api.HeadDrop;
import de.mcmdev.headdrop.config.HeadConfig;
import de.mcmdev.headdrop.config.MessagesConfig;
import de.mcmdev.headdrop.listeners.EntityDeathListener;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeadDropsPlugin extends JavaPlugin {

    private String prefix = "§e[HeadDrops] ";

    private DropManager dropManager;
    //private MessagesConfig messagesConfig;
    private HeadConfig headConfig;

    @Override
    public void onEnable() {
        loadMainConfig();

        dropManager = new DropManager(this);
        //messagesConfig = new MessagesConfig(this);
        headConfig = new HeadConfig(this);

        headConfig.load();
        //messagesConfig.load();

        getServer().getPluginManager().registerEvents(new EntityDeathListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadMainConfig()   {
        saveDefaultConfig();
        if(getConfig().contains("prefix"))  {
            prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix"));
        }
    }

    public String getPrefix() {
        return prefix;
    }

    /*public MessagesConfig getMessagesConfig() {
        return messagesConfig;
    }*/

    public HeadConfig getHeadConfig() {
        return headConfig;
    }

    public DropManager getDropManager() {
        return dropManager;
    }
}
