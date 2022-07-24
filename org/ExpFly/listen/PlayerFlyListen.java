package org.ExpFly.listen;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import static org.ExpFly.ExpFly.PlayerList;
import static org.ExpFly.config.getPlayerFlyEnergy;
import static org.ExpFly.config.speed;


public class PlayerFlyListen implements Listener {


    @EventHandler
    public void a(PlayerToggleFlightEvent event) {

        if (event.getPlayer().getGameMode() == GameMode.SURVIVAL){
            Player player = event.getPlayer();
            if (event.isFlying()){

                if (getPlayerFlyEnergy(player)>speed) {
                    event.getPlayer().sendMessage("§e你开启了飞行");
                    Player p = event.getPlayer();
                    PlayerList.add(p);

                }else {
                    event.getPlayer().sendMessage("§e飞行能量不足，无法起飞！");
                    player.setFlying(false);
                    event.setCancelled(true);
                }

            }else{
                PlayerList.removeIf(players -> players == player);
                player.setFlying(false);
                event.getPlayer().sendMessage("§e你取消了了飞行");
            }
        }

    }

}
