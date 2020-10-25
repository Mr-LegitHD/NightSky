package lu.nightsky.Moderation;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ClearCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "clear")) {
            TextChannel channel = event.getChannel();
            Member selfMember = event.getGuild().getSelfMember();



            if (!selfMember.hasPermission(Permission.MESSAGE_MANAGE)) {
                channel.sendMessage("I need the `Manage Messages` permission for this command").queue();

                return;
            }
            event.getMessage().delete().queue();
            if (!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                event.getChannel().sendMessage("You need the `Manage Messages` permission to use this command").queue();

                return;
            }


                int amount;
                String arg = args[1];

                try {
                    amount = Integer.parseInt(arg);
                } catch (NumberFormatException ignored) {
                    channel.sendMessageFormat("`%s` is not a valid number", arg).queue();

                    return;
                }

                if (amount < 2 || amount > 100) {
                    channel.sendMessage("Amount must be at least 2 and at most 100").queue();

                    return;
                }

                channel.getIterableHistory()
                        .takeAsync(amount)
                        .thenApplyAsync((messages) -> {
                            List<Message> goodMessages = messages.stream()
                                    .filter((m) -> m.getTimeCreated().isBefore(
                                            OffsetDateTime.now().plus(2, ChronoUnit.WEEKS)
                                    ))
                                    .collect(Collectors.toList());

                            channel.purgeMessages(goodMessages);

                            return goodMessages.size();
                        })
                        .whenCompleteAsync(
                                (count, thr) -> channel.sendMessageFormat("Deleted `%d` messages", count).queue(
                                        (message) -> message.delete().queueAfter(3, TimeUnit.SECONDS)
                                )
                        )
                        .exceptionally((thr) -> {
                            String cause = "";

                            if (thr.getCause() != null) {
                                cause = " caused by: " + thr.getCause().getMessage();
                            }

                            channel.sendMessageFormat("Error: %s%s", thr.getMessage(), cause).queue();

                            return 0;
                        });
            }

        }
    }


