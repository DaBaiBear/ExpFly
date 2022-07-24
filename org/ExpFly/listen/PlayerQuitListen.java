package org.ExpFly.listen;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.ExpFly.ExpFly.PlayerList;


public class PlayerQuitListen implements Listener {

    @EventHandler
    public void a(PlayerQuitEvent event){

        Player player = event.getPlayer();
        player.setFlying(false);
        player.setAllowFlight(false);
        PlayerList.removeIf(players -> players == player);
    }
}
