package abctest;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)
public class SquareTest2 {
	private static Calculator calculator =new Calculator();
	private int param;
	private int result;
	
	@Parameters
	public static Collection data(){
		return Arrays.asList(new Object[][]{
			{2,4},{0,0},{-3,9},{4,12},{3,9}
		});
	}
	
	public SquareTest2(int param,int result){
		this.param =param;
		this.result=result;
	}
	
	@Test
	public void test() {
		calculator.square(param);
		assertEquals(result,calculator.getResult());
	}

}
