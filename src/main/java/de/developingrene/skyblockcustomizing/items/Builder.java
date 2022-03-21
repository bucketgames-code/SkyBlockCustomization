package de.developingrene.skyblockcustomizing.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class Builder {
    /*
    item-emerald_sword
    item-coin
    item-broken-coin
    item-5dollar
    */
    public ItemStack Build(String item){
        if (item.equalsIgnoreCase("item-emerald_sword")){
            return getEmeraldSword();
        } else if (item.equalsIgnoreCase("item-coin")){
            return getCoin();
        } else if (item.equalsIgnoreCase("item-broken_coin")){
            return getBrokenCoin();
        } else if (item.equalsIgnoreCase("item-5dollar")){
            return get5Dollar();
        }
        return null;
    }

    private static ItemStack getEmeraldSword(){
        ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§a§lEmerald Sword");
        im.setCustomModelData(1);
        im.addItemFlags(ItemFlag.HIDE_DESTROYS);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier mod = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",13.0, AttributeModifier.Operation.ADD_NUMBER);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,mod);
        is.setItemMeta(im);
        is.addEnchantment(Enchantment.DAMAGE_ALL,1);
        return is;
    }

    private static ItemStack getCoin(){
        ItemStack is = new ItemStack(Material.EMERALD);
        ItemMeta im = is.getItemMeta();
        im.setCustomModelData(1);
        im.setDisplayName("§e§lCoin");
        im.addItemFlags(ItemFlag.HIDE_DESTROYS);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        is.setItemMeta(im);
        return is;
    }

    private static ItemStack getBrokenCoin(){
        ItemStack is = new ItemStack(Material.EMERALD);
        ItemMeta im = is.getItemMeta();
        im.setCustomModelData(2);
        im.setDisplayName("§6§lBroken Coin");
        im.addItemFlags(ItemFlag.HIDE_DESTROYS);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        is.setItemMeta(im);
        return is;
    }

    private static ItemStack get5Dollar(){
        ItemStack is = new ItemStack(Material.EMERALD);
        ItemMeta im = is.getItemMeta();
        im.setCustomModelData(5);
        im.setDisplayName("§2§l5 Dollar");
        im.addItemFlags(ItemFlag.HIDE_DESTROYS);
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        im.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        is.setItemMeta(im);
        return is;
    }
}
