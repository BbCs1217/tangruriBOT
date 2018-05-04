import bbcs.tangruri.bot.discord.DiscordCallback;
import bbcs.tangruri.bot.util.FileUtil;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;

public class main {
	public static void main(String args[]) {
		String token = FileUtil.readFile(Thread.currentThread().getContextClassLoader().getResource("token").getFile());
		if(token == null || token.equals(""))
			return;
		DiscordAPI api = Javacord.getApi(token, true);
		api.connect(new DiscordCallback());
	}
}
