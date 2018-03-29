class Outer
{
	int score =95;
	void inst()
	{
		Inner in =new Inner();
		in.display();
	}
	public class Inner
	{
		void display()
		{
			System.out.println("socore:"+score);
		}
	}
}
public class InnerClassDemo3 {
	public static void main(String args[])
	{
	Outer p =new Outer();
	Outer.Inner f =p.new Inner();
	f.display();
	}
}
