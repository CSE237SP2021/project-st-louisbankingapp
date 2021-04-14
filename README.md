# St. Louis Banking App

A banking app that has several basic features such as transfer, withdrawal, deposits, etc. Users can create a savings or checking account that will or will not have interest applied over time accordingly.
	
## Target Audience

People above 16 that have or would like a bank account.

## Key Features

* Create an account
* Withdrawal/Deposit
* Transfer
* Check Balance
* Different account types

## Iteration 1

What stories were completed:
- Create Account
- Login
- Deposit
- Create run script

What stories do we want to complete for next week?
- User Menu
- Account Menu
- Menu (Partially implemented already from other stories)
- Create Savings Account
- Create Checking Account

Anything we implemented but doesn't currently work
- Currently the deposit function works, however, it is not connected to the main function yet. There are still steps inbetween than need to be completed.

To Run:
- Use the command * sh run.sh * on the command line

## Iteration 2

What stories were completed:
- Fix Iteration 1 Issues - Deleted menu tests, added edge cases for deposit, refactored some menu methods
- Create User Menu - After logging in, a user menu is displayed
- Create Savings Account - Create Savings Account Class, still needs to be connected to the User menu as of now
- Check Interest - Method to check the interest rate, not hooked up to the menu yet
- Withdraw - user can withdraw money from account, not hooked up to the menu yet
- Create Checking Account - May or may not be done by the due date work in progress.

What stories do we want to complete for next week?
- Select Account to View
- Account Menu
- Transfer Money
- Connect Withdaw, Deposit, Check Interest, Transfer to Account Menu
- Connect Create Savings Account, Create Checking account to the User Menu

Anything we implemented but doesn't currently work
- Currently the user can create account, login to the account. After logging in the user menu is displayed which shows the, options to create either type of account, select and account or loggout. Currently only loggout is implemented, the foundation for creating both types of accounts is set up but still needs to be connected to the menu.

To Run:
- Use the command * sh run.sh * on the command line
