package com.songoda.skyblock.island.reward;

import com.songoda.core.hooks.EconomyManager;
import com.songoda.skyblock.SkyBlock;
import org.bukkit.entity.Player;

import java.util.List;

public class LevelReward {

    private List<String> commands;

    private double money;

    public LevelReward(List<String> commands, double money) {
        this.commands = commands;
        this.money = money;
    }

    public void give(Player player, SkyBlock skyblock, long level) {
        if (money > 0)
            EconomyManager.deposit(player, money);

        if (!commands.isEmpty()) {
            for (String cmd : commands) {
                cmd = cmd.replace("%level%", "" + level);
                cmd = cmd.replace("%player%", player.getName());
                skyblock.getServer().dispatchCommand(skyblock.getConsole(), cmd);
            }
        }
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
