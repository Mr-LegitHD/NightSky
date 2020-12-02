package lu.nightsky.Game;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class List extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (event.getAuthor().isBot()) return;
        User user = event.getAuthor();
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "gamelist")) {

                    //Embed Builder
                    EmbedBuilder info = new EmbedBuilder();
                    info.setAuthor("Please use the bold Game Names");
                    info.setTitle("\uD83D\uDCAD NightSky | All available Games for the Playercount ");
                    info.addField("**ARK**","Ark Survival Evoled",false);
                    info.addField("**CSGO**","Counter Strike",false);
                    info.addField("**Among US**","Among US",false);
                    info.addField("**GTA5**","Grand theft Auto 5",false);
                    info.addField("**Apex Legends**","Apex Legends",false);
                    info.addField("**Destiny 2**","Destiny 2",false);
                    info.addField("**Rocket League**","Rocket League",false);
                    info.addField("**PUBG**","Playerunknown's Battlegrounds",false);
                    info.addField("**Team Fortress 2**","Team Fortress 2",false);
                    info.addField("**Dota 2**","Dota 2",false);
                    info.addField("**Fallout 4**","Fallout 4",false);
                    info.addField("**Hitman 2**","Hitman 2",false);
                    info.addField("**R6**","Tom Clancy's Rainbow Six Siege",false);
                    info.addField("**Journey**","Journey",false);
                    info.addField("**Clustertruck**","Clustertruck",false);
                    info.addField("**World of Tanks Blitz**","World of Tanks Blitz",false);
                    info.addField("**Call of Duty: Black Ops III**","Call of Duty: Black Ops III",false);
                    info.addField("**Minecraft Story Mode**","Minecraft: Story Mode - A Telltale Games Series",false);
                    info.addField("**Want to add a Game? **","Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)",false);
                    info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    info.setColor(Color.blue);
                    event.getChannel().sendMessage(info.build()).queue();
                    info.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +gamelist got used by " + event.getAuthor().getName());
        }
    }
}



