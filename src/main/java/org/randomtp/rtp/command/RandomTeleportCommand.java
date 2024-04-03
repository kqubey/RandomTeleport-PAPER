package org.randomtp.rtp.command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class RandomTeleportCommand extends Command{

    public RandomTeleportCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.sendTitle("§7Location search", null);
            
            Random random = new Random();
            int x = random.nextInt(1000) - 500;
            int y = 60;
            int z = random.nextInt(1000) - 500;

            World world = player.getWorld();
            Chunk chunk = world.getChunkAt(x, z);
            if (chunk.load()) {
                Location targetLocation = new Location(world, x, y, z);
                while (targetLocation.getBlock().getType() != Material.AIR) {
                    targetLocation.setY(targetLocation.getY() + 1);
                }

                world.loadChunk(chunk);
                player.sendTitle("§eLocation found", null);
                player.teleport(targetLocation);
                return true;
            }
            player.sendMessage("§cError! Location was not found");
            return true;
        }
        commandSender.sendMessage("Use in game");
        return true;
    }
}