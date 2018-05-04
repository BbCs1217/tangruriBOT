package bbcs.tangruri.bot.command;

import java.util.List;

public interface Command {
	void setParameters(List<String> parameters);
	List<String> getParameters();
	String execute();
}
