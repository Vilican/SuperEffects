/*
 * Copyright (C) 2016 vilican
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.vilican.supereffects;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import static org.bukkit.potion.PotionEffectType.*;

/**
 *
 * @author vilican
 */
public class Functions {

    public static void removeEffects(Player player) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

    public static void addEffects(Player player) {
        removeEffects(player);
        player.addPotionEffect(new PotionEffect(ABSORPTION, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(DAMAGE_RESISTANCE, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(FAST_DIGGING, 1000000, 5, true, false), true);
        player.addPotionEffect(new PotionEffect(FIRE_RESISTANCE, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(HEAL, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(HEALTH_BOOST, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(INCREASE_DAMAGE, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(JUMP, 1000000, 3, true, false), true);
        player.addPotionEffect(new PotionEffect(LUCK, 1000000, 5, true, false), true);
        player.addPotionEffect(new PotionEffect(NIGHT_VISION, 1000000, 3, true, false), true);
        player.addPotionEffect(new PotionEffect(REGENERATION, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(SATURATION, 1000000, 99, true, false), true);
        player.addPotionEffect(new PotionEffect(SPEED, 1000000, 3, true, false), true);
        player.addPotionEffect(new PotionEffect(WATER_BREATHING, 1000000, 99, true, false), true);
    }

    public static void displayHelp(Object sender) {
        if (sender instanceof Player) {
            Player playersender = (Player) sender;
            playersender.sendMessage(ChatColor.AQUA + "========================================");
            playersender.sendMessage(ChatColor.AQUA + "");
            playersender.sendMessage(ChatColor.AQUA + "SuperEffects v1.1 by vilican");
            playersender.sendMessage(ChatColor.AQUA + "");
            playersender.sendMessage(ChatColor.AQUA + "/sef - apply effects to yourself");
            playersender.sendMessage(ChatColor.AQUA + "/sef <target> - apply effects to target");
            playersender.sendMessage(ChatColor.AQUA + "/rsef - remove effects from yourself");
            playersender.sendMessage(ChatColor.AQUA + "/rsef <target> - remove effects from target");
            playersender.sendMessage(ChatColor.AQUA + "");
            playersender.sendMessage(ChatColor.AQUA + "========================================");
        } else if (sender instanceof ConsoleCommandSender) {
            System.out.println("========================================");
            System.out.println("");
            System.out.println("SuperEffects v1.1 by vilican");
            System.out.println("");
            System.out.println("/sef - apply effects to yourself");
            System.out.println("/sef <target> - apply effects to target");
            System.out.println("/rsef - remove effects from yourself");
            System.out.println("/rsef <target> - remove effects from target");
            System.out.println("");
            System.out.println("========================================");
        }
    }
}
