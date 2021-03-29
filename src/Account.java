public class Account {
	
	double accountBalance;
	
	public double deposit(double amount) {
		accountBalance += amount;
		accountBalance = Math.round(accountBalance * 100.0)/100.0;
		System.out.println("Account balance is now " + accountBalance);
		return accountBalance;
	}
	
}
