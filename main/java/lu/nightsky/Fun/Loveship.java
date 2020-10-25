package lu.nightsky.Fun;

import com.fasterxml.jackson.databind.JsonNode;
import lu.nightsky.Privat.Secrets;
import me.duncte123.botcommons.messaging.EmbedUtils;
import me.duncte123.botcommons.web.WebUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loveship extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User user = event.getAuthor();
        final TextChannel channel = event.getChannel();
        if (event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "love")) {

            WebUtils.ins.getJSONObject("https://apis.duncte123.me/love/"+args[1]+"/"+args[2]).async((json) -> {
                if (!json.get("success").asBoolean()) {
                    channel.sendMessage("Something went wrong, try again later").queue();
                    System.out.println(json);
                    return;
                }

                final JsonNode data = json.get("data");
                final String names = data.get("names").asText();
                final String score = data.get("score").asText();
                final String message = data.get("message").asText();

                final EmbedBuilder embed = EmbedUtils.defaultEmbed();

                //Embed Builder
                embed.setTitle("Love Match \uD83D\uDC95");
                embed.addField("**Names**",names,false);
                embed.addField("**Score**",score,false);
                embed.addField("",message,false);
                embed.setThumbnail("https://i.imgur.com/yQ7bCt4.png");
                embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                embed.setColor(new Color(180,2,146));
                event.getChannel().sendMessage(embed.build()).queue();
                embed.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +love got used by " + event.getAuthor().getName());
            });
        }
    }
}

