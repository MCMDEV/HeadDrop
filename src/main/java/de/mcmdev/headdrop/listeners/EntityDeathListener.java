package de.mcmdev.headdrop.listeners;

import de.mcmdev.headdrop.HeadDropsPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathListener implements Listener {

    private HeadDropsPlugin plugin;

    public EntityDeathListener(HeadDropsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if(plugin.getDropManager().hasSpecifier(event.getEntityType())) {
            ItemStack toDrop = plugin.getDropManager().getSpecifier(event.getEntityType()).match(event.getEntity());
            if(toDrop == null) return;
            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), toDrop);
        }
    }

}
