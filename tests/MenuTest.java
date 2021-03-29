import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuTest {
	
	Menu menu = new Menu();

	@Test
	void readOption() {
		//check inputs besides 3
		assertTrue(menu.readOption(1));
		assertTrue(menu.readOption(2));
		assertTrue(menu.readOption(4));
		
		//check 3: the quit option
		assertFalse(menu.readOption(3));
	}
}
