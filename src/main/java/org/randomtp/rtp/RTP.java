package org.randomtp.rtp;

import org.bukkit.plugin.java.JavaPlugin;
import org.randomtp.rtp.command.RandomTeleportCommand;

import java.util.ArrayList;
import java.util.Arrays;

public final class RTP extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("RandomTP plugin was launched successfully");
        this.getServer().getCommandMap().register("rtp", new RandomTeleportCommand("rtp", "random teleport", "rtp", new ArrayList<>(Arrays.asList("randomtp"))));

    }

    @Override
    public void onDisable() {
        this.getLogger().info("RandomTP plugin has been successfully disabled");
    }
}
