package de.mcmdev.headdrop.config;

import de.mcmdev.headdrop.HeadDropsPlugin;
import de.mcmdev.headdrop.api.HeadDrop;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MessagesConfig {

    private HeadDropsPlugin plugin;
    private File file;
    private YamlConfiguration configuration;
    private Map<String, String> messages = new HashMap<>();

    public MessagesConfig(HeadDropsPlugin plugin) {
        this.plugin = plugin;

        file = new File(plugin.getDataFolder() + "\\messages.yml");
        plugin.saveResource("messages.yml", false);
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void load() {
        for(String key : configuration.getKeys(false))  {
            messages.put(key, configuration.getString(key));
        }
    }

    public String getMessage(String key)    {
        if(messages.containsValue(key)) {
            return messages.get(key);
        }   else    {
            return plugin.getPrefix() + "Could not load message: " + key;
        }
    }

}
