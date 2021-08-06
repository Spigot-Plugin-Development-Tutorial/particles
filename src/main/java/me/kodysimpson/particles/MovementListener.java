package me.kodysimpson.particles;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Vibration;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){

        //The primary resource I used: https://www.spigotmc.org/threads/comprehensive-particle-spawning-guide-1-13-1-17.343001/

        Player p = e.getPlayer();

        //Spawn 1 particle at the players location
        p.spawnParticle(Particle.BUBBLE_POP, p.getLocation(), 1);

        //walking lava rain
        p.spawnParticle(Particle.FALLING_LAVA, p.getLocation(), 50, 5, 0, 5);

        //Spawn directional particles
        //count is zero, the offsets seem to become the direction velocities
        p.spawnParticle(Particle.CRIT, p.getEyeLocation(), 0, 0, 1, 0);

        //Colorized redstone "dust" particles
        //first param is color, second is size
        Particle.DustOptions options =  new Particle.DustOptions(Color.AQUA, 5.0F);
        p.spawnParticle(Particle.REDSTONE, p.getEyeLocation().add(0, 1, 0), 50, options);

        //Colorized transition redstone "dust" particles
        Particle.DustTransition dustTransition = new Particle.DustTransition(Color.RED, Color.GREEN, 1.0F);
        p.spawnParticle(Particle.DUST_COLOR_TRANSITION, p.getLocation(), 50, dustTransition);

        //Material Particles
        BlockData fallingDustData = Material.REDSTONE_BLOCK.createBlockData();
        p.spawnParticle(Particle.FALLING_DUST, p.getLocation(), 10, fallingDustData);

        //Vibrations
        Vibration vibration = new Vibration(p.getLocation(), new Vibration.Destination.EntityDestination(p), 40);
        p.getWorld().spawnParticle(Particle.VIBRATION, p.getLocation(), 1, vibration);

    }

}
