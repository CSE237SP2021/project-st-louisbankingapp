import java.util.Scanner;

public class UserMenu {
	
	private User currentUser;
	
	public UserMenu(User user) {
		this.currentUser = user;
	}
	
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
			return createSavingsAccount();
			
		case 2:
			return createCheckingAccount();
			
		case 3:
			return selectAccount();
			
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
	
	/* TODO Create checking account and display account menu */
	public boolean createCheckingAccount() {
		System.out.println("TO BE IMPLEMENTED: Create Checking Account");
		return true;
	}
	
	/* TODO: Display list of accounts for user to select from and 
	 * allow user to pick one to display the account menu
	 */
	public boolean selectAccount() {
		System.out.println("TO BE IMPLEMENTED: Select Account");
		return true;
	}
	
}
