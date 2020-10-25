package lu.nightsky.Privat;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Shutdown extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User user = event.getAuthor();
        if (event.getAuthor().isBot()) return;
        if(!event.getAuthor().getId().equals("750768307333890178")) return;

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "shutdown")) {

            //Embedbuilder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\ud83d\udcad NightSky | Shutdown");
            info.setDescription("Bot shutting down");
            info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
            info.setColor(Color.red);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            event.getJDA().shutdown();
            System.out.println(dateFormat.format(newDate) + "Bot Shutdown by " + event.getAuthor().getName());
        }
    }
}


