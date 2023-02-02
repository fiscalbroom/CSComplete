package com.quindicii.CSComplete.command;

import com.shampaggon.crackshot.CSDirector;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CrackShotCommandTabCompleter implements TabCompleter {
    /**
     * Creato da Quindicii il 02/02/2022
     */
    private CSDirector csPlugin;


    public CrackShotCommandTabCompleter(CSDirector csPlugin) {
        this.csPlugin = csPlugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> variants = new ArrayList<>();
        if (!(sender instanceof Player)) return variants;
        switch (args.length) {
            case (1):
                variants.add("list");
                variants.add("give");
                variants.add("get");
                variants.add("reload");
                variants.add("config");
                break;
            case (2):
                if (args[0].equalsIgnoreCase("list")) variants.add("all");
                else if (args[0].equalsIgnoreCase("give")) variants = null;
                else if (args[0].equalsIgnoreCase("get")) variants.addAll(getWeaponList());
                else if (args[0].equalsIgnoreCase("config")) variants.add("reload");
                break;
            case (3):
                if (args[0].equalsIgnoreCase("give")) variants.addAll(getWeaponList());
                break;
        }
        if (variants != null) variants = TabCompleteManager.adopt(args[args.length-1], variants);
        return variants;
    }

    private Collection<String> getWeaponList() {
        return csPlugin.wlist.values();
    }
}
