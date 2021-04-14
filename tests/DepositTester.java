import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepositTester {

	Account depositTester = new Account(2.5);

	@Test
	void testDeposit() {
		assertEquals(0.0, depositTester.deposit(0.0));
		assertEquals(50.25, depositTester.deposit(50.25));
		assertEquals(80.25, depositTester.deposit(30.0));
	}

}
