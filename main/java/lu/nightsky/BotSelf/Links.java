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

public class Links extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if(event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "links")) {
            User user = event.getAuthor();

            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\uD83D\uDCAD NightSky | Links");
            info.setDescription("\n[Premium](https://www.patreon.com/nightsky_bot/membership) \n[Support Server](https://discord.gg/xgsdDXq) \n[Community Server](https://discord.gg/FSYHuHn7Xh)\n[Invite Bot](https://discord.com/oauth2/authorize?client_id=750778627565682798&scope=bot&permissions=268463110) \n[Vote](https://top.gg/bot/750778627565682798/vote) \n[Website](https://www.universe-network.site/) \n[Donate](https://www.tipeeestream.com/mr-legit/donation) \n[Bug Report](https://forms.gle/DbBYHvpkx5qoeUNd8) \n[Twitter](https://twitter.com/NightSkyBot_)");
            info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
            info.setColor(Color.blue);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +links got used by "+ event.getAuthor().getName());
        }
    }
}
