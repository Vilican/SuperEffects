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
public class HideCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length > 0) {

            if (args[0].equalsIgnoreCase("help")) {
                com.vilican.supereffects.Functions.displayHelp(sender);
                return true;
            } else if (sender.hasPermission("sef.others.hide")) {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    com.vilican.supereffects.Functions.hide(player);
                    sender.sendMessage(ChatColor.GREEN + "Effect added");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "Player is not online!");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Access denied!");
                return true;
            }
        } else if (sender instanceof Player) {
            if (sender.hasPermission("sef.self.hide")) {
                Player playersender = (Player) sender;
                com.vilican.supereffects.Functions.hide(playersender);
                sender.sendMessage(ChatColor.GREEN + "Effect added");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Access denied!");
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You are not a player!");
            return true;
        }
    }
}
