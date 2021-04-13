import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InterestTest {

	@Test
	void testInterest() {
		Account checkingInterestTester = new Account(0);
		checkingInterestTester.deposit(100);
		Account savingInterestTester = new Account(.05);
		savingInterestTester.deposit(100);
		assertEquals(0, checkingInterestTester.calculateAnnualInterest());
		assertEquals(5, savingInterestTester.calculateAnnualInterest());
	}

}
