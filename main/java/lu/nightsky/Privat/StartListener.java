package lu.nightsky.Privat;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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
        int users = 0;
        for (Guild guild : event.getJDA().getGuilds()) {
            users = users + guild.getMemberCount();
        }
        final int serverUsers = users;
        final int sharcount = event.getJDA().getShardInfo().getShardTotal();
         int serverCount = event.getJDA().getGuilds().size();
         int count = event.getJDA().getShardInfo().getShardTotal();
         int top = 2112;
        System.out.println(count);

            //System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Reloaded ServerCount on "+Secrets.ANSI_CYAN+"Top.gg"+Secrets.ANSI_RESET+" ✔️");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            event.getJDA().getPresence().setActivity(Activity.watching("2027" + " guilds on "+sharcount+" shards | +help"));
            //System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Reloaded ServerCount on "+Secrets.ANSI_CYAN+"Top.gg"+Secrets.ANSI_RESET+" ✔️");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getJDA().getPresence().setActivity(Activity.listening("+help | Contact Mr_Legit HD#3358 for help"));
            //System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Reloaded ServerCount on "+Secrets.ANSI_CYAN+"Top.gg"+Secrets.ANSI_RESET+" ✔️");
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



}

