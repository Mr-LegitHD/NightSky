package lu.nightsky.Game;

import com.fasterxml.jackson.databind.JsonNode;
import lu.nightsky.Privat.Secrets;
import me.duncte123.botcommons.web.WebUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Playercount extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        String query = String.join(" ", (CharSequence[]) Arrays.copyOfRange(args, 1, args.length));
        DateFormat dateFormat = new SimpleDateFormat("[H:m]");
        Date newDate = new Date();
        User user = event.getAuthor();
        final TextChannel channel = event.getChannel();
        if (event.getAuthor().isBot()) return;

        if (args[0].equalsIgnoreCase(Secrets.prefix + "playercount")) {
            if (args.length < 2) {
                event.getMessage().delete().queue();
                //Embed Builder
                EmbedBuilder mute = new EmbedBuilder();
                mute.setTitle("Error");
                mute.setDescription("Correct Usage: +playercount <Game> \nIf you get no respond add the Game [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                mute.setFooter("System");
                mute.setTimestamp(Instant.now());
                mute.setColor(Color.RED);
                event.getChannel().sendMessage(mute.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
                mute.clear();
                return;
            }

            if (args[1].equalsIgnoreCase("Ark")) {
               String args1 = query;
                args1 = "346110";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else
            if (args[1].equalsIgnoreCase("csgo")) {
                String args1 = args[1];
                args1 = "730";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(args[1].toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Among us")) {
                String args1 = args[1];
                args1 = "945360";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Counter Strike")) {
                String args1 = args[1];
                args1 = "730";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("CounterStrike")) {
                String args1 = args[1];
                args1 = "730";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("gta5")) {
                String args1 = args[1];
                args1 = "271590";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Apex Legends")) {
                String args1 = args[1];
                args1 = "1172470";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Destiny 2")) {
                String args1 = args[1];
                args1 = "1085660";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Rocket League")) {
                String args1 = args[1];
                args1 = "252950";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("PUBG")) {
                String args1 = args[1];
                args1 = "578080";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Team Fortress 2")) {
                String args1 = args[1];
                args1 = "440";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Dota 2")) {
                String args1 = args[1];
                args1 = "570";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Terraria")) {
                String args1 = args[1];
                args1 = "105600";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Fallout 4")) {
                String args1 = args[1];
                args1 = "377160";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Hitman 2")) {
                String args1 = args[1];
                args1 = "863550";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Call of Duty: Black Ops III")) {
                String args1 = args[1];
                args1 = "311210";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("R6")) {
                String args1 = args[1];
                args1 = "359550";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Clustertruck")) {
                String args1 = args[1];
                args1 = "397950";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else
            if (query.equalsIgnoreCase("World of Tanks Blitz")) {
                String args1 = args[1];
                args1 = "444200";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else
            if (query.equalsIgnoreCase("World of Tanks Legends")) {
                String args1 = args[1];
                args1 = "444200";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
            else

            if (query.equalsIgnoreCase("Minecraft Story Mode")) {
                String args1 = args[1];
                args1 = "376870";

                WebUtils.ins.getJSONObject("https://api.steampowered.com/ISteamUserStats/GetNumberOfCurrentPlayers/v1/?format=json&appid=" + args1).async((json) -> {


                    final JsonNode response = json.get("response");
                    final String player_count = response.get("player_count").asText();

                    final EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle(query.toUpperCase() + " | Playercount");
                    embed.setThumbnail("https://i.imgur.com/FHfyM1c.png");
                    embed.setDescription("**"+query+ "** has currently " + player_count + " online Players. \nAdd a Game? Click [here](https://docs.google.com/forms/d/e/1FAIpQLSdqvZIQOLkm8JyF3-Fkv2EL-YZsWQJTFCJvilKWfQoZHzCPtw/viewform)");
                    embed.setFooter(user.getAsTag() + " | NightSky " + Secrets.version, user.getAvatarUrl());
                    embed.setColor(new Color(255, 200, 61));
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();
                    event.getMessage().delete().queue();
                    System.out.println(dateFormat.format(newDate) + " Command +playercount got used by " + event.getAuthor().getName());
                });

            }
        }

    }

}