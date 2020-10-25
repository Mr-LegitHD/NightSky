package lu.nightsky.Utilities;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Couting extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel textChannel = event.getTextChannel();
        if (!textChannel.getId().equals("769883347601981451")) return;
        MessageHistory history = new MessageHistory(textChannel);
        List<Message> msgs = history.retrievePast(1).complete();
        Message previousMsg = msgs.get(0);
        String lastMessageAsString = previousMsg.getContentRaw();
        if (lastMessageAsString.chars().allMatch( Character::isDigit )) {
            String currentInput = event.getMessage().getContentRaw();
            if (currentInput.chars().allMatch( Character::isDigit )) {
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
    }
}



