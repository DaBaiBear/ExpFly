package org.ExpFly.Command;


import org.bukkit.GameMode;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;


import static org.ExpFly.ExpFly.PlayerList;
import static org.ExpFly.config.*;
import static org.ExpFly.config.setInvert;


public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length == 0 && sender instanceof Player){
            Player player = (Player) sender;
            if (player.getGameMode() == GameMode.SURVIVAL){
                if (player.getAllowFlight()){
                    player.setAllowFlight(false);
                    player.setFlying(false);


                    for (int i = 0; i < PlayerList.size(); i++) { //停止玩家线程
                        if (PlayerList.get(i).getPlayer() == player) {
                            PlayerList.remove(i);
                        }
                    }
                    player.sendMessage("§e关闭飞行");
                }else {
                    ((Player) sender).setAllowFlight(true);
                    player.sendMessage("§e开启飞行");
                }
                return false;
            }
        }else if(args.length==1 ){
            if (args[0].equalsIgnoreCase("reload") && sender.isOp()){
                reload(sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("query") && sender instanceof Player){
                sender.sendMessage("§e剩余经验值：§a" + ((Player) sender).getTotalExperience() + "§e点,能量值：§a" + getPlayerFlyEnergy((Player) sender) + "§e点！");
                return false;
            }

        }else if (args.length == 2 && sender instanceof Player) {
            if (args[0].equalsIgnoreCase("inv")) {
                new InvertEnergy(sender,command,label,args);
                return false;
            }
        }else if (args.length == 3 && args[0].equalsIgnoreCase("set") && sender.isOp()) {
            if (args[1].equalsIgnoreCase("speed") && isNumeric(args[2])){
                setSpeed(args[2]);
                sender.sendMessage("§e能量消耗设置：§a"+args[2]+"§e点/s");
                return false;
            }else if (args[1].equalsIgnoreCase("inv") && isNumeric(args[2])){
                setInvert(args[2]);
                sender.sendMessage("§e兑换比例设置为：§a"+args[2]+"§e点每经验值");
                return false;
            }

        }else if(args.length == 3 && args[0].equalsIgnoreCase("give") && isNumeric(args[2]) && sender.isOp()){
            File f = new File(DataPath + args[1] + ".yml");
            if (f.exists()) {  //检查玩家是否有数据
                int energy = getPlayerFlyEnergy((args[1]))+Integer.parseInt(args[2]);
                String name = args[1];
                savePlayerFlyEnergy(name, energy);
                sender.sendMessage("§e给予玩家§a"+name+"§e能量值§a"+args[2]);
            }else {
                sender.sendMessage("§e没有找到该玩家的数据！");
            }

            return false;
        }

        new Help(sender, command, label, args);
        return false;

    }
}
