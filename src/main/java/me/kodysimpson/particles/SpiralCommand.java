package me.kodysimpson.particles;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SpiralCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Location location = p.getEyeLocation();
        int radius = 2;

        final double[] locationY = {0};

        new BukkitRunnable(){
            @Override
            public void run() {
                //Calculate the X and Z offset depending on the Y
                double x = radius * Math.cos(locationY[0]);
                double z = radius * Math.sin(locationY[0]);
                p.spawnParticle(Particle.REDSTONE, location.add(x, locationY[0], z), 50, new Particle.DustOptions(Color.AQUA, 5.0F));
                locationY[0] = locationY[0] + 0.1;
            }
        }.runTaskTimerAsynchronously(Particles.getPlugin(), 0, 10); //every half a second

        return true;
    }
}
