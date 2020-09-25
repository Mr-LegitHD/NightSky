package lu.nightsky.Utilities;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.jws.soap.SOAPBinding;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Ticket extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if (event.getAuthor().isBot()) return;
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Secrets.prefix + "ticket")) {
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) + " Command +ticket got used by " + event.getAuthor().getName());
            User user = event.getAuthor();

            //Send Direct Message
            user.openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage("Hello, as we can see you've found a bug in the Night Sky Bot. Please report it here and you might even get a little reward\n" +
                    "\nhttps://www.gino-cicci.social/Bugs.html").queue();
        });
        }
    }
    }
