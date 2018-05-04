package bbcs.tangruri.bot.parser;

import bbcs.tangruri.bot.command.Command;

public interface Parser {
	Command parse(String msg);
}
