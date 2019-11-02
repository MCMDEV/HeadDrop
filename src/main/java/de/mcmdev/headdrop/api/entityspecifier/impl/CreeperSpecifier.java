package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.DyeColor;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Sheep;
import org.bukkit.inventory.ItemStack;

public class CreeperSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public CreeperSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        return getDrop("CREEPER");
    }
}
