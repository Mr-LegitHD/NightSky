package lu.nightsky.BotSelf;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vote extends ListenerAdapter {

        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
            String[] args = event.getMessage().getContentRaw().split("\\s+");
            DateFormat dateFormat = new SimpleDateFormat("[H:m]");
            Date newDate = new Date();
            if(event.getAuthor().isBot()) return;
            if (args[0].equalsIgnoreCase(Secrets.prefix + "vote")) {
                User user = event.getAuthor();

                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\uD83D\uDCAD NightSky | Vote");
                info.setDescription("Support us with a [Vote](https://top.gg/bot/750778627565682798/vote)");
                info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                info.setColor(new Color(14,24,45));
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) +" Command +vote got used by "+ event.getAuthor().getName());
            }
        }
    }


