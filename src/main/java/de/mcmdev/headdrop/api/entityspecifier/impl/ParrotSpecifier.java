package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;

public class ParrotSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public ParrotSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof Parrot)    {
            Parrot parrot = (Parrot) entity;
            if(parrot.getVariant() == Parrot.Variant.RED)   {
                return getDrop("PARROT_RED");
            }   else if(parrot.getVariant() == Parrot.Variant.BLUE)   {
                return getDrop("PARROT_BLUE");
            }   else if(parrot.getVariant() == Parrot.Variant.CYAN)   {
                return getDrop("PARROT_CYAN");
            }   else if(parrot.getVariant() == Parrot.Variant.GRAY)   {
                return getDrop("PARROT_GRAY");
            }   else if(parrot.getVariant() == Parrot.Variant.GREEN)   {
                return getDrop("PARROT_GREEN");
            }


        }
        return getDrop("PARROT_RED");
    }
}
