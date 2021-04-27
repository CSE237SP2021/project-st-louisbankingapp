import java.util.Scanner;

public class AccountMenu {
	
	Account account;

	public AccountMenu(Account account) {
		this.account = account;
	}
	
	public void runMenu() {
		boolean isRunning = true;
		while(isRunning) {
			isRunning = displayAccountMenu();
		}
	}
	
	/**
	 * Displays the options for the user to pick from
	 * @return returns true if the account menu should be displayed again, false if not
	 */
	public boolean displayAccountMenu() {
		UserMenu.printAccount(this.account);
		
		Scanner accountOption = new Scanner(System.in);
		
		System.out.println("Enter number to select option:");
		System.out.println("1: Deposit");
		System.out.println("2: Withdraw");
		System.out.println("3: Transfer");
		System.out.println("4: Go back");
		
		try {
			int optionNumber = accountOption.nextInt();
			
			return readAccountMenuOptions(optionNumber);
		} catch (Exception e) {
			System.out.println("Please enter an integer.");
			return true;
		}
	}
	
	/**
	 * Decides what to do next depending on the option that the user selected
	 * @param option that the user entered to be processed
	 * @return returns true if the account menu should be displayed again, false if not
	 */
	public boolean readAccountMenuOptions(int option) {
		switch(option) {
		case 1:
			depositMoney();
			return true;
			
		case 2:
			withdrawMoney();
			return true;
			
		case 3:
			transferMoney();
			return true;
			
		case 4:
			return false;
			
		default:
			System.out.println("Please select a valid option.");
			return true;
		}
	}
	
	/**
	 * Prompts user for how much to deposit into the account and deposits it
	 */
	public void depositMoney() {
		Scanner amountEntered = new Scanner(System.in);
		System.out.println("How much would you like to deposit?");
		
		try {
			double amount = amountEntered.nextDouble();
			this.account.deposit(amount);
		} catch (Exception e) {
			System.out.println("Please enter an double.");
		}
	}
	
	/**
	 * Prompts user for how much to withdraw into the account and withdraws it
	 */
	public void withdrawMoney() {
		Scanner amountEntered = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		
		try {
			double amount = amountEntered.nextDouble();
			this.account.withdraw(amount);
		} catch (Exception e) {
			System.out.println("Please enter an double.");
		}
	}
	
	/**
	 * Prompts user for an account to transfer to and how much to transfer then transfers it
	 */
	public void transferMoney() {
		Account receiver = selectAccountToTransferTo();
		
		Scanner amountEntered = new Scanner(System.in);
		System.out.println("How much would you like to transfer?");
		try {
			double amount = amountEntered.nextDouble();
			this.account.transfer(amount, receiver);
		} catch (Exception e) {
			System.out.println("Please enter an double.");
		}
	}
	
	/**
	 * Displays a list of the users accounts, the user is propmted to select an account.
	 * Runs until the user selects a valid account option
	 * @return account slected by the user
	 */
	public Account selectAccountToTransferTo() {
		printAccountOptions();
		boolean isAccountSelected = false;
		
		do {
			Scanner userOption = new Scanner(System.in);
			System.out.println("Please enter number to select account to transfer to:");
			
			try {
				int option = userOption.nextInt();
				if(isValidAccountOption(option))
					return User.currentUser.getAccounts().get(option-1);
			} catch (Exception e) {
				System.out.println("Please enter an integer.");
			}
		} while(!isAccountSelected);
		return null;
	}
	
	/**
	 * Prints all the users accounts with a corresponding index
	 */
	public void printAccountOptions() {
		for(int i = 0; i < User.currentUser.getAccounts().size(); i++) {
			System.out.print(i + 1 + ":");
			UserMenu.printAccount(User.currentUser.getAccounts().get(i));
		}
	}
	
	/**
	 * Checks is the entered option is a valid account option
	 * @param option value entered by the user
	 * @return true if its an index in the array, false if not
	 */
	public boolean isValidAccountOption(int option) {
		if(option <= User.currentUser.getAccounts().size() && option > 0) {
			return true;
		}
		return false;
	}
}
