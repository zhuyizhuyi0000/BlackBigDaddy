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
		return "����:"+this.name+"�����꣺"+this.age+"��";
	}
}

public class TestObjectArray {
	public static void main(String args[])
	{
		Person p[]=
			{
				new Person("����",25),new Person("����",35),new Person("����",45)
			};
		for(int i=0;i<p.length;i++)
		{
			System.out.println(p[i].talk());
		}
	}
}
