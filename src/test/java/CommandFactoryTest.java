import bbcs.tangruri.bot.command.Command;
import bbcs.tangruri.bot.command.factory.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommandFactoryTest {
	@Test
	public void getPubgCommandTest() {
		Command pubgCommand = CommandFactory.getCommand("pubg");
		assertNotNull(pubgCommand);
	}
}
