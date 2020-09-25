package lu.nightsky.Moderation;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MuteCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (!event.getAuthor().isBot()) {
            if (event.getMember().hasPermission(new Permission[]{Permission.MESSAGE_MANAGE})) {
                String[] args = event.getMessage().getContentRaw().split("\\s+");
                if (args[0].equalsIgnoreCase(Secrets.prefix + "mute")) {
                    String query = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 2, args.length));
                    Message message = event.getMessage();
                    List<Member> members = message.getMentionedMembers();
                    event.getMessage().delete().queue();
                    if (!members.isEmpty()) {
                        Member member = (Member)members.get(0);
                        Guild guild = member.getGuild();
                        Role role = (Role)guild.getRolesByName("muted", true).get(0);
                        member.getGuild().addRoleToMember(member, role).queue((unused) -> {
                        });
                    }

                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("\ud83d\udcad NightSky | Mute");
                    mute.setDescription("Member " + args[1] + " got muted by " + event.getAuthor().getAsMention() + "\nReason: " + query);
                    mute.setFooter("NightSky " + Secrets.version);
                    mute.setColor(Color.RED);
                    event.getChannel().sendMessage(mute.build()).queue();
                    mute.clear();
                    System.out.println(dateFormat.format(newDate) + " Command -mute got used by " + event.getAuthor().getName());
                }

            }
        }
    }
}
