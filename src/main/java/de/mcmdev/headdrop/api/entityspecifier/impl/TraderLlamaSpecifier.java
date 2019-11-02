package de.mcmdev.headdrop.api.entityspecifier.impl;

import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.manager.DropManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.TraderLlama;
import org.bukkit.inventory.ItemStack;

public class TraderLlamaSpecifier extends EntitySpecifier {

    private DropManager dropManager;

    public TraderLlamaSpecifier(DropManager dropManager) {
        super(dropManager);
        this.dropManager = dropManager;
    }

    @Override
    public ItemStack match(Entity entity) {
        if(entity instanceof TraderLlama)    {
            TraderLlama traderLlama = (TraderLlama) entity;
            if(traderLlama.getColor() == TraderLlama.Color.BROWN)   {
                return getDrop("TRADERLLAMA_BROWN");
            }   else if(traderLlama.getColor() == TraderLlama.Color.CREAMY)   {
                return getDrop("TRADERLLAMA_CREAMY");
            }   else if(traderLlama.getColor() == TraderLlama.Color.GRAY)   {
                return getDrop("TRADERLLAMA_GRAY");
            }   else if(traderLlama.getColor() == TraderLlama.Color.WHITE)   {
                return getDrop("TRADERLLAMA_WHITE");
            }
        }
        return getDrop("TRADERLLAMA_BROWN");
    }
}
