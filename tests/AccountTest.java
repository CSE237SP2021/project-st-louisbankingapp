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
		User user = new User("ayoub", "pass5236");
		User.addUser(user);
		User.currentUser = user;
		
		assertTrue(User.currentUser.getAccounts().isEmpty());
		
		UserMenu.createSavingsAccount();
		
		assertFalse(User.currentUser.getAccounts().isEmpty());
		assertEquals(0, User.currentUser.getAccounts().get(0).getAccountBalance());
		assertTrue(User.currentUser.getAccounts().get(0).getInterestRate() > 0);
		
		User.users.clear();
	}
	
	@Test
	public void getAccountByAccountNumber() {
		User user = new User("ayoub", "pass5236");
		User.addUser(user);
		User.currentUser = user;
		UserMenu.createCheckingAccount();
		Account account = User.currentUser.getAccounts().get(0);
		int accountNumber = account.accountNumber;
		
		assertEquals(account, Account.getAccountByAccountNumber(accountNumber));
		
		User.users.clear();
	}
	
	@Test
	public void isValidAccountOption() {
		User user = new User("ayoub", "pass5236");
		User.addUser(user);
		User.currentUser = user;
		
		UserMenu.createCheckingAccount();
		UserMenu.createSavingsAccount();
		AccountMenu menu = new AccountMenu(User.currentUser.getAccounts().get(0));
		
		//assertEquals(2, User.currentUser.getAccounts().size());
		
		assertTrue(menu.isValidAccountOption(1));
		assertTrue(menu.isValidAccountOption(2));
		
		assertFalse(menu.isValidAccountOption(0));
		assertFalse(menu.isValidAccountOption(3));
		
		User.users.clear();
	}

}
