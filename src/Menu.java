import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		boolean isRunning = true;
		
		while(isRunning) {
			isRunning = showMenu();
		}
	}
	
	/**
	 * Displays the menu which shows all the different options a user can choose
	 * and the user can select an option for the program to perform
	 * @return false if user enters 3 to quit, otherwise true
	 */
	public static boolean showMenu() {
		Scanner userOption = new Scanner(System.in);
		
		System.out.println("Enter number to select option:");
		System.out.println("1: Login");
		System.out.println("2: Create Account");
		System.out.println("3: Quit Program");
		
		try {
			int optionNumber = userOption.nextInt();
			return readOption(optionNumber);
		} catch (Exception e) {
			System.out.println("Please enter an integer.");
			return true;
		}
	}
	
	/**
	 * Selects what operation is performed based on the integer that is passed
	 * @param option integer read by the user
	 * @return false if option equals 3, otherwise true
	 */
	public static boolean readOption(int option) {
		switch(option) {
		case 1:
			login();
			return true;
			
		case 2:
			System.out.println("Create Account");
			return true;
			
		case 3:
			return false;
			
		default:
			System.out.println("Please select a valid option.");
			return true;
		}
	}
	
	/**
	 * User can Enter a username and password to login to account
	 */
	public static void login() {
		Scanner loginInput = new Scanner(System.in);
		
		System.out.println("Login:");
		System.out.println("Enter username: ");
		String username = loginInput.nextLine();
		
		System.out.println("Enter password: ");
		String password = loginInput.nextLine();
		
		if(isValidUsernameAndPassword(username, password)) {
			System.out.println("Logged in successfully.");
			
			//TODO: Create User object and display user menu
		} else {
			System.out.println("Invalid Username or Password.");
		}
		
	}
	
	/**
	 * Checks if the username and password are greater than 5 characters in length
	 * 
	 * @param username string to be checked if valid 
	 * @param password string to be checked if valid 
	 * @return true if the username and password are valid, false otherwise
	 */
	public static Boolean isValidUsernameAndPassword(String username, String password) {
		if(username.length() > 5 && password.length() > 5) {
			return true;
		} else {
			return false;
		}
	}
}
