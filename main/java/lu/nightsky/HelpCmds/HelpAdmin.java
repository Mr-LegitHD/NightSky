package lu.nightsky.HelpCmds;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpAdmin extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "admin")) {
            if (args[1].equalsIgnoreCase("help")) {
                if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                    event.getChannel().sendMessage("You need the `Administrator` permission to use this command").queue();

                    return;
                }
                User user = event.getAuthor();
                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\uD83D\uDCAD NightSky | Admin Commands");
                info.addField("**+embed:** ", "Send embeds | +embed <Title> <Text>", false);
                info.addField("**+say:** ", "Send a Message (no Embed)", false);
                info.setColor(Color.blue);
                info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +adminHelp got used by " + event.getAuthor().getName());

            }
        }
    }
}
