package lu.nightsky.Utilities;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class FlipCoin extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (event.getAuthor().isBot()) return;
        String[] coinflip = {"skull", "coin"};
        Random random = new Random();
        int number = random.nextInt(coinflip.length);
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "coinflip")) {

            event.getChannel().sendMessage(coinflip[number]).queue();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) + " Command +coinflip got used by " + event.getAuthor().getName());
        }
    }
}

