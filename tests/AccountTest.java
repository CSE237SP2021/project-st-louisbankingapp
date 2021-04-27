import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void openCheckingAccount() {
		User user = new User("ayoub", "pass5236");
		User.addUser(user);
		User.currentUser = user;
		
		assertTrue(User.currentUser.getAccounts().isEmpty());
		
		UserMenu.createCheckingAccount();
		
		assertFalse(User.currentUser.getAccounts().isEmpty());
		assertEquals(0, User.currentUser.getAccounts().get(0).getAccountBalance());
		
		User.users.clear();
	}
	
	@Test
	public void openSavingsAccount() {
		User user = new User("andrew", "andrew");
		User.addUser(user);
		User.currentUser = user;
		
		assertTrue(User.currentUser.getAccounts().isEmpty());
		
		UserMenu.createSavingsAccount();
		
		assertFalse(User.currentUser.getAccounts().isEmpty());
		assertEquals(0, User.currentUser.getAccounts().get(0).getAccountBalance());
		assertEquals(1.01, User.currentUser.getAccounts().get(0).getInterestRate());
		
		User.users.clear();
	}
	
	@Test
	public void isValidAccount() {
		User user = new User("andrew", "andrew");
		User.addUser(user);
		User.currentUser = user;
		
		assertTrue(User.currentUser.getAccounts().isEmpty());
		
		UserMenu.createSavingsAccount();
		UserMenu.createSavingsAccount();
		UserMenu.createCheckingAccount();
		
		assertEquals(3, User.currentUser.getAccounts().size());
		
		assertFalse(UserMenu.isValidAccountOption(0));
		assertFalse(UserMenu.isValidAccountOption(4));
		
		assertTrue(UserMenu.isValidAccountOption(1));
		assertTrue(UserMenu.isValidAccountOption(2));
		assertTrue(UserMenu.isValidAccountOption(3));
		
		User.users.clear();
	}
}
