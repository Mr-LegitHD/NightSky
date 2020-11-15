package lu.nightsky.Info;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Userinfo extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (args[0].equalsIgnoreCase(Secrets.prefix + "profile")) {

            User user = event.getAuthor();

            List<User> mentionedUsers = event.getMessage().getMentionedUsers();


            if(mentionedUsers.size() > 0) {
                User userTarget = mentionedUsers.get(0);
                event.getGuild().retrieveMember(userTarget).queue(member -> {

                    //Embed Builder
                    EmbedBuilder info = new EmbedBuilder();
                    info.setThumbnail(userTarget.getAvatarUrl());
                    info.setTitle("\uD83D\uDCAD NightSky | Profile");
                    info.addField("**Name:** ", userTarget.getName(), false);
                    info.addField("**ID:** ", userTarget.getId(), false);
                    info.addField("**Account Created:** ", userTarget.getTimeCreated().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                    info.addField("**Guild Joined:** ", member.getTimeJoined().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
                    info.addField("**Badges:** ", String.valueOf(userTarget.getFlags()), false);
                    info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    info.setColor(Color.yellow);
                    event.getChannel().sendMessage(info.build()).queue();
                    info.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +profile got used by " + event.getAuthor().getName());
                });
            } else {

            }
        }
    }
}
