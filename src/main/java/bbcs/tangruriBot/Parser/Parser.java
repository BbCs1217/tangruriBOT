package bbcs.tangruriBot.Parser;

import bbcs.tangruriBot.command.Command;

public interface Parser {
	Command parse(String msg);
}
