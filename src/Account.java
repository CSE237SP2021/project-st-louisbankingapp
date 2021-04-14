public class Account {
	
	double accountBalance;
	double interestRate;
	
	public Account(double interestRate) {
		this.accountBalance = 0;
		this.interestRate = interestRate;
	}

	/**
	 * Deposits some amount of money into the current accountBalance
	 * @param amount
	 * @return new current accountBalance
	 */
	public double deposit(double amount) {
		if (amount > 0) {
			accountBalance += amount;
			accountBalance = Math.round(accountBalance * 100.0)/100.0;
			System.out.println("Account balance is now " + accountBalance);
			return accountBalance;
		}else {
			System.out.println("Attempted invalid deposit amount. Account balance was not changed.");
			return accountBalance;
		}
	}
	
	/**
	 * Withdraws some amount of money into the current accountBalance
	 * @param amount
	 * @return new current accountBalance
	 */
	
	public double withdraw(double amount) {
		if (amount > 0 && amount < accountBalance) {
			accountBalance -= amount;
			accountBalance = Math.round(accountBalance * 100.0)/100.0;
			System.out.println("Account balance is now " + accountBalance);
			return accountBalance;
		}else {
			System.out.println("Attempted invalid withdraw amount. Account balance was not changed.");
			return accountBalance;
		}
	}
	
	
	public void checkInterest(){
		double annualInterest = this.calculateAnnualInterest();
		System.out.println("At a rate of " + this.interestRate*100 + "%, your annual interest is " + annualInterest);
	}
	
	public double calculateAnnualInterest() {
		return this.interestRate * this.accountBalance;
	}
}
