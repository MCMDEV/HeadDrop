package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.HeadDrop;
import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.ItemStack;

public class HorseSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public HorseSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof Horse)    {
            Horse horse = (Horse) entity;
            if(horse.getColor() == Horse.Color.BLACK)   {
                return getDrop("HORSE_BLACK");
            }   else
            if(horse.getColor() == Horse.Color.BROWN)   {
                return getDrop("HORSE_BROWN");
            }   else
            if(horse.getColor() == Horse.Color.CHESTNUT)   {
                return getDrop("HORSE_CHESTNUT");
            }   else
            if(horse.getColor() == Horse.Color.CREAMY)   {
                return getDrop("HORSE_CREAMY");
            }   else
            if(horse.getColor() == Horse.Color.DARK_BROWN)   {
                return getDrop("HORSE_DARKBROWN");
            }   else
            if(horse.getColor() == Horse.Color.GRAY)   {
                return getDrop("HORSE_GRAY");
            }   else
            if(horse.getColor() == Horse.Color.WHITE)   {
                return getDrop("HORSE_WHITE");
            }

        }
        return getDrop("HORSE_BROWN");
    }
}
