package lu.nightsky.Privat;

import lu.nightsky.AdminStuff.Embed;
import lu.nightsky.Automod.AntiInvite;
import lu.nightsky.Automod.Blacklist;
import lu.nightsky.BotEvents.GuildJoin;
import lu.nightsky.BotEvents.GuildLeave;
import lu.nightsky.BotSelf.*;
import lu.nightsky.Fun.*;
import lu.nightsky.Musik.*;
import lu.nightsky.RovelStars.Ban;
import lu.nightsky.RovelStars.Kick;
import lu.nightsky.RovelStars.Mute;
import lu.nightsky.RovelStars.Unmute;
import lu.nightsky.AdminStuff.SayCommand;
import lu.nightsky.HelpCmds.*;
import lu.nightsky.Info.*;
import lu.nightsky.Moderation.*;
import lu.nightsky.Utilities.Couting;
import lu.nightsky.Utilities.NightSkyUser;
import lu.nightsky.Utilities.Ticket;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;

public class MainClass {
    public static JDABuilder builder;
    public static JDA jda;


    public static void main(final String[] args) throws LoginException {
        final JDABuilder builder = JDABuilder.createDefault(Secrets.TOKENTest);


        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Token Login valid ✔️");

        for (final GatewayIntent gatewayIntent : GatewayIntent.values()) {
            builder.enableIntents(gatewayIntent, new GatewayIntent[0]);
        }
        System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" GateawayIntent Connected successful ✔️");

        //Listeners
        builder.addEventListeners(new HelpCommand());
        builder.addEventListeners(new PingCommand());
        builder.addEventListeners(new StartListener());
        builder.addEventListeners(new InfosCommand());
        builder.addEventListeners(new MuteCommand());
        builder.addEventListeners(new HelpMod());
        builder.addEventListeners(new BanCommand());
        builder.addEventListeners(new UnmuteCommand());
        builder.addEventListeners(new Links());
        builder.addEventListeners(new Embed());
        builder.addEventListeners(new FlipCoin());
        builder.addEventListeners(new KickCommand());
        builder.addEventListeners(new Serverinfo());
        builder.addEventListeners(new Userinfo());
        builder.addEventListeners(new SayCommand());
        builder.addEventListeners(new ClearCommand());
        builder.addEventListeners(new HelpInfo());
        builder.addEventListeners(new HelpAdmin());
        builder.addEventListeners(new HelpFun());
        builder.addEventListeners(new Meme());
        builder.addEventListeners(new AntiInvite());
        builder.addEventListeners(new HelpAutoMod());
        builder.addEventListeners(new Blacklist());
        builder.addEventListeners(new Ticket());
        builder.addEventListeners(new Private());
        builder.addEventListeners(new GuildJoin());
        builder.addEventListeners(new GuildLeave());
        builder.addEventListeners(new GoogleSearch());
        builder.addEventListeners(new SelfInfo());
        builder.addEventListeners(new Uptime());
        builder.addEventListeners(new Shutdown());
        builder.addEventListeners(new Mute());
        builder.addEventListeners(new Ban());
        builder.addEventListeners(new Unmute());
        builder.addEventListeners(new Kick());
        builder.addEventListeners(new Vote());
        builder.addEventListeners(new Joke());
        builder.addEventListeners(new Join());
        builder.addEventListeners(new PlayCommand());
        builder.addEventListeners(new StopCommand());
        builder.addEventListeners(new HelpMusik());
        builder.addEventListeners(new Leave());
        builder.addEventListeners(new Skip());
        builder.addEventListeners(new Pause());
        builder.addEventListeners(new Continue());
        builder.addEventListeners(new Shutdown());
        builder.addEventListeners(new Loveship());
        builder.addEventListeners(new Instagram());
        builder.addEventListeners(new NightSkyUser());
        builder.addEventListeners(new Couting());
       // builder.addEventListeners(new Volume());
        builder.build();
        System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Listener Loading Successful ✔️");
        System.out.println();

    }
}
