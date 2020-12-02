package lu.nightsky.BotEvents;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class GuildJoin extends ListenerAdapter {
    public void onGuildJoin(GuildJoinEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        Guild guild = event.getGuild();

        System.out.println(dateFormat.format(newDate) + " Bot joined to " + guild.getName() +" | " +guild.getId());
    }
}
