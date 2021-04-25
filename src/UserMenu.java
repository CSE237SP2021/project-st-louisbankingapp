import java.util.Scanner;

public class UserMenu {
		
	public UserMenu() {}
	
	public void runMenu() {
		boolean isRunning = true;
		while(isRunning) {
			isRunning = displayUserMenu();
		}
	}
	
	/**
	 * Displays the options for the user to pick from
	 * @return returns true if the user menu should be displayed again, false if not
	 */
	public boolean displayUserMenu() {
		Scanner userOption = new Scanner(System.in);
		
		System.out.println("Enter number to select option:");
		System.out.println("1: Create Checking Account");
		System.out.println("2: Create Savings Account");
		System.out.println("3: Select Account");
		System.out.println("4: Logout");
		
		try {
			int optionNumber = userOption.nextInt();

			return readUserMenuOptions(optionNumber);
		} catch (Exception e) {
			System.out.println("Please enter an integer.");
			return true;
		}
	}
	
	/**
	 * Decides what to do next depending on the option that the user selected
	 * @param option that the user entered to be processed
	 * @return returns true if the user menu should be displayed again, false if not
	 */
	public boolean readUserMenuOptions(int option) {
		switch(option) {
		case 1:
			displayAccountMenu(createCheckingAccount());
			return true;
			
		case 2:
			displayAccountMenu(createSavingsAccount());
			return true;
			
		case 3:
			displayAccounts();
			return true;
			
		case 4:
			return false;
			
		default:
			System.out.println("Please select a valid option.");
			return true;
		}
		
	}
	
	
	/**
	 * Creates a new checking account for the current user
	 * @return checking account created
	 */
	public static Account createCheckingAccount() {
		Account checkingAccount = new Account(0);
		User.currentUser.addAccount(checkingAccount);
		return checkingAccount;
	}
	
	/**
	 * Creates a new savings account for the current user
	 * @return checking account created
	 */
	public static Account createSavingsAccount() {
		Account checkingAccount = new Account(0.01);
		User.currentUser.addAccount(checkingAccount);
		return checkingAccount;
	}
	
	/**
	 * Displays the account's menu
	 * @param the account that we want to display the menu of
	 */
	public void displayAccountMenu(Account account) {
		AccountMenu accountMenu = new AccountMenu(account);
		accountMenu.runMenu();
	}
	
	/**
	 * Displays the accounts of the current user and asks them which account they want to select
	 */
	public void displayAccounts() {
		Scanner selectAccount = new Scanner(System.in);
		
		if(User.currentUser.getAccounts().isEmpty()) {
			System.out.println("You haven't created any account yet!");
		} else {
			System.out.println("Enter account number to select account:");
			for(int i = 0; i < User.currentUser.getAccounts().size(); i++) {
				System.out.print(i + 1 + ":");
				printAccount(User.currentUser.getAccounts().get(i));
			}
			
			try {
				int accountNumber = selectAccount.nextInt();
				selectAccount(accountNumber);
			} catch (Exception e) {
				System.out.println("Please enter an integer.");
			}
		}
	}
	
	/**
	 * Selects an account to display and displays its menu
	 * @param accountNumber: the account number of the account to select
	 */
	public void selectAccount(int accountNumber) {
		Account account = Account.getAccountByAccountNumber(accountNumber);
		if(account == null) {
			System.out.println("Please enter a valid account number.");
		} else {
			displayAccountMenu(account);
		}
	}
	
	/**
	 * Displays an account by printing its number, type and current balance
	 * @param account to display
	 * @param index of the account in the list of accounts of the current user
	 */
	public static void printAccount(Account account) {
		System.out.println(" Account Number: " + account.getAccountNumber());
		String type = "checking";
		if(account.getInterestRate() > 0) {
			type = "saving";
			System.out.println("   Interest rate: " + account.getInterestRate() * 100 + "%");
		}
		System.out.println("   Type: " + type);
		System.out.println("   Current Balance: $" + account.getAccountBalance());
	}
	
}
