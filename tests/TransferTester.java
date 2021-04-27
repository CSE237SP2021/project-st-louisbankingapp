import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransferTester {
	
	Account withdrawAccount = new Account(0);
	Account depositAccount = new Account(0);
	
	@Test
	void testTransfer() {
		withdrawAccount.deposit(100);
		depositAccount.deposit(100);
		
		withdrawAccount.transfer(10, depositAccount);
		assertEquals(withdrawAccount.getAccountBalance(), 90.0);
		assertEquals(depositAccount.getAccountBalance(), 110.0);
		
		withdrawAccount.transfer(100, depositAccount);
		assertEquals(withdrawAccount.getAccountBalance(), 90.0);
		assertEquals(depositAccount.getAccountBalance(), 110.0);
		
		withdrawAccount.transfer(-10, depositAccount);
		assertEquals(withdrawAccount.getAccountBalance(), 90.0);
		assertEquals(depositAccount.getAccountBalance(), 110.0);
	}

}
