package de.mcmdev.headdrop.api.entityspecifier;

import de.mcmdev.headdrop.api.HeadDrop;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public abstract class EntitySpecifier {

    private DropManager dropManager;

    public EntitySpecifier(DropManager dropManager) {
        this.dropManager = dropManager;
    }

    public abstract ItemStack match(Entity entity);

    protected ItemStack getDrop(String id)  {
        HeadDrop headDrop =  dropManager.getHeadConfig().getHeadDrop(id);
        int i = new Random().nextInt(101);
        if(i <= headDrop.getChance())   {
            return headDrop.getHeadDrop();
        }   else    {
            return null;
        }
    }

}
