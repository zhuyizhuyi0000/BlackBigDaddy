class Person11
{
	String name;
	int age;
	public Person11()
	{
		System.out.println("gouzaofangfa");
	}
	Person11(String name,int age)
	{
		this();                                    //调用本类中无参构造方法
		this.name =name;
		this.age =age;
	}
	boolean compare(Person11 p)
	{
		if(this.name.equals(p.name)&&this.age==p.age)     //this表示当前对象，调用类中方法或属性的那个对象
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
public class TestCompare {
	public static void main(String agrs[])
	{
		Person11 p1=new Person11("张三",22);
		Person11 p2=new Person11("张三",22);
		System.out.println(p1.compare(p2)?"duide":"cuode");
	}
}
