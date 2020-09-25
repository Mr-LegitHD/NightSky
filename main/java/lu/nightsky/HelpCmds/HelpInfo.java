package lu.nightsky.HelpCmds;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpInfo extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "info")) {
            if (args[1].equalsIgnoreCase("help")) {
                User user = event.getAuthor();
                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\uD83D\uDCAD NightSky | Info Commands");
                info.addField("**+infos**: ", "Give you some infos about the Bot", false);
                info.addField("**+ping:** ", "Get my Ping", false);
                info.addField("**+links:** ", "Get some interesting Links", false);
                info.addField("**+serverinfo:** ", "Get some Informations about the Server", false);
                info.addField("**+profile:** ", "get some Informations about yourself", false);
                info.setFooter("NightSky " + Secrets.version);
                info.setColor(Color.blue);
                info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +helpInfo got used by " + event.getAuthor().getName());

            }
        }
    }
}
