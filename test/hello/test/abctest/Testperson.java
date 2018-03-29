package abctest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testperson {
	private person p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("beforeclass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("afterclass");
	}

	@Before
	public void setUp() throws Exception {
		p=new person();
		p.setAge(20);
		p.setName("baba");
		System.out.println("before****");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after====");
	}

	@Test
	public void testGetName() {
		System.out.println(p.getName());
	}

	@Test
	public void testGetAge() {
		System.out.println(p.getAge());
	}

}
