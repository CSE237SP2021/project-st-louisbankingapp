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
	 * User can enter a username and password to login to account
	 */
	public static void login() {
		Scanner loginInput = new Scanner(System.in);
		
		System.out.println("Login:");
		System.out.println("Enter username: ");
		String username = loginInput.nextLine();
		
		System.out.println("Enter password: ");
		String password = loginInput.nextLine();
		
		checkIfValidUser(username, password);
	}
	
	/**
	 * Checks if the username password combo is valid and runs the user menu if so
	 * @param username entered by user
	 * @param password entered by user
	 */
	public static void checkIfValidUser(String username, String password) {
		if(isValidUsernameAndPassword(username, password)) {
			System.out.println("Logged in successfully.");
			User.currentUser = User.getUserByUsername(username);
			
			UserMenu menu = new UserMenu();
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
	}
	
	/**
	 * Asks user to enter a valid username
	 * 
	 * @return a valid username String
	 */
	public static String getNewUsername() {
		Scanner usernameInput = new Scanner(System.in);
		String username = "";
		
		do {
			System.out.println("Enter username: ");
			username = usernameInput.nextLine();
		} while(!validNewUsername(username));

		return username;
	}
	
	/**
	 * Checks if the username is a valid new username
	 * @param username entered by user
	 * @return true if the username is unique and longer than 5 characters
	 */
	public static boolean validNewUsername(String username) {
		if(!User.isUsernameUnique(username)) {
			System.out.println("Invalid username. Username " + username + " already exists.");
			return false;
		} else if(username.length() < 5) {
			System.out.println("Invalid username. Username must be at least 5 characters.");
			return false;
		}
		return true;
	}
	
	/**
	 * Asks user to enter a valid password
	 * 
	 * @return a valid password String
	 */
	public static String getNewPassword() {
		Scanner passwordInput = new Scanner(System.in);
		String password, repeatedPassword = "";
		
		do {
			System.out.println("Enter password: ");
			password = passwordInput.nextLine();
			
			System.out.println("Repeat password: ");
			repeatedPassword = passwordInput.nextLine();
		} while(!validNewPasswords(password, repeatedPassword));

		return password;
	}
	
	/**
	 * Checks if the password and repeated password are valid
	 * @param password entered by user
	 * @param repeatedPassword entered by user
	 * @return returns true if the passwords match and are greater than 5 characters
	 */
	public static boolean validNewPasswords(String password, String repeatedPassword) {
		if(!password.equals(repeatedPassword)) {
			System.out.println("Invalid password. Passwords didn't match.");
			return false;
		} else if(password.length() < 5){
			System.out.println("Invalid password. Password must be at least 5 characters.");
			return false;
		}
		return true;
	}
}
