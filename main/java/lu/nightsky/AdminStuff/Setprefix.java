package lu.nightsky.AdminStuff;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Setprefix extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String query = String.join("", (CharSequence[])Arrays.copyOfRange(args, 1, args.length));
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User author = event.getAuthor();
        final TextChannel channel = event.getChannel();
        final Member member = event.getMember();
        if (event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "setprefix")) {


            if (!member.hasPermission(Permission.MANAGE_SERVER)) {
                channel.sendMessage("You must have the Manage Server permission to use his command").queue();
                return;
            }

            if (args[1].length() == 0) {
                channel.sendMessage("Missing args").queue();
                return;
            }

            final String newPrefix = String.join("", args);
            VeryBadDesign.PREFIXES.put(event.getGuild().getIdLong(), newPrefix);

            channel.sendMessageFormat("New prefix has been set to `%s`", newPrefix).queue();



            }
        }
    }

