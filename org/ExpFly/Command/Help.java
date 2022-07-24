package org.ExpFly.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help {
    public Help(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            if(sender.isOp()){
                sender.sendMessage("§7§m=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                sender.sendMessage("§a/"+label+" §e开启/关闭飞行");
                sender.sendMessage("§a/"+label+" query §e查询能量");
                sender.sendMessage("§a/"+label+" inv [值] §e兑换能量");
                sender.sendMessage("§a/"+label+" give [ID] [值] §e给予玩家能量");
                sender.sendMessage("§a/"+label+" set speed [值] §e设置每秒能量消耗速度");
                sender.sendMessage("§a/"+label+" set inv [值] §e设置每点经验兑换多少能量");
                sender.sendMessage("§a/"+label+" reload §e重载插件!");
                sender.sendMessage("§7§m=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            }else {
                sender.sendMessage("§7§m=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                sender.sendMessage("§a/"+label+" §e开启/关闭飞行");
                sender.sendMessage("§a/"+label+" query §e查询能量");
                sender.sendMessage("§a/"+label+" inv [值] §e兑换能量");
                sender.sendMessage("§7§m=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }

        }else{
            sender.sendMessage("§7§m=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            sender.sendMessage("§a/"+label+" §e开启/关闭飞行");
            sender.sendMessage("§a/"+label+" query §e查询能量");
            sender.sendMessage("§a/"+label+" inv [值] §e兑换能量");
            sender.sendMessage("§a/"+label+" give [ID] [值] §e给予玩家能量");
            sender.sendMessage("§a/"+label+" set speed [值] §e设置每秒能量消耗速度");
            sender.sendMessage("§a/"+label+" set inv [值] §e设置每点经验兑换多少能量");
            sender.sendMessage("§a/"+label+" reload §e重载插件!");
            sender.sendMessage("§7§m=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        }
    }

}
