class Person4
{
	private String name;
	private int age;
	private void talk()
	{
		System.out.println("I'm"+name+",age is "+age);
	}
	
	public void say()
	{
		talk();
	}
	
	public void setName(String str)
	{
		name =str;
	}
	public void setAge(int a)
	{
		if(a>0)
			age =a;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}

public class TestPersonDemo5 {
	public static void main(String args[])
	{
		Person4 p=new Person4();
		p.setName("уехЩ");
		p.setAge(18);
		p.say();
	}
}
