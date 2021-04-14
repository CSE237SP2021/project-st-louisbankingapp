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
}
