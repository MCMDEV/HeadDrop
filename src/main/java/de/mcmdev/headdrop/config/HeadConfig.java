package de.mcmdev.headdrop.config;

import de.mcmdev.headdrop.HeadDropsPlugin;
import de.mcmdev.headdrop.api.HeadDrop;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HeadConfig {

    private HeadDropsPlugin plugin;
    private File file;
    private YamlConfiguration configuration;
    private Map<String, HeadDrop> drops = new HashMap<>();

    public HeadConfig(HeadDropsPlugin plugin) {
        this.plugin = plugin;

        plugin.saveResource("drops.yml", false);
        file = new File(plugin.getDataFolder() + "\\drops.yml");
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void load() {
        plugin.getServer().getConsoleSender().sendMessage(plugin.getPrefix() + "Loaded the following head drops: ");
        for(String key : configuration.getKeys(false))  {
            drops.put(key, new HeadDrop(configuration.getString(key + ".texture"), configuration.getString(key + ".display"), configuration.getDouble(key + ".chance")));
            plugin.getServer().getConsoleSender().sendMessage(plugin.getPrefix() + key);
        }
    }

    public void save() {
        for(Map.Entry<String, HeadDrop> item : drops.entrySet())  {
            configuration.set(item.getKey(), item.getValue());
        }
        try {
            configuration.save(file);
        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(plugin.getPrefix() + "§cCould not load prefix");
        }
    }

    public HeadDrop getHeadDrop(String identifier)  {
        return drops.get(identifier);
    }
}
