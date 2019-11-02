package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Parrot;
import org.bukkit.inventory.ItemStack;

public class PandaSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public PandaSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof Panda)    {
            Panda panda = (Panda) entity;
            if(panda.getMainGene() == Panda.Gene.BROWN)   {
                return getDrop("PANDA_BROWN");
            }
        }
        return getDrop("PANDA_NORMAL");
    }
}
