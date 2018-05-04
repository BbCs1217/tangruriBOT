import bbcs.tangruriBot.command.Command;
import bbcs.tangruriBot.command.factory.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommandFactoryTest {
	@Test
	public void getPubgCommandTest() {
		Command pubgCommand = CommandFactory.getCommand("pubg");
		assertNotNull(pubgCommand);
	}
}
