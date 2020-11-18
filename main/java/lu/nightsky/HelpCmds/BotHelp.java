package lu.nightsky.HelpCmds;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BotHelp extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "bot")) {
            if (args[1].equalsIgnoreCase("help")) {

                User user = event.getAuthor();
                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\uD83D\uDCAD NightSky | Bot-Info Commands");
                info.addField("**+infos**: ", "Give you some infos about the Bot", false);
                info.addField("**+uptime:** ", "Get the current Bot uptime", false);
                info.addField("**+vote** ","Vote for our Bot", false);
                info.addField("**+hosting** ","Display Informations about the hosting of this Bot", false);
                info.addField("**+ping:** ", "Get my Ping", false);
                info.addField("**+links:** ", "Get some interesting Links", false);
                info.addField("**+donate:** ", "Support us with a Donation", false);
                info.setColor(Color.blue);
                info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +bothelp got used by " + event.getAuthor().getName());

            }
        }
    }
}
