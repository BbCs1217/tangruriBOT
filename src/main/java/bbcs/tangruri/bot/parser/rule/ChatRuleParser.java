package bbcs.tangruri.bot.parser.rule;

import bbcs.tangruri.bot.command.factory.CommandFactory;
import bbcs.tangruri.bot.parser.Parser;
import bbcs.tangruri.bot.command.Command;

import java.util.ArrayList;
import java.util.Arrays;

public class ChatRuleParser implements Parser {
	public Command parse(String msg) {
		if(msg.startsWith("!") == false)
			return null;

		StringBuilder sb = new StringBuilder(msg);
		sb.deleteCharAt(0);

		String[] tokens = sb.toString().split(" ");
		if(tokens.length < 1)
			return null;

		Command c = CommandFactory.getCommand(tokens[0]);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(tokens));
		list.remove(0);

		c.setParameters(list);
		return c;
	}
}
