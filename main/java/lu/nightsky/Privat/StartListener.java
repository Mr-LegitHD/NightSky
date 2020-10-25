package lu.nightsky.Privat;

import lu.nightsky.AdminStuff.VeryBadDesign;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartListener extends ListenerAdapter {
    @Override
    public void onReady(final ReadyEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();

        System.out.println(Secrets.ANSI_CYAN+dateFormat.format(newDate) + " Building NightSky.jar");
        System.out.println(Secrets.ANSI_CYAN+dateFormat.format(newDate) + " NightSky is on the fallowing Servers:"+Secrets.ANSI_RESET);
        int users = 0;
        for (Guild guild : event.getJDA().getGuilds()) {
            users = users + guild.getMemberCount();
            System.out.println(Secrets.ANSI_BLUE+"- "+ guild.getName()+Secrets.ANSI_RESET);
        }
        final int serverUsers = users;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            event.getJDA().getPresence().setActivity(Activity.watching(event.getJDA().getGuilds().size() + " guilds | +help"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getJDA().getPresence().setActivity(Activity.listening("+help | Contact Mr_Legit HD#3358 for help"));
        };

        executor.scheduleWithFixedDelay(task, 0, 5, TimeUnit.SECONDS);



        //Build
        System.out.println(Secrets.ANSI_CYAN+dateFormat.format(newDate) +" Ping: "+Secrets.ANSI_GREEN + event.getJDA().getGatewayPing()+ "ms!"+Secrets.ANSI_RESET);
        System.out.println(Secrets.ANSI_CYAN+dateFormat.format(newDate) +" Connected on " +Secrets.ANSI_GREEN+ event.getJDA().getGuilds().size()+ Secrets.ANSI_CYAN+" Servers"+Secrets.ANSI_RESET);
        System.out.println(Secrets.ANSI_CYAN+dateFormat.format(newDate) +" Total Users: " +Secrets.ANSI_GREEN+ serverUsers+Secrets.ANSI_RESET);
        System.out.println(Secrets.ANSI_CYAN+dateFormat.format(newDate) +" NightSky "+Secrets.ANSI_YELLOW + Secrets.version + Secrets.ANSI_CYAN+" started successful"+Secrets.ANSI_RESET);
        System.out.println(Secrets.ANSI_PURPLE+"  _   _ _       _     _    _____ _          \n" +
                " | \\ | (_)     | |   | |  / ____| |         \n" +
                " |  \\| |_  __ _| |__ | |_| (___ | | ___   _ \n" +
                " | . ` | |/ _` | '_ \\| __|\\___ \\| |/ / | | |\n" +
                " | |\\  | | (_| | | | | |_ ____) |   <| |_| |\n" +
                " |_| \\_|_|\\__, |_| |_|\\__|_____/|_|\\_\\\\__, |\n" +
                "           __/ |                       __/ |\n" +
                "          |___/                       |___/ "+Secrets.ANSI_RESET);

    }


    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        User user = event.getAuthor();

        if (user.isBot() || event.isWebhookMessage()) {
            return;
        }

        final long guildId = event.getGuild().getIdLong();
        String prefix = VeryBadDesign.PREFIXES.computeIfAbsent(guildId, (id) -> Secrets.prefix);
        String raw = event.getMessage().getContentRaw();

    }
}

