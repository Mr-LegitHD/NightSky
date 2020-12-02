package lu.nightsky.Privat;

import io.donatebot.api.DBClient;
import jdk.nashorn.internal.parser.Token;
import lu.nightsky.AdminStuff.Embed;
import lu.nightsky.AdminStuff.Voting;
import lu.nightsky.BotEvents.GuildJoin;
import lu.nightsky.BotEvents.GuildLeave;
import lu.nightsky.BotSelf.*;
import lu.nightsky.Fun.*;
import lu.nightsky.AdminStuff.SayCommand;
import lu.nightsky.Game.HelpGame;
import lu.nightsky.Game.List;
import lu.nightsky.Game.Playercount;
import lu.nightsky.HelpCmds.*;
import lu.nightsky.Info.*;
import lu.nightsky.Moderation.*;
import lu.nightsky.Utilities.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import sun.awt.SunToolkit;

import javax.security.auth.login.LoginException;

public class MainClass {
    public static JDABuilder builder;
    public static JDA jda;

    public static void main(final String[] args) throws LoginException {
        //DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(Secrets.TOKENTest);
        JDABuilder builder = JDABuilder.createDefault(Secrets.TOKEN);
        //final JDABuilder builder = JDABuilder.createDefault(Secrets.TOKEN);
        DBClient dbClient = new DBClient("767476859898167377", "5Tjm5ptfEKMPTXPptTrX8zutqjNPm5lyPu8sgGVqYJ4jxngVkcjT2jLmMU4y");
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" Token Login valid ✔️");

        for (final GatewayIntent gatewayIntent : GatewayIntent.values()) {
            builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        }
        System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+" GateawayIntent Connected successful ✔️");

        //Listeners
        builder.addEventListeners(new StartListener());
        builder.addEventListeners(new HelpCommand());
        builder.addEventListeners(new PingCommand());
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
        builder.addEventListeners(new Ticket());
        builder.addEventListeners(new Private());
        builder.addEventListeners(new GuildJoin());
        builder.addEventListeners(new GuildLeave());
        builder.addEventListeners(new GoogleSearch());
        builder.addEventListeners(new SelfInfo());
        builder.addEventListeners(new Uptime());
        builder.addEventListeners(new Joke());
        builder.addEventListeners(new Avatar());
        builder.addEventListeners(new SelfAvatar());
        builder.addEventListeners(new InviteGenerator());
        builder.addEventListeners(new Shutdown());
        builder.addEventListeners(new Loveship());
        builder.addEventListeners(new NightSkyUser());
        builder.addEventListeners(new Couting());
        builder.addEventListeners(new Voting());
        builder.addEventListeners(new Hosting());
        builder.addEventListeners(new TopGGVote());
        builder.addEventListeners(new BotHelp());
        builder.addEventListeners(new Donate());
        builder.addEventListeners(new Playercount());
        builder.addEventListeners(new HelpGame());
        builder.addEventListeners(new List());
        builder.addEventListeners(new HelpMusik());
        builder.addEventListeners(new Warn());
        for (int i = 0; i < 8; i++)
        {
            builder.useSharding(i, 8)
                    .build();
        }
        System.out.println(Secrets.ANSI_YELLOW+"[Info]"+Secrets.ANSI_RESET+Secrets.ANSI_BLUE+"Listener Loading Successful ✔️");
        System.out.println();

    }
}
