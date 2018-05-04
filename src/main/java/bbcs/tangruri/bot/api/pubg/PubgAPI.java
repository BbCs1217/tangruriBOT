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

	private enum ServerParameter {
		RECENT
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
				boolean recent = false;
				if(params.size() == 2 && params.get(1).equalsIgnoreCase("recent"))
					recent = true;
				ret = serverStat(recent);
				break;
		}

		return ret;
	}

	private String serverStat(boolean recent) {
		int gap = 10;	//10분간격
		int totalCnt = 60;	//최근 60분간
		if(recent) {
			gap = 1;
			totalCnt = 15;
		}
		Document doc = null;
		try {
			doc = Jsoup.connect("https://dak.gg/statistics/server").get();
		} catch (IOException e) {
			return null;
		}

		String line = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append("최근 " + getTimeString(totalCnt) + "서버 상태 : " + line);
		int cnt = 0;
		Elements rows = doc.select("tr");
		for(Element row : rows) {
			Elements cols = row.select("div.min");
			for (int i = cols.size() - 1; i >= 0; i--) {
				cnt++;
				if (!recent && (cnt % gap) != 1) {
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

	private String getTimeString(int min) {
		if(min < 60)
			return min + "분";

		int hour = (min + 1) % 60;
		int minT = min - (hour * 60);

		return hour + "시간" + (minT == 0 ? "" : (minT + "분"));
	}

	private String stat(String id) {
		return "https://pubg.op.gg/user/" + id;
	}
}
