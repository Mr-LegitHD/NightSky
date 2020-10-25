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

public class Instagram extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User author = event.getAuthor();
        final TextChannel channel = event.getChannel();
        if (event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "instagram")) {

            WebUtils.ins.getJSONObject("https://apis.duncte123.me/insta/"+args[1]).async((json) -> {
                if (!json.get("success").asBoolean()) {
                    channel.sendMessage("Something went wrong, try again later").queue();
                    System.out.println(json);
                    return;
                }

                final JsonNode user = json.get("user");
                final String username = user.get("username").asText();
                final String full_name = user.get("full_name").asText();
                final String pfp = user.get("profile_pic_url").asText();
                final String biography = user.get("biography").asText();
                final boolean isPrivate = user.get("is_private").asBoolean();
                final int following = user.get("following").get("count").asInt();
                final int followers = user.get("followers").get("count").asInt();
                final int uploads = user.get("uploads").get("count").asInt();

                final EmbedBuilder embed = EmbedUtils.defaultEmbed();

                String Accoutnlink = "https://www.instagram.com/"+args[1];
                //Embed Builder
                embed.setTitle("Instagram");
                embed.setThumbnail(pfp);
                embed.addField("**Username**",username,false);
                embed.addField("**Full Name**",full_name,false);
                embed.addField("**isPrivate**", String.valueOf(isPrivate),false);
                embed.addField("**Biography**",biography,false);
                embed.addField("**Followers**", String.valueOf(followers),false);
                embed.addField("**Following**", String.valueOf(following),false);
                embed.addField("**Link**", "[Click here]("+Accoutnlink+")",false);
                embed.setFooter(author.getAsTag() + " | NightSky " + Secrets.version, author.getAvatarUrl());
                embed.setColor(new Color(250,250,250));
                event.getChannel().sendMessage(embed.build()).queue();
                embed.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +instagram got used by " + event.getAuthor().getName());
            });
        }
    }
}

