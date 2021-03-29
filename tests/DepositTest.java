import static org.junit.jupiter.api.Assertions.*;

class DepositTest {
	Account depositTester = new Account();
	
	void testDeposit() {
		assertEquals(50.25, depositTester.deposit(50.25));
		assertEquals(80.25, depositTester.deposit(30.0));
	}
}
