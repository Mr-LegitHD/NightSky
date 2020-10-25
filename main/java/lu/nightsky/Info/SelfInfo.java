package lu.nightsky.Info;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class SelfInfo extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String message = event.getMessage().getContentRaw();
        if (message.toLowerCase().contains("@")) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "profile")) {

                User user = event.getAuthor();

                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setThumbnail(user.getAvatarUrl());
                info.setTitle("\uD83D\uDCAD NightSky | Profile");
                info.addField("**Name:** ", user.getAsTag(), false);
                info.addField("**ID:** ", user.getId(), false);
                info.addField("**Account Created:** ", user.getTimeCreated().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                info.addField("**Guild Joined:** ", event.getMember().getTimeJoined().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                info.addField("**Status:** ", String.valueOf(event.getMember().getOnlineStatus()), false);
                info.addField("**Hypesquad:** ", String.valueOf(user.getFlags()), false);
                info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                info.setColor(Color.yellow);
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +profile got used by " + event.getAuthor().getName());
            }

    }
}