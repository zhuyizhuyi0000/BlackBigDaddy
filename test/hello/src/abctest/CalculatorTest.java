package abctest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runners.Parameterized.Parameters;

public class CalculatorTest {
	private static Calculator calculator =new Calculator();
	
	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}

	@Test
	public void testAdd() {
		calculator.add(0);
		calculator.add(8);
		calculator.add(12);
		assertEquals(20,calculator.getResult());
	}
	
	@Test
	public void testAdd2(){
		calculator.add(12);
		calculator.add(-2);
		assertEquals(10,calculator.getResult());
	}
	

	@Test
	public void testSubstract() {
		calculator.add(13);
		calculator.substract(3);
		assertEquals(10,calculator.getResult());
	}
	
	@Ignore("meihao")
	@Test
	public void testMultiply() {
	}

	@Test
	public void testDivide() {
		 calculator.add(12);
		 calculator.divide(3);
		 assertEquals(4,calculator.getResult());
	}

	@Test(timeout =1000)
	public void testsquareRoot() {
		calculator.squareRoot(4);
		assertEquals(2,calculator.getResult());
	}
	@Test(expected =ArithmeticException.class)
	public void divideByZero(){
		calculator.divide(0);
	}
	
	
}
