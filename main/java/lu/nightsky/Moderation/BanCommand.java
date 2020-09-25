package lu.nightsky.Moderation;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BanCommand extends ListenerAdapter {
    public BanCommand() {
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (!event.getAuthor().isBot()) {
            if (event.getMember().hasPermission(new Permission[]{Permission.BAN_MEMBERS})) {
                String[] args = event.getMessage().getContentRaw().split("\\s+");
                if (args[0].equalsIgnoreCase(Secrets.prefix + "ban")) {
                    String query = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 2, args.length));
                    Message message = event.getMessage();
                    List<Member> members = message.getMentionedMembers();
                    event.getMessage().delete().queue();
                    if (!members.isEmpty()) {
                        Member member = (Member)members.get(0);
                        event.getGuild().ban(member, 0).queue();
                    }

                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("\ud83d\udcad NightSky | Ban");
                    mute.setDescription("Member " + args[1] + " got banned by " + event.getAuthor().getAsMention() + "\nReason: " + query);
                    mute.setFooter("NightSky " + Secrets.version);
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.RED);
                    event.getChannel().sendMessage(mute.build()).queue();
                    mute.clear();
                    System.out.println(dateFormat.format(newDate) + " Command +ban got used by " + event.getAuthor().getName());
                }

            }
        }
    }
}
