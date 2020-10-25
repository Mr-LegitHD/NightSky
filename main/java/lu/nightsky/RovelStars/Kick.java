package lu.nightsky.RovelStars;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Kick extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (event.getAuthor().isBot()) return;
        if (!event.getMember().hasPermission(Permission.KICK_MEMBERS)) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.rovelprefix + "kick")) {
            Message message = event.getMessage();
            List<Member> members = message.getMentionedMembers();
            if (!members.isEmpty()) {
                Member member = members.get(0);
                Guild guild = member.getGuild();
                String id = member.getId();
                member.getGuild().kick(member).queue();
                // User wurde gekickt


            } else {
                // Gebe einen user an
            }
            //Embed Builder
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("Assistant | Kick");
            mute.setDescription("Member " + args[1] + " got kicked by " + event.getAuthor().getAsMention() + "\nReason: " + args[2]);
            mute.setFooter("System");
            mute.setTimestamp(Instant.now());
            mute.setColor(Color.RED);
            event.getGuild().getTextChannelById("741151101243490315").sendMessage(mute.build()).queue();
            mute.clear();
            System.out.println(dateFormat.format(newDate) + " Command -kick got used by " + event.getAuthor().getName());
        }



    }
}


