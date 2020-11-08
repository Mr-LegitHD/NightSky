package lu.nightsky.Fun;

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
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Avatar extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        
        if (event.getAuthor().isBot()) return;
        User user = event.getAuthor();
        List<User> mentionedUsers = event.getMessage().getMentionedUsers();
        //System.out.println(dateFormat.format(newDate) + " Profile Command | Mentioned Users: " + mentionedUsers.size());
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "avatar")) {

            if (mentionedUsers.size() > 0) {
                User userTarget = mentionedUsers.get(0);
                event.getGuild().retrieveMember(userTarget).queue(member -> {

                    //Embed Builder
                    EmbedBuilder info = new EmbedBuilder();
                    info.setTitle("\uD83D\uDCAD NightSky | Avatar");
                    info.setImage(userTarget.getAvatarUrl());
                    info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    info.setColor(Color.white);
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



