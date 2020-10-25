package lu.nightsky.HelpCmds;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpMusik extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "music")) {
            if (args[1].equalsIgnoreCase("help")) {
                User user = event.getAuthor();
                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\uD83D\uDCAD NightSky | Music Commands");
                info.addField("**+join:** ", "Join your current voicechannel", false);
                info.addField("**+play:** ", "Play music | +play <Songname>", false);
                info.addField("**+stop:** ", "Stop playing music", false);
                info.addField("**+leave:** ", "Leave your current voicechannel", false);
                info.addField("**+skip:** ", "Skip the current song", false);
                info.addField("**+pause:** ", "Pause the current song", false);
                info.addField("**+continue:** ", "Continue the current song", false);
                info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                info.setColor(Color.blue);
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +FunHelp got used by " + event.getAuthor().getName());

            }
        }
    }
}
