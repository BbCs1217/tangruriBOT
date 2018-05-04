package bbcs.tangruri.bot.parser;

import bbcs.tangruri.bot.parser.rule.ChatRuleParser;

public class ParserFactory {
	public static Parser getParser(String parserName) {
		Parser p = null;
		if(parserName.equalsIgnoreCase("ChatRule")) {
			p = new ChatRuleParser();
		}

		return p;
	}
}
