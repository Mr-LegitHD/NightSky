package lu.nightsky.Info;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import sun.misc.Version;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Serverinfo extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (args[0].equalsIgnoreCase(Secrets.prefix + "serverinfo")) {
            Guild guild = event.getGuild();
            User user = event.getAuthor();


            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setThumbnail(guild.getIconUrl());
            info.setTitle("\uD83D\uDCAD NightSky | Serverinfo");
            info.addField("**Name:** ",guild.getName(), false);
            info.addField("**Owner:** ","<@"+guild.getOwnerId()+">", false);
            info.addField("**ID:** ",guild.getId(), false);
            info.addField("**Region:** ",guild.getRegion().getName(), false);
            info.addField("**Members:** ",guild.getMemberCount() + " ", false);
            info.addField("**Categories:** ", String.valueOf(guild.getCategories().size()), false);
            info.addField("**Channels**: ", String.valueOf(guild.getChannels().size()), false);
            info.addField("**Roles:** ", String.valueOf(guild.getRoles().size()), false);
            info.addField("**Emotes:** ", String.valueOf(guild.getEmotes().size()), false);
            info.addField("**Boostercount:** ", String.valueOf(guild.getBoostCount()), false);
            info.addField("**Verification Level:** ", String.valueOf(guild.getVerificationLevel()), false);
            info.addField("**Created at:** ", guild.getTimeCreated().format(DateTimeFormatter.RFC_1123_DATE_TIME), false);
            info.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
            info.setColor(Color.yellow);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +serverinfo got used by "+ event.getAuthor().getName());

        }

    }
}
