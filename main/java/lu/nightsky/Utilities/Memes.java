package lu.nightsky.Utilities;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Memes extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
            DateFormat dateFormat = new SimpleDateFormat("[H:m]");
            Date newDate = new Date();
            if (event.getAuthor().isBot()) return;
            if (args[0].equalsIgnoreCase(Secrets.prefix + "memes")) {
                User user = event.getAuthor();
                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\uD83D\uDCAD NightSky | Memes");
                info.setDescription("[DankMemes](https://www.reddit.com/r/dankmemes/)");
                info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                info.setImage("https://www.oxfordstudent.com/wp-content/uploads/2016/05/The_meme_formerly_known_as_Kuk.png");
                info.setColor(new Color(240, 255, 255));
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +memes got used by " + event.getAuthor().getName());
            }
        }
    }

