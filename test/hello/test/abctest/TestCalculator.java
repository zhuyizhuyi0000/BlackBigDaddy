package abctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculator {
	private static Calculator calculator =new Calculator();
	@Test
	public void test() {
		calculator.add(12);
		calculator.add(13);
		assertEquals(25,calculator.getResult());
	}

}
