package lu.nightsky.Info;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class InfosCommand extends ListenerAdapter {
    public static JDA jda;


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        int users = 0;
        for (Guild guild : event.getJDA().getGuilds()) {
            users = users + guild.getMemberCount();
        }
        final int serverUsers = users;
        Member selfMember = event.getGuild().getSelfMember();
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();

        if (args[0].equalsIgnoreCase(Secrets.prefix + "infos")) {
            User user = event.getAuthor();

            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\uD83D\uDCAD NightSky | Informations");
            info.setDescription("**Bot-Dev**: Mr_Legit HD#3358 \n**Library**: JDA \n**Version**: " + Secrets.version + "\n**Prefix**: + \n**Users**: " + serverUsers + "\n**Servers**: " + event.getJDA().getGuilds().size());
            info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
            info.setColor(Color.green);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +infos got used by "+ event.getAuthor().getName());


        }


    }
}
