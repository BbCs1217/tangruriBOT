import bbcs.tangruriBot.API.pubgAPI.PubgAPI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PubgAPITest {
	@Test
	public void PubgAPIConnectTest() {
		PubgAPI pubgAPI = new PubgAPI();
		assertNotNull(pubgAPI);
	}
}
