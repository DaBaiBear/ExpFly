package org.ExpFly;

import org.bukkit.entity.Player;


import static org.ExpFly.ExpFly.PlayerList;
import static org.ExpFly.config.*;


public class Flying extends Thread{

    @Override
    public void run() {

        do {

            for (int i = 0; i < PlayerList.size(); i++) {
                Player p = PlayerList.get(i);
                int energy = getPlayerFlyEnergy(p);
                PlayerList.removeIf(players -> !players.isFlying());
                if (energy >= speed) {
                    energy = energy - speed; //计算剩余能量
                    p.sendMessage("§e当前能量剩余：§a" + energy);
                    savePlayerFlyEnergy(p, energy); //保存剩余能量
                }
                
                if (energy < speed) {
                    p.sendMessage("§e能量不足！飞不动了！");
                    p.setFlying(false);
                    if (energy <= 0) {
                        savePlayerFlyEnergy(p, 0);
                    } else {
                        savePlayerFlyEnergy(p, energy);
                    }
                    PlayerList.remove(i);
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}