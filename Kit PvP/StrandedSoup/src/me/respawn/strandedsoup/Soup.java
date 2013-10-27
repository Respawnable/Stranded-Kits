package me.respawn.strandedsoup;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.respawn.strandedsoup.Soup;

public class Soup extends JavaPlugin implements Listener {
    public Soup() {
	}
	public Soup(Soup plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onEnable(){
        Bukkit.getServer().getLogger().info("Soups are now instant");
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
    	Player player = event.getPlayer();
    	double soup = 3.5;
    	if(player.getHealth() == 10.0){
    			}else{
    				if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
    					if(player.getItemInHand().getType() == Material.MUSHROOM_SOUP){
    						player.setHealth(player.getHealth() + soup > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + soup);
    						player.getItemInHand().setType(Material.BOWL);
    					}
    				}
    			}
    }
}