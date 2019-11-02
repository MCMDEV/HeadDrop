package de.mcmdev.headdrop.api;

import de.mcmdev.headdrop.utils.ItemStackBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class HeadDrop {

    private String texture;
    private String display;
    private double chance;

    public HeadDrop(String texture, String display, double chance) {
        this.texture = texture;
        this.display = ChatColor.translateAlternateColorCodes('&', display);
        this.chance = chance;
    }

    public ItemStack getHeadDrop() {
        return ItemStackBuilder.create(Material.PLAYER_HEAD).withName(display).withSkullTexture(texture).build();
    }

    public double getChance() {
        return chance;
    }
}
