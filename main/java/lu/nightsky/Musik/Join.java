package lu.nightsky.Musik;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.utils.WidgetUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Join extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User user = event.getAuthor();
        if (event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "join")) {

            final TextChannel channel = event.getChannel();
            final Member self = event.getGuild().getSelfMember();
            final GuildVoiceState selfVoiceState = self.getVoiceState();

            if (selfVoiceState.inVoiceChannel()) {
                channel.sendMessage("I'm already in a voice channel").queue();
                return;
            }

            final Member member = event.getMember();
            final GuildVoiceState memberVoiceState = member.getVoiceState();

            if (!memberVoiceState.inVoiceChannel()) {
                channel.sendMessage("You need to be in a voice channel for this command to work").queue();
                return;
            }

            final AudioManager audioManager = event.getGuild().getAudioManager();
            final VoiceChannel memberChannel = memberVoiceState.getChannel();

            audioManager.openAudioConnection(memberChannel);

            channel.sendMessageFormat("Connecting to `\uD83D\uDD0A %s`", memberChannel.getName()).queue();
        }
        }
    }

