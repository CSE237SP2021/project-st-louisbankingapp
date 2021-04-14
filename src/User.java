import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String username;
	private String password;
	private List<Account> accounts;
	
	static List<User> users = new ArrayList<User>();
	static User currentUser;
	
	public User(String username, String password) {
		super();
		this.accounts = new ArrayList<>();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	/**
	 * Adds new user to the list of users
	 * 
	 * @param user to be added to the list
	 */
	public static void addUser(User user) {
		User.users.add(user);
	}
	
	/**
	 * Gets user by username from the list of users
	 * 
	 * @param username String of the user we are looking for
	 * @return user with username if it exists, null otherwise
	 */
	public static User getUserByUsername(String username) {
		for(User user: User.users) {
			if(user.username.equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * Checks if a username doesn't already exist in the list of users
	 * 
	 * @param username String we are searching
	 * @return true if username is unique, and false otherwise
	 */
	public static boolean isUsernameUnique(String username) {
		for(User user: User.users) {
			if(user.username.equals(username)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a combination of a username and a password is valid
	 * 
	 * @param username String to be checked if valid
	 * @param password String to be checked if valid
	 * @return true if combination is valid, and false otherwise
	 */
	public static boolean authentication(String username, String password) {
		for(User user: User.users) {
			if(user.username.equals(username)) {
				if(user.password.equals(password)) {
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
}
