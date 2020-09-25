package lu.nightsky.Automod;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Blacklist extends ListenerAdapter {
    private static final String[] Blacklist = {"wixxer", "wichser", "nigga", "nega", "niga", "spaco", "negger", "neger", "spako", "negga", "ni ga", "n*igga", "ni**a", "nig*a", "bastard", "bitch","b*tch"};
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        String message = event.getMessage().getContentRaw().toLowerCase();
        for(String blacklist : Blacklist) {
            //check if the message contains it
            if(message.contains(blacklist)) {
                event.getMessage().delete().queue();
                return;
            }
        }
    }
}

