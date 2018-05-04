import bbcs.tangruriBot.command.Command;
import bbcs.tangruriBot.command.pubg.PubgCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandTest {
	@Test
	public void executeTest() {
		Command pubgCommand = new PubgCommand();
		assertNotNull(pubgCommand);
		assertTrue(pubgCommand.execute());
	}
}
