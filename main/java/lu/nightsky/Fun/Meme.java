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

public class Meme extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
            DateFormat dateFormat = new SimpleDateFormat("[H:m]");
            Date newDate = new Date();
            User user = event.getAuthor();
            if (event.getAuthor().isBot()) return;
            if (args[0].equalsIgnoreCase(Secrets.prefix + "meme")) {
                final TextChannel channel = event.getChannel();
                WebUtils.ins.getJSONObject("https://apis.duncte123.me/meme").async((json) -> {
                    if (!json.get("success").asBoolean()) {
                        channel.sendMessage("Something went wrong, try again later").queue();
                        System.out.println(json);
                        return;
                    }

                    final JsonNode data = json.get("data");
                    final String title = data.get("title").asText();
                    final String url = data.get("url").asText();
                    final String image = data.get("image").asText();
                    final EmbedBuilder embed = EmbedUtils.embedImageWithTitle(title, url, image);

                    //Embed Builder
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255,106,51));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +meme got used by " + event.getAuthor().getName());

                });
            }







            }
        }



