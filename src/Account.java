public class Account {
	
	double accountBalance;
	double interestRate;
	
	
	
	public Account(double interestRate) {
		this.accountBalance = 0;
		this.interestRate = interestRate;
	}



	public double deposit(double amount) {
		accountBalance += amount;
		accountBalance = Math.round(accountBalance * 100.0)/100.0;
		System.out.println("Account balance is now " + accountBalance);
		return accountBalance;
	}
	
}
