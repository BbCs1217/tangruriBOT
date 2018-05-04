import bbcs.tangruriBot.Parser.ChatParser.ChatRuleParser;
import bbcs.tangruriBot.command.Command;
import bbcs.tangruriBot.command.pubg.PubgCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChatRuleParserTest {
	@Test
	public void ruleParseTest() {
		ChatRuleParser parser = new ChatRuleParser();

		Command c = parser.parse("!pubg apache-tomcat");
		assertEquals(PubgCommand.class, c.getClass());
		assertTrue(c.getParameters().get(0).equals("apache-tomcat"));
	}
}
