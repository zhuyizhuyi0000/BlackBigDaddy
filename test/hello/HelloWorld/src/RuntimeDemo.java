
public class RuntimeDemo {
	public static void main(String args[])
	{
		Runtime run =Runtime.getRuntime(); 
		try
		{
			run.exec("calc.exe");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
