class A
{
	public void fuck1()
	{
		System.out.println("1");
	}
	public void fuck2()
	{
		System.out.println("2");
	}
	
}
class B extends A
{
	public void fuck1()
	{
		System.out.println("4");
	}
	public void fuck3()
	{
		System.out.println("3");
	}
}
public class duotai {
	public static void main(String args[])
	{
	A s=new B();
	s.fuck1();
	s.fuck2();
	}
}
