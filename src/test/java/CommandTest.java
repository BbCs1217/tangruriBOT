import bbcs.tangruriBot.command.Command;
import bbcs.tangruriBot.command.pubg.PubgCommand;
import bbcs.tangruriBot.API.pubgAPI.PubgAPI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandTest {
	@Test
	public void executeTest() {
		Command pubgCommand = new PubgCommand(new PubgAPI());
		assertNotNull(pubgCommand);
		assertTrue(pubgCommand.execute());
	}
}
