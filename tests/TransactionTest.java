package tests;

public class TransactionTest {
	
	
	@Test
	public void testPrintMessage() {	
	      System.out.println("Inside testPrintMessage()");    
	      assertEquals(message, messageUtil.printMessage());     
	}
}
