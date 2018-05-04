package bbcs.tangruriBot.command.factory;

import bbcs.tangruriBot.command.Command;
import bbcs.tangruriBot.command.pubg.PubgCommand;
import bbcs.tangruriBot.API.pubgAPI.PubgAPI;

public class CommandFactory {
	public static Command getCommand(String command) {
		Command ret = null;
		if(command.compareToIgnoreCase("pubg") == 0) {
			ret = new PubgCommand(new PubgAPI());
		}
		return ret;
	}
}
