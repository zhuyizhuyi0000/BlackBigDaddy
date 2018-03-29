class Person
{
	String name;
	int age;
	public Person()
	{
		
	}
	public Person(String name,int age)
	{
		this.name =name;
		this.age =age;
	}
	public String talk()
	{
		return "我是:"+this.name+"，今年："+this.age+"岁";
	}
}

public class TestObjectArray {
	public static void main(String args[])
	{
		Person p[]=
			{
				new Person("张三",25),new Person("李四",35),new Person("王五",45)
			};
		for(int i=0;i<p.length;i++)
		{
			System.out.println(p[i].talk());
		}
	}
}
