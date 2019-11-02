package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.inventory.ItemStack;

public class SheepSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public SheepSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof Sheep)    {
            Sheep sheep = (Sheep) entity;
            DyeColor color = sheep.getColor();
            return getDrop("SHEEP_" + color.name());


        }
        return getDrop("SHEEP");
    }
}
