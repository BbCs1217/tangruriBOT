package bbcs.tangruriBot.command.pubg;

import bbcs.tangruriBot.API.pubgAPI.PubgAPI;

public class PubgCommand implements bbcs.tangruriBot.command.Command {
	private PubgAPI pubgAPI;
	public PubgCommand(PubgAPI pubgAPI) {
		this.pubgAPI = pubgAPI;
	}

	public boolean execute() {
		return true;
	}
}
