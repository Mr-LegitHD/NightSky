package lu.nightsky.Moderation;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class KickCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (!event.getAuthor().isBot()) {
                String[] args = event.getMessage().getContentRaw().split("\\s+");
                if (args[0].equalsIgnoreCase(Secrets.prefix + "kick")) {
                    TextChannel channel = event.getChannel();
                    Member member = event.getMember();
                    Member selfMember = event.getGuild().getSelfMember();


                    if (!selfMember.hasPermission(Permission.KICK_MEMBERS)) {
                        channel.sendMessage("I need the `Kick Members` permission for this command").queue();

                        return;
                    }
                    if (!event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
                        event.getChannel().sendMessage("You need the `Kick Members` permission to use this command").queue();

                        return;
                    }
                    if (args.length < 2) {
                        event.getMessage().delete().queue();
                        //Embed Builder
                        EmbedBuilder mute = new EmbedBuilder();
                        mute.setTitle("Error");
                        mute.setDescription("Correct Usage: +kick <@user> <Reason>");
                        mute.setFooter("System");
                        mute.setTimestamp(Instant.now());
                        mute.setColor(Color.RED);
                        event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                        mute.clear();
                    } else
                    if (args.length < 3) {
                        event.getMessage().delete().queue();
                        //Embed Builder
                        EmbedBuilder mute = new EmbedBuilder();
                        mute.setTitle("Error");
                        mute.setDescription("Correct Usage: +kick <@user> <Reason>");
                        mute.setFooter("System");
                        mute.setTimestamp(Instant.now());
                        mute.setColor(Color.RED);
                        event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                        mute.clear();
                        return;
                    }
                    String query = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 2, args.length));
                    Message message = event.getMessage();
                    List<Member> members = message.getMentionedMembers();
                    event.getMessage().delete().queue();
                    if (!members.isEmpty()) {
                        Member member1 = (Member)members.get(0);
                        member.getGuild().kick(member1).queue();
                    }

                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("\ud83d\udcad NightSky | Kick");
                    mute.setDescription("Member " + args[1] + " got kicked by " + event.getAuthor().getAsMention() + "\nReason: " + query);
                    mute.setFooter("NightSky " + Secrets.version);
                    mute.setTimestamp(Instant.now());
                    mute.setColor(Color.RED);
                    event.getChannel().sendMessage(mute.build()).queue();
                    mute.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +kick got used by " + event.getAuthor().getName());
                }

            }
        }
    }

