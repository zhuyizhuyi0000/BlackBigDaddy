package abctest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Teststdent {
	private static stdent stdent =new stdent();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stdent.setName("baba");
		stdent.setAge(12);
		stdent.setScore(99);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals("baba",stdent.getName());
	}

	@Test
	public void testGetAge() {
		assertEquals(12,stdent.getAge());
	}

	@Test
	public void testGetScore() {
		assertEquals(99,stdent.getScore());
	}

	@Test
	public void testSay() {
		assertEquals("baba1299",stdent.say());
	}

}
