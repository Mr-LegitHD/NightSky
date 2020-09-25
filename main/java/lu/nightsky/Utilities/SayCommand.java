package lu.nightsky.Utilities;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SayCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) return;
        String[] args = event.getMessage().getContentRaw().split(" ");

        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();

        if (args[0].equalsIgnoreCase(Secrets.prefix + "say")) {

            int argumenteLength = args.length;
            String message = "";
            for (int i = 0; i < argumenteLength; i++) {
                message = message + args[i] + " ";
            }
            String finalMessage = message.replace(args[0] + " ",  " ");

            event.getChannel().sendMessage(finalMessage).queue();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) + " Command +say got used by " + event.getAuthor().getName());
        }
    }
}
