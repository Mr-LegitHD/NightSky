package lu.nightsky.Privat;

import lu.nightsky.Automod.AntiInvite;
import lu.nightsky.Automod.Blacklist;
import lu.nightsky.BotEvents.GuildJoin;
import lu.nightsky.BotEvents.GuildLeave;
import lu.nightsky.Utilities.SayCommand;
import lu.nightsky.HelpCmds.*;
import lu.nightsky.Info.*;
import lu.nightsky.Moderation.*;
import lu.nightsky.Utilities.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;

public class MainClass {
    public static JDABuilder builder;
    public static JDA jda;

    public static void main(final String[] args) throws LoginException {
        final JDABuilder builder = JDABuilder.createDefault(Secrets.TOKEN);
        builder.setAutoReconnect(true);
        builder.setActivity(Activity.listening("+help"));
        builder.setStatus(OnlineStatus.ONLINE);

        for (final GatewayIntent gatewayIntent : GatewayIntent.values()) {
            builder.enableIntents(gatewayIntent, new GatewayIntent[0]);
        }

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
        builder.addEventListeners(new Memes());
        builder.addEventListeners(new AntiInvite());
        builder.addEventListeners(new HelpAutoMod());
        builder.addEventListeners(new Blacklist());
        builder.addEventListeners(new Ticket());
        builder.addEventListeners(new Private());
        builder.addEventListeners(new GuildJoin());
        builder.addEventListeners(new GuildLeave());
        builder.addEventListeners(new GoogleSearch());
        builder.build();

    }
}
