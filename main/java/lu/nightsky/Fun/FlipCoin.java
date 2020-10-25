package lu.nightsky.Fun;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class FlipCoin extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (event.getAuthor().isBot()) return;
        String[] coinflip = {"skull \uD83D\uDC80", "coin :coin:"};
        Random random = new Random();
        User user = event.getAuthor();


                    int number = random.nextInt(coinflip.length);
                    String[] args = event.getMessage().getContentRaw().split("\\s+");
                    if (args[0].equalsIgnoreCase(Secrets.prefix + "coinflip")) {
                        event.getChannel().sendMessage("Flipping...").queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                        //Embed Builder
                        EmbedBuilder embed = new EmbedBuilder();
                        embed.setTitle("\uD83D\uDCAD Coinflip Result");
                        embed.addField(" ","**"+user.getName()+ "** flipped a coin\n and got **" + coinflip[number]+"**", false);
                        embed.setThumbnail("https://i.imgur.com/13yJ1ul.png");
                        embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                        embed.setColor(Color.yellow);
                        event.getChannel().sendMessage(embed.build()).queueAfter(3, TimeUnit.SECONDS);
                        event.getMessage().delete().queueAfter(4,TimeUnit.DAYS);
                        embed.clear();
                        event.getMessage().delete().queue();
                        System.out.println(dateFormat.format(newDate) + " Command +coinflip got used by " + event.getAuthor().getName());

                    }
    }
}



