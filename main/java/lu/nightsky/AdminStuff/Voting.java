package lu.nightsky.AdminStuff;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Voting extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        if(!event.getMember().hasPermission(Permission.ADMINISTRATOR)) return;
        String[] args = event.getMessage().getContentRaw().split(" ");

        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();

        if (args[0].equalsIgnoreCase(Secrets.prefix + "voting")) {

            int argumenteLength = args.length;
            String message = "";
            for (int i = 0; i < argumenteLength; i++){
                message = message + args[i] + " ";
            }
            String finalMessage = message.replace(args[0] + " ",  " ");

            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\ud83d\udcad **Voting-Event** ");
            info.setDescription(finalMessage);
            info.setColor(new Color(0,247,247));
            info.setFooter("Voting by "+event.getMember().getUser().getAsTag() + " | NightSky " + Secrets.version, event.getMember().getUser().getAvatarUrl());
            event.getChannel().sendMessage(info.build()).queue(message1 -> {
                message1.addReaction(":upvote:767349104728211517").queue();
                message1.addReaction(":downvote:767349118418288640").queue();
            });
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +voting got used by "+ event.getAuthor().getName());
        }
    }
}
