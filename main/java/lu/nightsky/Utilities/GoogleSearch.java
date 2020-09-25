package lu.nightsky.Utilities;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GoogleSearch extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            String[] args = event.getMessage().getContentRaw().split(" ");
            DateFormat dateFormat = new SimpleDateFormat("[H:m]");
            Date newDate = new Date();
            User user = event.getAuthor();
            if (args[0].equalsIgnoreCase(Secrets.prefix + "search")) {
                String googleSearchUrl = "https://www.google.de/search?q=";
                String query = String.join("+", (CharSequence[])Arrays.copyOfRange(args, 1, args.length));
                String result = googleSearchUrl + query;
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\ud83d\udcad NightSky | Search");
                info.setDescription("[" + query + "](" + result + ")");
                info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                info.setColor(new Color(240, 255, 255));
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +search got used by " + event.getAuthor().getName());
            }

        }
    }
}
