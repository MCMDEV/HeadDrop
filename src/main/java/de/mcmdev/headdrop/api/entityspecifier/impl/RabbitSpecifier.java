package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;

public class RabbitSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public RabbitSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof Rabbit)    {
            Rabbit rabbit = (Rabbit) entity;
            if(rabbit.getRabbitType() == Rabbit.Type.BLACK)   {
                return getDrop("RABBIT_BLACK");
            }   else if(rabbit.getRabbitType() == Rabbit.Type.BLACK_AND_WHITE)   {
                return getDrop("RABBIT_BLACKWHITE");
            }   else if(rabbit.getRabbitType() == Rabbit.Type.BROWN)   {
                return getDrop("RABBIT_BROWN");
            }   else if(rabbit.getRabbitType() == Rabbit.Type.GOLD)   {
                return getDrop("RABBIT_GOLD");
            }   else if(rabbit.getRabbitType() == Rabbit.Type.SALT_AND_PEPPER)   {
                return getDrop("RABBIT_SALTPEPPER");
            }   else if(rabbit.getRabbitType() == Rabbit.Type.WHITE)   {
                return getDrop("RABBIT_WHITE");
            }   else if(rabbit.getRabbitType() == Rabbit.Type.THE_KILLER_BUNNY)   {
                return getDrop("RABBIT_KILLER");
            }


        }
        return getDrop("RABBIT_BLACK");
    }
}
