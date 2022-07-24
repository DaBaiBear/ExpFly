package org.ExpFly;


import org.ExpFly.Command.Command;
import org.ExpFly.listen.PlayerFlyListen;
import org.ExpFly.listen.PlayerJoinListen;
import org.ExpFly.listen.PlayerQuitListen;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.ExpFly.config.DataPath;

public class ExpFly extends JavaPlugin {
    public static List<Player> PlayerList = new ArrayList<>();
    @Override
    public void onEnable() {
        LoadConfig();
        this.getCommand("efly").setExecutor(new Command());
        this.getServer().getPluginManager().registerEvents(new PlayerFlyListen(),this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListen(),this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuitListen(),this);
        new Flying().start();
    }
    @Override
    public void onDisable() {
    }
    public void LoadConfig(){
        getConfig().options().copyDefaults();
        saveDefaultConfig();//加载配置文件
        File f = new File(DataPath);
        if (!f.exists()) {
            f.mkdir();//创建data文件存放玩家数据
        }
    }
}