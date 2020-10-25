package lu.nightsky.Musik;

import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pause extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User user = event.getAuthor();
        if (event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "pause")) {

            final TextChannel channel = event.getChannel();
            final Member self = event.getGuild().getSelfMember();
            final GuildVoiceState selfVoiceState = self.getVoiceState();

            final Member member = event.getMember();
            final GuildVoiceState memberVoiceState = member.getVoiceState();

            if (!memberVoiceState.inVoiceChannel()) {
                channel.sendMessage("You need to be in a voice channel for this command to work").queue();
                return;
            }

            final AudioManager audioManager = event.getGuild().getAudioManager();
            final VoiceChannel memberChannel = memberVoiceState.getChannel();
            final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(event.getGuild());
            musicManager.scheduler.player.setPaused(true);

            channel.sendMessageFormat("Paused Song", memberChannel.getName()).queue();
        }
        }
    }

