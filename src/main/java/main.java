import bbcs.tangruri.bot.discord.DiscordCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;

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
		api.connect(new DiscordCallback());
	}
}
