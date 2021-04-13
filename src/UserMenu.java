import java.util.Scanner;

public class UserMenu {
	
	public static void displayUserMenu() {
		Scanner userOption = new Scanner(System.in);
		
		System.out.println("Enter number to select option:");
		System.out.println("1: Create Account");
		System.out.println("2: Select Account");
		System.out.println("3: Logout");
		System.out.println("4: Quit Program");
		
		try {
			int optionNumber = userOption.nextInt();
			readUserMenuOptions(optionNumber);
		} catch (Exception e) {
			System.out.println("Please enter an integer.");
		}
	}
	
	public static void readUserMenuOptions(int option) {
		switch(option) {
		case 1:
			createAccount();
			break;
			
		case 2:
			selectAccount();
			break;
			
		case 3:
			System.out.println("Logout");
			break;
			
		case 4:
			System.out.println("Quit Program");
			break;
			
		default:
			System.out.println("Please select a valid option.");
		}
		
	}
	
	//TODO: Allow user to create account
	public static void createAccount() {
		
	}
	
	//TODO: Allow user to select an account
	public static void selectAccount() {
		System.out.println("Select Account");
	}
	
}
