package lu.nightsky.HelpCmds;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpMod extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (args[0].equalsIgnoreCase(Secrets.prefix + "mod")) {
            if (args[1].equalsIgnoreCase("help")) {
                if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                    event.getChannel().sendMessage("You need the `Manage Messages` permission to use this command").queue();

                    return;
                }
                User user = event.getAuthor();


                //Embed Builder
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("\uD83D\uDCAD NightSky | Mod Commands");
                info.addField("**+ban:** ", "+ban <@Member> <Reason>", false);
                info.addField("**+kick:** ", "+kick <@Member> <Reason>", false);
                info.addField("**+mute:** ", "+mute <@Member> <Reason> (need @muted role)", false);
                info.addField("**+unmute:** ", "+unmute <@Member>", false);
                info.addField("**+clear:** ", "+clear Clear an number of Message", false);
                info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                info.setColor(Color.blue);
                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
                event.getMessage().delete().queue();
                System.out.println(dateFormat.format(newDate) + " Command +help mod got used by " + event.getAuthor().getName());
            }
        }
    }
}
