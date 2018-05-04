package bbcs.tangruri.bot.discord;

import bbcs.tangruri.bot.parser.Parser;
import bbcs.tangruri.bot.parser.ParserFactory;
import bbcs.tangruri.bot.command.Command;
import com.google.common.util.concurrent.FutureCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class DiscordCallback implements FutureCallback<DiscordAPI> {
	public void onSuccess(DiscordAPI discordAPI) {
		discordAPI.registerListener(new MessageCreateListener() {
			public void onMessageCreate(DiscordAPI discordAPI, Message message) {
				Parser p = ParserFactory.getParser("chatRule");
				if(p == null)
					return;
				Command c = p.parse(message.getContent());
				if(c != null) {
					c.execute();
				}
			}
		});
	}

	public void onFailure(Throwable throwable) {
		throwable.printStackTrace();
	}
}
