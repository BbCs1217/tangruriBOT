package bbcs.tangruri.bot.command.pubg;

import bbcs.tangruri.bot.api.pubg.PubgAPI;
import bbcs.tangruri.bot.command.Command;

import java.util.List;

public class PubgCommand implements Command {
	private PubgAPI pubgAPI;
	private List<String> params;

	public void setParameters(List<String> parameters) {
		this.params = parameters;
	}

	public PubgCommand(PubgAPI pubgAPI) {
		this.pubgAPI = pubgAPI;
	}

	public List<String> getParameters() {
		return params;
	}

	public String execute() {
		return pubgAPI.callAPI(params);
	}
}
