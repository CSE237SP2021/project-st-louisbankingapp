import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepositTester {

	Account depositTester = new Account(2.5);

	@Test
	void testDeposit() {
		assertEquals(0.0, depositTester.deposit(0.0));
		assertEquals(50.2, depositTester.deposit(50.2));
		assertEquals(80.2, depositTester.deposit(30.0));
		assertEquals(80.2, depositTester.deposit(-30.2));
		assertEquals(180.2, depositTester.deposit(100));
	}

}
