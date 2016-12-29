package com.enjin.gamesplazabrasil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Stray;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class Tags extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }


    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();

    Team tagdono = board.registerNewTeam("tagdono");
    Team tagsubdono = board.registerNewTeam("tagsubdono");

    Team tagadmin = board.registerNewTeam("tagadmin");
    Team taglider = board.registerNewTeam("taglider");
    Team tagmod = board.registerNewTeam("tagmod");
    Team tagajudante = board.registerNewTeam("tagajudante");
    Team tagvipvit = board.registerNewTeam("tagvipvit");
    Team tagvip = board.registerNewTeam("tagvip");
    Team tagyt = board.registerNewTeam("tagyt");
    Team tagtestador = board.registerNewTeam("tagtestador");
    Team tagpadrao = board.registerNewTeam("tagpadrao");

    @EventHandler
    void onPlyerChat(AsyncPlayerChatEvent e) {
        if (tagdono.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.DARK_RED  +"" + ChatColor.MAGIC + "a" + ChatColor.DARK_RED +  "Dono" + ChatColor.MAGIC + "a " + ChatColor.DARK_RED + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagsubdono.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.AQUA + "" + ChatColor.MAGIC + "a" + ChatColor.AQUA +  "Subdono" + ChatColor.MAGIC + "a" + ChatColor.AQUA + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagadmin.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.RED + "" + ChatColor.MAGIC + "a" + ChatColor.RED + "Admin" + ChatColor.MAGIC + "a" + ChatColor.RED + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (taglider.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.RED + "" + ChatColor.MAGIC + "a" + ChatColor.RED + "Lider" + ChatColor.MAGIC + "a" + ChatColor.RED + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagmod.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.DARK_GREEN + "" + ChatColor.MAGIC + "a" + ChatColor.DARK_GREEN + "Mod" + ChatColor.MAGIC + "a" + ChatColor.DARK_GREEN + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagajudante.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.GREEN+ "" + ChatColor.MAGIC + "a" + ChatColor.GREEN + "Ajudante" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagvipvit.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.BLUE + "" + ChatColor.MAGIC + "a" + ChatColor.BLUE + "Vip" + ChatColor.MAGIC + "a" + ChatColor.BLUE + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagvip.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.YELLOW + "" + ChatColor.MAGIC + "a" + ChatColor.YELLOW + "Vip" + ChatColor.MAGIC + "a" + ChatColor.YELLOW + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagyt.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.BLACK + "" + ChatColor.MAGIC + "a" + ChatColor.BLACK + "You" + ChatColor.GOLD + "Tube" + ChatColor.MAGIC + "a" + ChatColor.RED + " " + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
        if (tagpadrao.hasPlayer(e.getPlayer())) {
            e.setFormat(ChatColor.GRAY + e.getPlayer().getName() + ChatColor.WHITE + ": " + e.getMessage());
        }
    }


    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {

        Player p = (Player) e.getPlayer();

        p.setScoreboard(board);

        tagdono.addPlayer(p);
        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce pode ver tags agora!");

        tagdono.removePlayer(p);


    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tag")) {

            Player p = (Player) sender;

            if (args.length == 0) {

                p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "-----------------[Tags]-----------------");
                p.sendMessage(ChatColor.WHITE + "TAG         DATA DE ATIVACAO           VENCIMENTO");
                if (p.hasPermission("tag.tag.vip")) {
                    p.sendMessage(ChatColor.YELLOW + "VIP                 xx/xx/xxxx               xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.vipvit")) {
                    p.sendMessage(ChatColor.BLUE + "VIPVIT            xx/xx/xxxx               xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.ajudante")) {
                    p.sendMessage(ChatColor.GREEN + "AJUDANTE       xx/xx/xxxx              xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.mod")) {
                    p.sendMessage(ChatColor.DARK_GREEN + "MOD                 xx/xx/xxxx              xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.lider")) {
                    p.sendMessage(ChatColor.RED + "LIDER              xx/xx/xxxx              xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.admin")) {
                    p.sendMessage(ChatColor.RED + "ADMIN              xx/xx/xxxx              xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.subdono")) {
                    p.sendMessage(ChatColor.AQUA + "SUBDONO          xx/xx/xxxx             xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.youtube")) {
                    p.sendMessage(ChatColor.BLACK + "YOU" + ChatColor.GOLD + "TUBE" + "         xx/xx/xxxx             xx/xx/xxxx");
                } else {
                    return true;
                }
                if (p.hasPermission("tag.tag.dono")) {
                    p.sendMessage(ChatColor.RED + "DONO                xx/xx/xxxx             xx/xx/xxxx");
                } else {
                    return true;
                }

                p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Compre mais tempo ou tags em http://gamesplazabrasil.enjin.com/shop !");
                return true;
            }
            if (args.length > 1) {
                p.sendMessage(ChatColor.BLUE + "Tag>" + ChatColor.RED + "Muitos argumentos!");
                return true;
            }


            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("dono")) {
                    if (p.hasPermission("tag.tag.dono")) {

                        tagdono.addPlayer(p);

                        p.setScoreboard(board);

                        tagdono.setPrefix(ChatColor.DARK_RED + "" + ChatColor.MAGIC + "a" + ChatColor.DARK_RED + ChatColor.BOLD + "ADM ");
                        tagdono.setSuffix(ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + " Dono" + ChatColor.DARK_RED + ChatColor.MAGIC + "a");


                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.DARK_RED + ChatColor.MAGIC + "a" + ChatColor.DARK_RED + "DONO" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }

                if (args[0].equalsIgnoreCase("subdono")) {
                    if (p.hasPermission("tag.tag.subdono")) {

                        p.setScoreboard(board);
                        tagsubdono.addPlayer(p);

                        tagsubdono.setPrefix(ChatColor.AQUA + "" + ChatColor.BOLD + "ADM ");

                        tagsubdono.setSuffix(" Subdono");
                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.AQUA + ChatColor.MAGIC + "a" + ChatColor.AQUA + "SUBDONO" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }


                if (args[0].equalsIgnoreCase("admin")) {
                    if (p.hasPermission("tag.tag.admin")) {

                        p.setScoreboard(board);
                        tagadmin.addPlayer(p);

                        tagadmin.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "ADM ");
                        tagadmin.setSuffix(ChatColor.RED + "" + ChatColor.ITALIC + " Admin");
                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.RED + ChatColor.MAGIC + "a" + ChatColor.RED + "ADMIN" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }
                if (args[0].equalsIgnoreCase("lider")) {
                    if (p.hasPermission("tag.tag.admin")) {

                        p.setScoreboard(board);
                        taglider.addPlayer(p);

                        taglider.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "ADM ");
                        taglider.setSuffix(ChatColor.RED + "" + ChatColor.ITALIC + " Lider");
                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.RED + ChatColor.MAGIC + "a" + ChatColor.RED + "LIDER" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }
                if (args[0].equalsIgnoreCase("mod")) {
                    if (p.hasPermission("tag.tag.mod")) {
                      tagmod.addPlayer(p);
                        p.setScoreboard(board);
                      tagmod.setPrefix(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MOD ");
                      tagmod.setSuffix(ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + " Moderador");
                      p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.DARK_GREEN + ChatColor.MAGIC + "a" + ChatColor.DARK_GREEN + "MODERADOR" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }
                if (args[0].equalsIgnoreCase("ajudante")) {
                    if (p.hasPermission("tag.tag.ajudante")) {
                        p.setScoreboard(board);
                        tagajudante.addPlayer(p);
                        tagajudante.setPrefix(ChatColor.GREEN + "" + ChatColor.BOLD + "MOD ");
                        tagajudante.setSuffix(ChatColor.GREEN + "" + ChatColor.BOLD + " Ajudante");
                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.GREEN + ChatColor.MAGIC + "a" + ChatColor.GREEN + "AJUDANTE" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }
                if (args[0].equalsIgnoreCase("vipvit")) {
                    if (p.hasPermission("tag.tag.vipvit")) {
                        p.setScoreboard(board);
                      tagvipvit.addPlayer(p);
                      tagvipvit.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "VIP ");
                      tagvipvit.setSuffix(ChatColor.BLUE + "" + ChatColor.ITALIC + " Eterno");
                      p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.BLUE + ChatColor.MAGIC + "a" + ChatColor.BLUE + "VipVit" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }
                if (args[0].equalsIgnoreCase("vip")) {
                    if (p.hasPermission("tag.tag.vip")) {
                       p.setScoreboard(board);
                       tagvip.addPlayer(p);
                       tagvip.setPrefix(ChatColor.YELLOW + "" + ChatColor.BOLD + "VIP ");
                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.YELLOW + ChatColor.MAGIC + "a" + ChatColor.YELLOW + "VIP" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }
                if (args[0].equalsIgnoreCase("youtube")) {
                    if (p.hasPermission("tag.tag.youtube")) {
                        p.setScoreboard(board);
                        tagyt.addPlayer(p);
                        tagyt.setPrefix(ChatColor.BLACK + "" + ChatColor.MAGIC + "a" + ChatColor.BOLD + "" + ChatColor.BLACK + "You " + ChatColor.RED);
                        tagyt.setSuffix(ChatColor.GOLD + " Tube" + ChatColor.MAGIC + "a");
                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta usando a tag " + ChatColor.BLACK + "" + ChatColor.MAGIC + "a" + ChatColor.BOLD + "" + ChatColor.BLACK + "You" + ChatColor.GOLD + "Tube" + ChatColor.MAGIC + "a" + ChatColor.GREEN + " agora!");
                    }
                }
                if (args[0].equalsIgnoreCase("off")) {
                    if (p.hasPermission("tag.tag.off")) {
                      tagpadrao.addPlayer(p);

                       tagpadrao.setPrefix(null);
                       tagpadrao.setSuffix(null);

                        p.sendMessage(ChatColor.BLUE + "Tag> " + ChatColor.GREEN + "Voce esta sem tag agora!");
                    }
                }
            }

        }


        return false;
    }
}

