package lu.nightsky.Moderation;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UnmuteCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (event.getAuthor().isBot()) return;
        if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "unmute")) {
            Message message = event.getMessage();
            List<Member> members = message.getMentionedMembers();
            event.getMessage().delete().queue();
            if (!members.isEmpty()) {
                Member member = members.get(0);
                Guild guild = member.getGuild();
                Role role = guild.getRolesByName("muted", true).get(0);
                member.getGuild().removeRoleFromMember(member, role).queue(unused -> {
                    // Rolle wurde genommen
                });

            } else {
                // Gebe einen user an
            }
            //Embed Builder
            EmbedBuilder mute = new EmbedBuilder();
            mute.setTitle("\uD83D\uDCAD NightSky | Unmute");
            mute.setDescription("Member " + args[1] + " got unmuted by " + event.getAuthor().getAsMention());
            mute.setFooter("NightSky " + Secrets.version);
            mute.setColor(Color.green);
            event.getChannel().sendMessage(mute.build()).queue();
            mute.clear();
            System.out.println(dateFormat.format(newDate) + " Command -unmute got used by " + event.getAuthor().getName());
        }

    }
}
