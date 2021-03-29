public class Account {
	
	int accountBalance;
	
	public int deposit(int amount) {
		accountBalance += amount;
		System.out.println("Account balance is now " + accountBalance);
		return accountBalance;
	}
	
}
