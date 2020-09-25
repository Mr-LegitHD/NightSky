package lu.nightsky.Automod;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AntiInvite extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        if(event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) return;
        String message = event.getMessage().getContentRaw();
        if(message.toLowerCase().contains("https://discord.gg/")) {
            event.getMessage().delete().queue();
        }

    }
}

