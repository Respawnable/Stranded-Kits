package me.respawn.sdamage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Damage extends JavaPlugin implements Listener{
	
	Plugin p;
	@Override
	public void onEnable() {
	p = this;
	Bukkit.getPluginManager().registerEvents(this, p);
	}
	
	@EventHandler
	public void onSwordDamage(EntityDamageByEntityEvent event) {
	if (event.getDamager() instanceof Player) { //If the damager is player
	Player player = (Player) event.getDamager();
	if (player.getInventory().getItemInHand().getType() == Material.STONE_SWORD) { //If the damagers item is a stone sword
	 
	ItemStack hand = player.getInventory().getItemInHand();
	if (hand.getItemMeta().hasEnchants()) { //The item has enchants
	event.setDamage(3.0);
	}
	}
	}
	}
}
