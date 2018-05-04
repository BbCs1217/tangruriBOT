package bbcs.tangruri.bot.api.pubg;

import bbcs.tangruri.bot.api.API;

import java.util.List;

public class PubgAPI implements API {
	public String getResultString() {
		return resultString;
	}

	private enum PubgFunctions {
		STAT
	}

	private String resultString;

	public boolean callAPI(List<String> params) {
		if(params.size() < 2)
			return false;

		PubgFunctions function;
		try {
			function = PubgFunctions.valueOf(params.get(0).toUpperCase());
		} catch (IllegalArgumentException e) {
			return false;
		}
		boolean ret = false;
		switch (function)
		{
			case STAT:
				ret = stat(params.get(1));
				break;
		}

		return ret;
	}

	private boolean stat(String id) {
		resultString = "https://pubg.op.gg/user/" + id;
		return true;
	}
}
