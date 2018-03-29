class Person2
{
	private String name;
	private int age;
	
	public Person2()   //如果不声明这个 用Person2()创建对象的时候会找不到构造方法导致报错
	{}
	
	public Person2(String n,int a)
	{
		name =n;
		age =a;
		System.out.println("public Person2(String n,int a)");
	}
	public String talk()
	{
		return "I'm"+name+",age is "+age;
	}
}

public class TestConstruct1 {
	public static void main(String[] args)
	{
		Person2 p =new Person2("张三",25);
				System.out.println(p.talk());
	}
}
