package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public class EndermanSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public EndermanSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        return getDrop("ENDERMAN");
    }
}
