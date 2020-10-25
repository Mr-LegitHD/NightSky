package lu.nightsky.Utilities;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Couting extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel textChannel = event.getTextChannel();
        if (!textChannel.getId().equals("769883347601981451")) return;
        textChannel.retrieveMessageById(textChannel.getLatestMessageId()).queue(message -> {
            String lastMessageAsString = message.getContentRaw();
            if (lastMessageAsString.matches("-?(0|[1-9]\\d*)")) {
                String currentInput = event.getMessage().getContentRaw();
                if (currentInput.matches("-?(0|[1-9]\\d*)")) {
                    int lastNumber = Integer.parseInt(lastMessageAsString);
                    int inputNumber = Integer.parseInt(currentInput);
                    if (inputNumber != (lastNumber + 1)) {
                        event.getMessage().delete().queue();
                    }
                } else {
                    event.getMessage().delete().queue();
                }
            } else {
                event.getMessage().delete().queue();
            }
        });
    }
}




