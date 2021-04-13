import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WithdrawTester {
	
	Account withdrawTester = new Account();
	
	@Test
	void test() {
		withdrawTester.deposit(100);
		
		assertEquals(100.0, withdrawTester.withdraw(101));
		assertEquals(49.9, withdrawTester.withdraw(50.1));
		assertEquals(49.9, withdrawTester.withdraw(-2));
	}

}
