package abctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class addTest {

	@Test
	public void testAdd() {
		int x=3;
		int y=4;
		AddOperation instance =new AddOperation();
		int expResult=7;
		int result=instance.add(x, y);
		assertEquals(expResult,result);
	}

}
