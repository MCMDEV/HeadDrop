package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;

public class CatSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public CatSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof Cat)    {
            Cat cat = (Cat) entity;
            if(cat.getCatType() == Cat.Type.BLACK)   {
                return getDrop("CAT_BLACK");
            }   else if(cat.getCatType() == Cat.Type.ALL_BLACK)   {
                return getDrop("CAT_ALLBLACK");
            }   else if(cat.getCatType() == Cat.Type.BRITISH_SHORTHAIR)   {
                return getDrop("CAT_BRITISH");
            }   else if(cat.getCatType() == Cat.Type.CALICO)   {
                return getDrop("CAT_CALICO");
            }   else if(cat.getCatType() == Cat.Type.JELLIE)   {
                return getDrop("CAT_JELLIE");
            }   else if(cat.getCatType() == Cat.Type.PERSIAN)   {
                return getDrop("CAT_PERSIAN");
            }   else if(cat.getCatType() == Cat.Type.RAGDOLL)   {
                return getDrop("CAT_RAGDOLL");
            }   else if(cat.getCatType() == Cat.Type.WHITE)   {
                return getDrop("CAT_WHITE");
            }   else if(cat.getCatType() == Cat.Type.RED)   {
                return getDrop("CAT_RED");
            }   else if(cat.getCatType() == Cat.Type.SIAMESE)   {
                return getDrop("CAT_SIAMESE");
            }   else if(cat.getCatType() == Cat.Type.TABBY)   {
                return getDrop("CAT_TABBY");
            }


        }
        return getDrop("CAT_TABBY");
    }
}
