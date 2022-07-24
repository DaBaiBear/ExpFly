package org.ExpFly.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import static org.ExpFly.config.*;

public class InvertEnergy {
    public InvertEnergy(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (isNumeric(args[1])){
            int delexp = Integer.parseInt(args[1]);//获取需要花费的经验值
            if (delexp>0) {
                int InvEnergy =delexp*Invert;//计算兑换的能量
                int exp = player.getTotalExperience()-delexp;//剩余经验值
                if (exp >= 0) {
                    int Energy = InvEnergy+getPlayerFlyEnergy(player);
                    player.giveExp(-delexp);
                    savePlayerFlyEnergy(player, Energy);
                    player.sendMessage("§e你成功消耗§a" + delexp + "§e点经验值兑换§a" + InvEnergy + "§e点能量！");
                    player.sendMessage("§e剩余经验值：§a" + exp + "§e点,能量值：§a" + Energy + "§e点！");

                } else {
                    player.sendMessage("§e经验值不足！");
                }
            }else{
                player.sendMessage("§e请正确输入花费兑换的经验值");
            }
            }else {
                player.sendMessage("§e请正确输入花费兑换的经验值");
            }

        }
    }

}
