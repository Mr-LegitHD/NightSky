package lu.nightsky.Utilities;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Couting extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        final TextChannel channel = event.getChannel();
        if (channel.getId().equals("752811330133557298")) {
            final Message message = event.getMessage();

            channel.getHistory().retrievePast(2)
                    .map(messages -> messages.get(1))
                    .queue(msg -> {
                        try {
                            final int a = Integer.parseInt(message.getContentRaw());
                            final int b = Integer.parseInt(msg.getContentRaw());
                            if (message.getAuthor().equals(msg.getAuthor()))
                                message.delete().queue();
                            if (a != b + 1)
                                message.delete().queue();
                        } catch (NumberFormatException e) {
                            message.delete().queue();
                            e.fillInStackTrace();
                        }
                    });
        }
    }
}



