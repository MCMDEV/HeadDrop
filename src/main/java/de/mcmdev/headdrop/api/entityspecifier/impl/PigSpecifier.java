package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;

public class PigSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public PigSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        return getDrop("PIG");
    }
}
