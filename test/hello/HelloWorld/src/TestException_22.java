
public class TestException_22 {
	public static void main(String args[])
	{
		int a=4,b=0;
		try
		{
			if(b==0)
				throw new ArithmeticException("¥Ì¡À");
			else
				System.out.println(a/b);
		}
		catch(ArithmeticException e)
		{
			System.out.println("’‚¿Ô"+e);
		}
	}
}
