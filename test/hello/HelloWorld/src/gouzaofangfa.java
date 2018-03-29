class Persons {
	
	public Persons()             //Persons类的构造方法  与类名相同，没有返回值，创建对象后自动执行
	{
		System.out.println("public Person()");
	}
		
}


public class gouzaofangfa
{
	public static void main(String args[])
	{
		new Persons();
	}
}