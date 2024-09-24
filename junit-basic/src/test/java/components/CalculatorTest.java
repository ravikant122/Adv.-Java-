package components;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	@Test
	void addTest() {
		Calculator c = new Calculator();
		int actual = c.add(1, 2);
		int expected = 3;
		
		assertEquals(expected, actual, "its supposed to add two number"); // we can also give our own message
	}
	
	@Test
	void divideTest() {
		Calculator c = new Calculator();
		
		// some times your test needs to be some properties or services to be running or up
		// but if that service is not running or property is not present or enabled then this case doesn't needs to be run
		boolean isServerUp = false;
		assumeTrue(isServerUp); // so if this false, this test won't get run
		
		// assertThrows is to test the exception
		assertThrows(ArithmeticException.class, () -> c.divide(1, 0), () -> "its supposed to throw arithmetic exception");
		// if we give our string in lambda form then its only gonna show when the test gets failed
		// if we give in form of string then its gonna display either way but we only want this string when test failed
	}
	
	// a way to organise test cases
	@Nested
	class AddTest {
		@Test
		void addPositive () {
			Calculator c = new Calculator();
			int actual = c.add(1, 2);
			int expected = 3;
			
			assertEquals(expected, actual, "its supposed to add two positive number"); // we can also give our own message			
		}
		@Test
		void addNegative () {
			Calculator c = new Calculator();
			int actual = c.add(-1, -2);
			int expected = -3;
			
			assertEquals(expected, actual, "its supposed to add two negative number"); // we can also give our own message			
		}
	}

}
