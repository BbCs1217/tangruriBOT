import com.google.common.util.concurrent.FutureCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class main {
	public static void main(String args[]) {
		DiscordAPI api = Javacord.getApi("NDQxNTE0NTU1NDAzNjY1NDI4.DcycOA.4w5uVsQzRr11Krlftse9T3XnMFg", true);
		api.connect(new FutureCallback<DiscordAPI>() {
			public void onSuccess(DiscordAPI discordAPI) {
				discordAPI.registerListener(new MessageCreateListener() {
					public void onMessageCreate(DiscordAPI discordAPI, Message message) {
						String msg = message.getContent();
						if(msg.startsWith("!") == false) {
							return;
						}

						StringBuilder sb = new StringBuilder(msg);
						sb.deleteCharAt(0);
						String tokens[] = sb.toString().split(" ");
					}
				});
			}

			public void onFailure(Throwable throwable) {
				throwable.printStackTrace();
			}
		});
	}
}
