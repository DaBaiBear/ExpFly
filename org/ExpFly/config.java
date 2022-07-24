package org.ExpFly;


import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class config {
    public static ExpFly plugin = ExpFly.getPlugin(ExpFly.class);
    public static String DataPath = "plugins\\ExpFly\\data\\";
    public static int DefaultEnergy = plugin.getConfig().getInt("DefaultEnergy");
    public static int speed = plugin.getConfig().getInt("Speed");
    public static int Invert = plugin.getConfig().getInt("Invert");

    public static void reload(CommandSender sender) {
        plugin = ExpFly.getPlugin(ExpFly.class);
        DefaultEnergy = plugin.getConfig().getInt("DefaultEnergy");
        speed = plugin.getConfig().getInt("Speed");
        Invert = plugin.getConfig().getInt("Invert");
        sender.sendMessage("§6成功重载配置!");
    }

    public static int getPlayerFlyEnergy(Player player) {
        File f = new File(DataPath + player.getName() + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("Energy");
    }
    public static int getPlayerFlyEnergy(String name) {
        File f = new File(DataPath + name + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        return yml.getInt("Energy");
    }


    public static void savePlayerFlyEnergy(String name, int Energy) {
        try {
            File f = new File(DataPath + name + ".yml");
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
            FileWriter data = null;
            data = new FileWriter(f, false);
            data.write("Energy: " + Energy + "\n");
            data.flush();
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void savePlayerFlyEnergy(Player player, int Energy) {
        try {
            File f = new File(DataPath + player.getName() + ".yml");
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
            FileWriter data = null;
            data = new FileWriter(f, false);
            data.write("Energy: " + Energy + "\n");
            data.flush();
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void savePlayerFlyEnergy(String name, String args) {
        int Energy = Integer.parseInt(args);
        try {
            File f = new File(DataPath + name + ".yml");
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
            FileWriter data = null;
            data = new FileWriter(f, false);
            data.write("Energy: " + Energy + "\n");
            data.flush();
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void savePlayerFlyEnergy(Player player, String args) {
        int Energy = Integer.parseInt(args);
        try {
            File f = new File(DataPath + player.getName() + ".yml");
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
            FileWriter data = null;
            data = new FileWriter(f, false);
            data.write("Energy: " + Energy + "\n");
            data.flush();
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setSpeed(int speed) {
        plugin.getConfig().set("Speed", speed);
        plugin.saveConfig();
    }
    public static void setSpeed(String args) {
        int speed = Integer.parseInt(args);
        plugin.getConfig().set("Speed", speed);
        plugin.saveConfig();
    }

    public static void setInvert(int Inv) {
        plugin.getConfig().set("Invert", Inv);
        plugin.saveConfig();
    }
    public static void setInvert(String args) {
        int Inv = Integer.parseInt(args);
        plugin.getConfig().set("Invert", Inv);
        plugin.saveConfig();
    }


    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
               return false;
            }
        }
        return true;
    }



}