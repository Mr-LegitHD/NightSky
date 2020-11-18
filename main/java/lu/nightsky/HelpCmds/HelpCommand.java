package lu.nightsky.HelpCmds;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class HelpCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "help")) {
            User user = event.getAuthor();
            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\uD83D\uDCAD NightSky | Help & Commands");
            info.addField("**+help** ","List all Commands", false);
            info.addField("**+bot help** ","List all Bot Commands", false);
            info.addField("**+mod help** ","Display all Moderation Commands", false);
            info.addField("**+info help** ","Display all Informations Commands", false);
            info.addField("**+fun help** ","Display all Fun Commands", false);
            info.addField("**+admin help** ","Display all Admin Commands", false);
            info.addField("**+game help** ","Display all Game Commands", false);
            info.addField("**+ticket** ","Send a Support Ticket if you found a Bug", false);
            info.setColor(Color.blue);
            info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +help got used by "+ event.getAuthor().getName());

        }

    }
}
