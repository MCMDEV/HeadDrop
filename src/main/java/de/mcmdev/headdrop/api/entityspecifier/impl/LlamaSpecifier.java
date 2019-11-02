package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;

public class LlamaSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public LlamaSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof Llama)    {
            Llama llama = (Llama) entity;
            if(llama.getColor() == Llama.Color.BROWN)   {
                return getDrop("LLAMA_BROWN");
            }   else if(llama.getColor() == Llama.Color.CREAMY)   {
                return getDrop("LLAMA_CREAMY");
            }   else if(llama.getColor() == Llama.Color.GRAY)   {
                return getDrop("LLAMA_GRAY");
            }   else if(llama.getColor() == Llama.Color.WHITE)   {
                return getDrop("LLAMA_WHITE");
            }
        }
        return getDrop("LLAMA_BROWN");
    }
}
