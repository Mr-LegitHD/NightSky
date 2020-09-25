package lu.nightsky.Privat;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartListener extends ListenerAdapter
{
    @Override
    public void onReady(final ReadyEvent event) {
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();

        System.out.println(dateFormat.format(newDate) + " Building NightSky.jar");
        System.out.println(dateFormat.format(newDate) + " NightSky is on the fallowing Servers:");
        int users = 0;
        for (Guild guild : event.getJDA().getGuilds()) {
            users = users + guild.getMemberCount();
            System.out.println("- "+ guild.getName());
        }
        final int serverUsers = users;

        //Build
        System.out.println(dateFormat.format(newDate) +" Ping: " + event.getJDA().getGatewayPing()+ "ms!");
        System.out.println(dateFormat.format(newDate) +" Connected on " +event.getJDA().getGuilds().size()+ " Servers");
        System.out.println(dateFormat.format(newDate) +" Total Users: " + serverUsers);
        System.out.println(dateFormat.format(newDate) +" NightSky " + Secrets.version + " started successful");
        System.out.println("  _   _ _       _     _    _____ _          \n" +
                " | \\ | (_)     | |   | |  / ____| |         \n" +
                " |  \\| |_  __ _| |__ | |_| (___ | | ___   _ \n" +
                " | . ` | |/ _` | '_ \\| __|\\___ \\| |/ / | | |\n" +
                " | |\\  | | (_| | | | | |_ ____) |   <| |_| |\n" +
                " |_| \\_|_|\\__, |_| |_|\\__|_____/|_|\\_\\\\__, |\n" +
                "           __/ |                       __/ |\n" +
                "          |___/                       |___/ ");

    }
}

