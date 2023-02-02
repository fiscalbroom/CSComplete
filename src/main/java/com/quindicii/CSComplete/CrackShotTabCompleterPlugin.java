package com.quindicii.CSComplete;

import com.quindicii.CSComplete.command.CrackShotCommandTabCompleter;

import com.shampaggon.crackshot.CSDirector;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


/*
    * Created by Quindicii on 02/02/2022
 */

public class CrackShotTabCompleterPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginDescriptionFile descriptionFile = getDescription();
        Logger logger = getLogger();
        getLogger().info("Abilitando il plugin (version " + descriptionFile.getVersion() + ")");
        enableTabCompleter();
        getLogger().info("Plugin abilitato (version " + descriptionFile.getVersion() + ")");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile descriptionFile = getDescription();
        Logger logger = getLogger();
        getLogger().info("Disabilitando il plugin (version " + descriptionFile.getVersion() + ")");
        getLogger().info("Plugin disabilitato (version " + descriptionFile.getVersion() + ")");
    }

    private void enableTabCompleter() {
        CSDirector csPlugin = (CSDirector) getServer().getPluginManager().getPlugin("CrackShot");
        getServer().getPluginCommand("crackshot").setTabCompleter(new CrackShotCommandTabCompleter(csPlugin));
    }

}


