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
			createCheckingAccount();
			return true;
			
		case 2:
			return createSavingsAccount();
			
		case 3:
			selectAccount();
			return true;
			
		case 4:
			return false;
			
		default:
			System.out.println("Please select a valid option.");
			return true;
		}
		
	}
	
	/* TODO Create savings account and display account menu */
	public boolean createSavingsAccount() {
		System.out.println("TO BE IMPLEMENTED: Create Savings Account");
		return true;
	}
	
	/**
	 * Creates a new checking account for the current user and displays the new account's menu
	 */
	public void createCheckingAccount() {
		Account checkingAccount = new Account(0);
		User.currentUser.addAccount(checkingAccount);
		AccountMenu accountMenu = new AccountMenu(checkingAccount);
		accountMenu.runMenu();
	}
	
	/**
	 * Displays the accounts of the current user and asks them which account they want to select
	 */
	public void selectAccount() {
		if(User.currentUser.getAccounts().isEmpty()) {
			System.out.println("You haven't created any account yet!");
		} else {
			System.out.println("Which account do you want to select?");
			for(int i = 0; i < User.currentUser.getAccounts().size(); i++) {
				Account account = User.currentUser.getAccounts().get(i);
				String type = "savings";
				if(account.getInterestRate() == 0)
					type = "checking";
				System.out.println((i + 1) + "  Account Number: " + account.getAccountNumber());
				System.out.println("   Type: " + type);
				System.out.println("   Current Balance: " + account.getAccountBalance());
			}
			/* TODO: Allow user to pick one to display the account menu */
			System.out.println("TO BE IMPLEMENTED: Select Account");
		}
	}
	
}
