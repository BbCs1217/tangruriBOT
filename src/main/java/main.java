import com.google.common.util.concurrent.FutureCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.io.*;

public class main {
	public static void main(String args[]) {
		String token = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("token").getFile()));
			token = in.readLine();
		} catch (FileNotFoundException e) {
			System.out.println("token file not exist");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		DiscordAPI api = Javacord.getApi(token, true);
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
