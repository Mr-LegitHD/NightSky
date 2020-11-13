package lu.nightsky.BotSelf;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hosting extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        if(event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "hosting")) {
            User user = event.getAuthor();

            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\uD83D\uDCAD NightSky | Hosting");
            info.addField("**Server**","KVM-1", true);
            info.addField("**Memory**","2 GB ECC REG RAM", true);
            info.addField("**CPU**","1x Intel Xeon E5", true);
            info.addField("**Affilte Link to support us <:cookieboy:775762536128970793> **","[KernelHost](https://www.kernelhost.de/cp/aff.php?aff=9)", true);
            info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
            info.setColor(new Color(40,143,235));
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +hosting got used by "+ event.getAuthor().getName());
        }
    }
}
