package lu.nightsky.Utilities;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InviteGenerator extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "invite")) {
            if(!event.getMessage().getContentRaw().toLowerCase().contains("@")) {
                event.getMessage().delete().queue();
                //Embed Builder
                EmbedBuilder mute = new EmbedBuilder();
                mute.setTitle("Error");
                mute.setDescription("You have to Mention a Bot!");
                mute.setFooter("System");
                mute.setTimestamp(Instant.now());
                mute.setColor(Color.RED);
                event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                mute.clear();
                return;
            }

            if (args.length < 2) {
                event.getMessage().delete().queue();
                //Embed Builder
                EmbedBuilder mute = new EmbedBuilder();
                mute.setTitle("Error");
                mute.setDescription("Correct Usage: +invite <@Bot>");
                mute.setFooter("System");
                mute.setTimestamp(Instant.now());
                mute.setColor(Color.RED);
                event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                mute.clear();
                return;
            }

                User user = event.getAuthor();
            List<User> mentionedUsers = event.getMessage().getMentionedUsers();
            if(mentionedUsers.size() > 0) {
                User userTarget = mentionedUsers.get(0);
                if (!userTarget.isBot()){
                    event.getMessage().delete().queue();
                    //Embed Builder
                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("Error");
                    mute.setDescription("You have to Mention a Bot!");
                    mute.setFooter("System");
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.RED);
                    event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                    mute.clear();
                    return;

                }
                event.getGuild().retrieveMember(userTarget).queue(member -> {
                    //Embed Builder
                    EmbedBuilder info = new EmbedBuilder();
                    info.setTitle("\uD83D\uDCAD NightSky | Invite ");
                    info.addField("<:link:777630858857021440> **Invite Link for** " + userTarget.getName(), "[Click here](https://discord.com/oauth2/authorize?client_id="+userTarget.getId()+"&scope=bot&permissions=0)", false);
                    info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    info.setColor(Color.blue);
                    event.getChannel().sendMessage(info.build()).queue();
                    info.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +invite got used by " + event.getAuthor().getName());

                });
            }
        }
    }
}
