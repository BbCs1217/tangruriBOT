package bbcs.tangruriBot.command.pubg;

import bbcs.tangruriBot.API.pubgAPI.PubgAPI;

import java.util.List;

public class PubgCommand implements bbcs.tangruriBot.command.Command {
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

	public boolean execute() {
		return pubgAPI.callAPI(params);
	}
}
