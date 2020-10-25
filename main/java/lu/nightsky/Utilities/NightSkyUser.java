package lu.nightsky.Utilities;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NightSkyUser extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
                String[] args = event.getMessage().getContentRaw().split("\\s+");
                if (args[0].equalsIgnoreCase(Secrets.prefix + "nightskyuser")) {

                    Message message = event.getMessage();
                    List<Member> members = message.getMentionedMembers();
                    event.getMessage().delete().queue();
                    if (!members.isEmpty()) {
                        Member member = (Member) members.get(0);
                        Guild guild = member.getGuild();
                        Role role = guild.getRoleById("754805019907457024");
                        member.getGuild().addRoleToMember(member, role).queue((unused) -> {
                        });
                    }
                    event.getChannel().sendMessage("Added "+args[1]+" as @NightSky User").queue();
                    System.out.println(dateFormat.format(newDate) + " Command +nightskyuser got used by " + event.getAuthor().getName());

                }

    }
}











