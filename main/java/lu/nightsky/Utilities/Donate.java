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
import java.util.List;

public class Donate extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        
        if (event.getAuthor().isBot()) return;
        User user = event.getAuthor();
        List<User> mentionedUsers = event.getMessage().getMentionedUsers();
        //System.out.println(dateFormat.format(newDate) + " Profile Command | Mentioned Users: " + mentionedUsers.size());
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "donate")) {

                    //Embed Builder
                    EmbedBuilder info = new EmbedBuilder();
                    info.setTitle("\uD83D\uDCAD NightSky | Donate <:KannaMoney:778290596942970880> ");
                    info.setDescription("You want to support us with real money? Donate [here](https://donatebot.io/checkout/750815161446694983) and get a reward!");
                    info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    info.setColor(Color.blue);
                    event.getChannel().sendMessage(info.build()).queue();
                    info.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +donate got used by " + event.getAuthor().getName());
        }
    }
}



