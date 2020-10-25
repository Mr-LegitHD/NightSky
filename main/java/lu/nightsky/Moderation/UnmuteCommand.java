package lu.nightsky.Moderation;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UnmuteCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (event.getAuthor().isBot()) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "unmute")) {
            TextChannel channel1 = event.getChannel();
            Member selfMember = event.getGuild().getSelfMember();


            if (!selfMember.hasPermission(Permission.MESSAGE_MANAGE)) {
                channel1.sendMessage("I need the `Manage Messages` permission for this command").queue();

                return;
            }
            if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                event.getChannel().sendMessage("You need the `Manage Messages` permission to use this command").queue();

                return;
            }
            if (args.length < 2) {
                event.getMessage().delete().queue();
                //Embed Builder
                EmbedBuilder mute = new EmbedBuilder();
                mute.setTitle("Error");
                mute.setDescription("Correct Usage: +unmute <@user>");
                mute.setFooter("System");
                mute.setTimestamp(Instant.now());
                mute.setColor(Color.RED);
                event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                mute.clear();
            }

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
            List<User> mentionedUsers = event.getMessage().getMentionedUsers();
            System.out.println(dateFormat.format(newDate) + " Profile Command | Mentioned Users: " + mentionedUsers.size());
            if (mentionedUsers.size() > 0) {
                User userTarget = mentionedUsers.get(0);
                event.getGuild().retrieveMember(userTarget).queue(member -> {
                    userTarget.openPrivateChannel().queue((channel) -> {
                        channel.sendMessage("**You got unmuted on " + event.getGuild().getName() +"!**").queue();
                    });
                });
            }
        }

    }
}
