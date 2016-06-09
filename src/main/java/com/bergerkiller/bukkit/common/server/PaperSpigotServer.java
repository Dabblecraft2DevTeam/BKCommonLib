package com.bergerkiller.bukkit.common.server;

import org.bukkit.Bukkit;

/**
 * Created by Develop on 27-2-2016.
 */
public class PaperSpigotServer extends SpigotServer {

    @Override
    public boolean init() {
        return !(!super.init() || !Bukkit.getServer().getVersion().contains("PaperSpigot"));
    }

    @Override
    public String getServerName() {
        return "PaperSpigot";
    }
}
