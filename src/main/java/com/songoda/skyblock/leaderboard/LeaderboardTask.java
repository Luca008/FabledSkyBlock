package com.songoda.skyblock.leaderboard;

import com.songoda.skyblock.SkyBlock;
import org.bukkit.scheduler.BukkitRunnable;

public class LeaderboardTask extends BukkitRunnable {

    private final SkyBlock plugin;

    public LeaderboardTask(SkyBlock plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        LeaderboardManager leaderboardManager = plugin.getLeaderboardManager();
        leaderboardManager.clearLeaderboard();
        leaderboardManager.resetLeaderboard();
        leaderboardManager.setupLeaderHeads();
    
        plugin.getHologramTask().updateHologram();
    }
}
