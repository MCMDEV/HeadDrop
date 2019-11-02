package de.mcmdev.headdrop.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemStackBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public static ItemStackBuilder create(Material material) {
        return new ItemStackBuilder(material);
    }

    public static ItemStackBuilder create(ItemStack itemStack)  {
        return new ItemStackBuilder(itemStack);
    }

    private ItemStackBuilder(ItemStack itemStack)   {
        this.itemStack = itemStack;
        this.itemMeta = this.itemStack.getItemMeta();
    }

    private ItemStackBuilder(Material material) {
        this.itemStack = new ItemStack(material, 1);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemStackBuilder withAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder withDamage(byte damage) {
        this.itemStack.setDurability((short)damage);
        return this;
    }

    public ItemStackBuilder withName(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    public ItemStackBuilder withLore(String... lore) {
        this.itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemStackBuilder withSkullOwner(Player owner)    {
        if(itemStack.getType() == Material.PLAYER_HEAD) {
            SkullMeta skullMeta = (SkullMeta) itemMeta;
            ((SkullMeta) itemMeta).setOwningPlayer(owner);
        }
        return this;
    }

    public ItemStackBuilder withSkullTexture(String texture)    {
        if(itemStack.getType() == Material.PLAYER_HEAD) {
            SkullMeta headMeta = (SkullMeta) itemMeta;
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);

            profile.getProperties().put("textures", new Property("textures", texture));

            try {
                Field profileField = headMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(headMeta, profile);
            }
            catch (IllegalArgumentException|NoSuchFieldException|SecurityException | IllegalAccessException error){
                error.printStackTrace();
            }
        }
        return this;
    }

    public ItemStackBuilder addLore(String line) {
        List<String> old = this.itemMeta.getLore();
        old.add(line);
        this.itemMeta.setLore(old);
        return this;
    }

    public ItemStackBuilder makeUnbreakable() {
        this.itemMeta.spigot().setUnbreakable(true);
        return this;
    }

    public ItemStackBuilder addEnchantment(Enchantment enchantment, int lvl) {
        this.itemMeta.addEnchant(enchantment, lvl, false);
        return this;
    }

    public ItemStackBuilder addUnsafeEnchantment(Enchantment enchantment, int lvl) {
        this.itemMeta.addEnchant(enchantment, lvl, true);
        return this;
    }

    public ItemStackBuilder addItemFlags(ItemFlag... flags) {
        this.itemMeta.addItemFlags(flags);
        return this;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

}
