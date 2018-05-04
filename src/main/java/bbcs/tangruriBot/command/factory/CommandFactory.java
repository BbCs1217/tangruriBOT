package bbcs.tangruriBot.command.factory;

import bbcs.tangruriBot.command.Command;
import bbcs.tangruriBot.command.pubg.PubgCommand;

public class CommandFactory {
	public static Command getCommand(String command) {
		Command ret = null;
		if(command.compareToIgnoreCase("pubg") == 0) {
			ret = new PubgCommand();
		}
		return ret;
	}
}
