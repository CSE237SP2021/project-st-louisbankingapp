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
			displayAccountMenu(selectAccount());
			return true;
			
		case 4:
			return false;
			
		default:
			System.out.println("Please select a valid option.");
			return true;
		}
		
	}
	
	/**
	 * Creates a new savings account for the current user
	 * @return savings account created
	 */
	public static Account createSavingsAccount() {
		Account savingsAccount = new Account(1.01);
		User.currentUser.addAccount(savingsAccount);
		return savingsAccount;
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
	 * Displays the accounts of the current user and asks them which account they want to select
	 * @return account selected by user or null if no accounts exist
	 */
	public static Account selectAccount() {
		if(User.currentUser.getAccounts().isEmpty()) {
			System.out.println("You haven't created any account yet!");
			return null;
		} else {
			System.out.println("Which account do you want to select?");
			for(int i = 0; i < User.currentUser.getAccounts().size(); i++) {
				printAccount(User.currentUser.getAccounts().get(i), i);
			}
			
			return selectAccountMenu();
		}
	}
	
	/**
	 * Prompts user to select an account to interact with
	 * @return account selected by the user
	 */
	public static Account selectAccountMenu() {
		boolean selectedValidAccount = false;	
		do {
			Scanner userOption = new Scanner(System.in);
			System.out.println("Enter number of account to select:");
			
			try {
				int optionNumber = userOption.nextInt();
				if(isValidAccountOption(optionNumber)) 
					return User.currentUser.getAccounts().get(optionNumber-1);
			} catch (Exception e) {
				System.out.println("Please enter an integer.");	
			}
		} while(!selectedValidAccount);
		return null;
	}
	
	//TODO: Create Unit Test for this method
	/**
	 * Returns if the integer is a valid option in the accounts list for the current user
	 * @param optionNumber option entered by the user representing an account to select
	 * @return true if the number is a valid option, false if not
	 */
	public static boolean isValidAccountOption(int optionNumber) {
		if(optionNumber <= User.currentUser.getAccounts().size() && optionNumber > 0) {
			return true;
		} else {
			System.out.println("Invalid Selection. Please try again.");
			return false;
		}
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
	 * Displays an account by printing its number, type and current balance
	 * @param account to display
	 * @param index of the account in the list of accounts of the current user
	 */
	public static void printAccount(Account account, int index) {
		String type = "savings";
		if(account.getInterestRate() == 0)
			type = "checking";
		System.out.println((index + 1) + "  Account Number: " + account.getAccountNumber());
		System.out.println("   Type: " + type);
		System.out.println("   Current Balance: " + account.getAccountBalance());
	}
	
}
