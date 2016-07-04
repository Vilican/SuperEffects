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

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author vilican
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("SuperEffects v1.2.1 by vilican");
        System.out.println("Plugin enabled and running");
        this.getCommand("sef").setExecutor(new SfCommand());
        this.getCommand("rsef").setExecutor(new RSfCommand());
        this.getCommand("hide").setExecutor(new HideCommand());
        this.getCommand("show").setExecutor(new ShowCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin disabled");
    }
}
