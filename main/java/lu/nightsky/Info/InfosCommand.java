package lu.nightsky.Info;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.SessionController;
import net.dv8tion.jda.api.utils.cache.CacheView;
import net.dv8tion.jda.api.utils.cache.ShardCacheView;
import net.dv8tion.jda.internal.utils.cache.ShardCacheViewImpl;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class InfosCommand extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        int users = 0;
        for (Guild guild : event.getJDA().getGuilds()) {
            users = users + guild.getMemberCount();
        }
        final int serverUsers = users;
        Member selfMember = event.getGuild().getSelfMember();
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();

        if (args[0].equalsIgnoreCase(Secrets.prefix + "infos")) {
            User user = event.getAuthor();

            //Embed Builder
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("\uD83D\uDCAD NightSky | Informations");
            info.addField("**Bot-Dev**:","Mr_Legit HD#3358 <:discord_bot_dev:777318867419922462>", true);
            info.addField("**Library**:","JDA <:java:777318867549683722>", true);
            info.addField("**Version**:",Secrets.version +" <:online_oxzy:777318867092635739>", true);
            info.addField("**Prefix**","+", true);
            info.addField("**Users**:","210304"+ "<:users_logo:777318867441025044>", true);
            info.addField("**Shards**:", "8" +"<:Servers:777318867122389013>", true);
            info.setFooter( user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
            info.setColor(Color.green);
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
            event.getMessage().delete().queue();
            System.out.println(dateFormat.format(newDate) +" Command +infos got used by "+ event.getAuthor().getName());


        }


    }
}
