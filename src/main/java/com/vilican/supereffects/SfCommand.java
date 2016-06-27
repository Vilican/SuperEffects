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

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author vilican
 */
class SfCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player playersender = (Player) sender;
        if (args.length > 0) {

            if (args[0].equalsIgnoreCase("help")) {
                com.vilican.supereffects.Functions.displayHelp(playersender);
                return true;
            } else if (sender.hasPermission("sef.others.apply")) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    com.vilican.supereffects.Functions.addEffects(player);
                    playersender.sendMessage(ChatColor.GREEN + "Effects added");
                    return true;
                } else if (sender instanceof Player) {
                    playersender.sendMessage(ChatColor.RED + "Player is not online!");
                    return true;
                } else {
                    System.out.println("Player is not online!");
                    return true;
                }
            } else {
                playersender.sendMessage(ChatColor.RED + "Access denied!");
                return true;
            }
        } else if (sender instanceof Player) {
            if (sender.hasPermission("sef.self.apply")) {
                com.vilican.supereffects.Functions.addEffects(playersender);
                playersender.sendMessage(ChatColor.GREEN + "Effects added");
                return true;
            } else {
                playersender.sendMessage(ChatColor.RED + "Access denied!");
                return true;
            }
        } else {
            playersender.sendMessage(ChatColor.RED + "You are not a player!");
            return true;
        }
    }
}
