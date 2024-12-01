package com.coderinlinux;

import com.coderinlinux.commands.Calculator;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("calc").setExecutor(new Calculator());
        getLogger().info("Hello World!");
    }

    @Override
    public void onDisable() {
    }
}
