public class Account {
	
	int accountNumber;
	double accountBalance;
	double interestRate;
	
	public Account(double interestRate) {
		this.accountNumber = uniqueAccountNumber();
		this.accountBalance = 0;
		this.interestRate = interestRate;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getAccountBalance() {
		return this.accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate) {
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
			return accountBalance;
		}else {
			System.out.println("Attempted invalid withdraw amount. Account balance was not changed.");
			return accountBalance;
		}
	}
	
	/**
	 * Transfers money from one account to another by using the withdraw and deposit functions
	 * @param amount 
	 * @param receiver
	 * @return A boolean indicating if the transfer occurred successfully
	 */
	public boolean transfer(double amount, Account receiver) {
		double pastBalanceThis = this.getAccountBalance();
		double pastBalanceReceiver = receiver.getAccountBalance();
		
		this.withdraw(amount);
		receiver.deposit(amount);
		if(this.getAccountBalance() + amount == pastBalanceThis && receiver.getAccountBalance() - amount == pastBalanceReceiver) {
			return true;
		}else {
			if(this.getAccountBalance() + amount == pastBalanceThis) {
				this.deposit(amount);
			}else if(receiver.getAccountBalance() - amount == pastBalanceReceiver){
				receiver.withdraw(amount);
			}
			return false;
		}
	}
	
	public void checkInterest(){
		double annualInterest = this.calculateAnnualInterest();
		System.out.println("At a rate of " + this.interestRate*100 + "%, your annual interest is " + annualInterest);
	}
	
	public double calculateAnnualInterest() {
		return this.interestRate * this.accountBalance;
	}
	
	/**
	 * Checks if an account number already exists
	 * @param the account number to check
	 * @return true if the account number already exists and false otherwise
	 */
	public boolean accountNumberAlreadyExists(int accountNumber) {
		for(User user : User.users) {
			for(Account account : user.getAccounts()) {
				if(account.getAccountNumber() == accountNumber)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Creates a new 6 digits unique account number
	 * @return a new unique 6 digits account number
	 */
	public int uniqueAccountNumber() {
		int accountNumber = (int)(Math.random() * 900000) + 100000;
		while(accountNumberAlreadyExists(accountNumber))
			accountNumber = (int)(Math.random() * 900000) + 100000;
		return accountNumber;
	}
}
