package bbcs.tangruri.bot.command.factory;

import bbcs.tangruri.bot.command.pubg.PubgCommand;
import bbcs.tangruri.bot.command.Command;
import bbcs.tangruri.bot.api.pubg.PubgAPI;

public class CommandFactory {
	public static Command getCommand(String command) {
		Command ret = null;
		if(command.compareToIgnoreCase("pubg") == 0) {
			ret = new PubgCommand(new PubgAPI());
		}
		return ret;
	}
}
