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
			signup();
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
			
			User.currentUser = User.getUserByUsername(username);
			
			UserMenu menu = new UserMenu(User.currentUser);
			menu.runMenu();
		} else {
			System.out.println("Invalid Username or Password.");
		}
	}
	
	/**
	 * Checks if the username and password are valid
	 * 
	 * @param username string to be checked if valid 
	 * @param password string to be checked if valid 
	 * @return true if the username and password are valid, false otherwise
	 */
	public static Boolean isValidUsernameAndPassword(String username, String password) {
		return User.authentication(username, password);
	}
	
	/**
	 * User can Enter a valid username and password to create a new account
	 */
	public static void signup() {		
		System.out.println("Create a new Account:");
		String username = getNewUsername();
		String password = getNewPassword();
		
		User newUser = new User(username, password);
		User.addUser(newUser);
		System.out.println("Your new account was successfully created.");

		showMenu();
	}
	
	/**
	 * Asks user to enter a valid username
	 * 
	 * @return a valid username String
	 */
	public static String getNewUsername() {
		Scanner usernameInput = new Scanner(System.in);
		System.out.println("Enter username: ");
		String username = usernameInput.nextLine();
		while(!User.isUsernameUnique(username) || username.length() < 5) {
			if(!User.isUsernameUnique(username)) {
				System.out.println("Invalid username. Username " + username + " already exists.");
			} else {
				System.out.println("Invalid username. Username must be at least 5 characters.");
			}
			System.out.println("Enter username: ");
			username = usernameInput.nextLine();
		}
		return username;
	}
	
	/**
	 * Asks user to enter a valid password
	 * 
	 * @return a valid password String
	 */
	public static String getNewPassword() {
		Scanner passwordInput = new Scanner(System.in);
		System.out.println("Enter password: ");
		String password = passwordInput.nextLine();
		System.out.println("Repeat password: ");
		String repeatedPassword = passwordInput.nextLine();
		while(!password.equals(repeatedPassword) || password.length() < 5) {
			if(!password.equals(repeatedPassword)) {
				System.out.println("Invalid password. Passwords didn't match.");
			} else {
				System.out.println("Invalid password. Password must be at least 5 characters.");
			}
			System.out.println("Enter password: ");
			password = passwordInput.nextLine();
			System.out.println("Repeat password: ");
			repeatedPassword = passwordInput.nextLine();
		}
		return password;
	}
}
