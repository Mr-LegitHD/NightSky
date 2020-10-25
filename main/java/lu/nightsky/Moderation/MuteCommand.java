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
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MuteCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (!event.getAuthor().isBot()) {
                String[] args = event.getMessage().getContentRaw().split("\\s+");
                if (args[0].equalsIgnoreCase(Secrets.prefix + "mute")) {
                    TextChannel channel1 = event.getChannel();
                    Member member2 = event.getMember();
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
                        mute.setDescription("Correct Usage: +mute <@user> <Reason>");
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
                        mute.setDescription("Correct Usage: +mute <@user> <Reason>");
                        mute.setFooter("System");
                        mute.setTimestamp(Instant.now());
                        mute.setColor(Color.RED);
                        event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                        mute.clear();
                        return;
                    }

                    String query = String.join(" ", (CharSequence[]) Arrays.copyOfRange(args, 2, args.length));
                    Message message = event.getMessage();
                    List<Member> members = message.getMentionedMembers();
                    event.getMessage().delete().queue();
                    if (!members.isEmpty()) {
                        Member member = (Member) members.get(0);
                        Guild guild = member.getGuild();
                        Role role = (Role) guild.getRolesByName("muted", true).get(0);
                        member.getGuild().addRoleToMember(member, role).queue((unused) -> {
                        });
                    }
                    //Mute
                    EmbedBuilder mute = new EmbedBuilder();
                    mute.setTitle("\ud83d\udcad NightSky | Mute");
                    mute.setDescription("Member " + args[1] + " got muted by " + event.getAuthor().getAsMention() + "\nReason: " + query);
                    mute.setFooter("NightSky " + Secrets.version);
                    mute.setColor(Color.RED);
                    event.getChannel().sendMessage(mute.build()).queue();
                    mute.clear();
                    System.out.println(dateFormat.format(newDate) + " Command -mute got used by " + event.getAuthor().getName());

                    List<User> mentionedUsers = event.getMessage().getMentionedUsers();
                    System.out.println(dateFormat.format(newDate) + " Profile Command | Mentioned Users: " + mentionedUsers.size());
                    if (mentionedUsers.size() > 0) {
                        User userTarget = mentionedUsers.get(0);
                        event.getGuild().retrieveMember(userTarget).queue(member -> {
                            userTarget.openPrivateChannel().queue((channel) -> {
                                channel.sendMessage("**You got muted on " + event.getGuild().getName() +" for "+query+"!**").queue();
                            });
                        });
                    }
                }
            }
        }
    }










