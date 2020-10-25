package lu.nightsky.Automod;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Blacklist extends ListenerAdapter {
    private static final String[] Blacklist = {"nigga", "nega", "niga", "negger", "neger", "negga", "ni ga", "n*igga", "ni**a", "nig*a"};
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        String message = event.getMessage().getContentRaw().toLowerCase();
        for(String blacklist : Blacklist) {
            if(message.contains(blacklist)) {
                event.getMessage().delete().queue();

                return;
            }
        }
    }
}

