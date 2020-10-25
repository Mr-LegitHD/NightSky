package lu.nightsky.Musik;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import lu.nightsky.Privat.Secrets;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class Volume extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        User user = event.getAuthor();
        String volume = args[1];
        final AudioPlayer player;
        final TextChannel channel = event.getChannel();
        if (event.getAuthor().isBot()) return;
        if (args[0].equalsIgnoreCase(Secrets.prefix + "volume")) {

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
                musicManager.audioPlayer.setVolume(Integer.parseInt(volume));


                channel.sendMessageFormat("Set Volume to " + volume, memberChannel.getName()).queue();
            }
        }

    }



