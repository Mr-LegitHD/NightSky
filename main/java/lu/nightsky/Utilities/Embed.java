package lu.nightsky.Utilities;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Embed extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        if(!event.getMember().hasPermission(Permission.ADMINISTRATOR)) return;
        String[] args = event.getMessage().getContentRaw().split(" ");

        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();

        if (args[0].equalsIgnoreCase(Secrets.prefix + "embed")) {

            int argumenteLength = args.length;
            String message = "";
            for (int i = 0; i < argumenteLength; i++){
                message = message + args[i] + " ";
            }
            String finalMessage = message.replace(args[0] + " " + args[1] + " ", "");

            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle(args[1]);
            info.setDescription(finalMessage);
            info.setColor(Color.orange);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +embed got used by "+ event.getAuthor().getName());
        }
    }
}
