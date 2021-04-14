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
		System.out.println("Account Number: " + this.account.getAccountNumber());
		System.out.println("Current Balance: " + this.account.getAccountBalance());
		
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
			// TODO: Deposit money from account
			return false;
			
		case 2:
			// TODO: Withdraw money from account
			return false;
			
		case 3:
			// TODO: Transfer money to another account
			return false;
			
		case 4:
			return false;
			
		default:
			System.out.println("Please select a valid option.");
			return true;
		}
		
	}
}
