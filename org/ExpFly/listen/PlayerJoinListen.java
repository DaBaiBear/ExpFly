package org.ExpFly.listen;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import static org.ExpFly.config.*;

public class PlayerJoinListen implements Listener {

    @EventHandler
    public void joinServer(PlayerJoinEvent event) throws IOException {
        Player player = event.getPlayer();
        player.setFlying(false);
        File f = new File(DataPath + player.getName() + ".yml");
        if (!f.exists()) {  //初始化玩家data数据
            f.createNewFile();
            FileWriter data = new FileWriter(f, true);
            data.write("Energy: " + DefaultEnergy + "\n");
            data.flush();
            data.close();
        }
    }
}
