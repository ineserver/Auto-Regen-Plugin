package net._1necat.auto_regen_plugin;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;

public final class AutoRegenPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
                MVWorldManager worldManager = core.getMVWorldManager();
                Calendar calendar = Calendar.getInstance();
                int month = calendar.get(Calendar.MONTH);
                if (calendar.get(Calendar.DAY_OF_MONTH) == 1 && month % 2 == 0) {
                        worldManager.regenWorld("shizai", false, true, null);
                        worldManager.regenWorld("nether_saisyu", false, true, null);
                        worldManager.regenWorld("end_saisyu", false, true, null);
                }
            }
        }.runTaskTimer(this, 0L, 24L * 60L * 60L * 20L); // 1日ごとに実行
    }
}
