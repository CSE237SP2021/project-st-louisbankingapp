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
	
	@Test
	void isValidUsernameAndPassword() {
		//if username and password are greater than 5 characters long
		assertTrue(menu.isValidUsernameAndPassword("andrew", "bobbydrew"));
		

		//if username and/or password are less than 5 characters long
		assertFalse(menu.isValidUsernameAndPassword("andrew", "bobb1"));
		assertFalse(menu.isValidUsernameAndPassword("andre", "bobbydrew"));
		assertFalse(menu.isValidUsernameAndPassword("andre", "bobb1"));
	}

}
