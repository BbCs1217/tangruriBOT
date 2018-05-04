package bbcs.tangruri.bot.api.pubg;

import bbcs.tangruri.bot.api.API;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class PubgAPI implements API {

	private enum PubgFunctions {
		STAT, SERVER
	}

	public String callAPI(List<String> params) {
		if(params.size() < 1)
			return null;

		PubgFunctions function;
		try {
			function = PubgFunctions.valueOf(params.get(0).toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}
		String ret = null;
		switch (function)
		{
			case STAT:
				if(params.size() < 2)
					return null;
				ret = stat(params.get(1));
				break;
			case SERVER:
				ret = serverStat();
				break;
		}

		return ret;
	}

	private String serverStat() {
		int gap = 10;	//10분간격
		int totalCnt = 60;	//최근 60분간
		Document doc = null;
		try {
			doc = Jsoup.connect("https://dak.gg/statistics/server").get();
		} catch (IOException e) {
			return null;
		}

		String line = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append("최근 1시간 서버 상태 : " + line);
		int cnt = 0;
		Elements rows = doc.select("tr");
		for(Element row : rows) {
			Elements cols = row.select("div.min");
			for (int i = cols.size() - 1; i >= 0; i--) {
				cnt++;
				if ((cnt % gap) != 1) {
					continue;
				}
				sb.append("time: " + cols.get(i).attr("title").replace("<br />", " status :"));
				sb.append(line);
				if (cnt >= totalCnt)
					break;
			}
			if (cnt >= totalCnt)
				break;
		}

		return sb.toString();
	}

	private String stat(String id) {
		return "https://pubg.op.gg/user/" + id;
	}
}
