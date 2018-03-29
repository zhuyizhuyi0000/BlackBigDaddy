class Employee implements Cloneable
{
	private String name;
	private int age;
	public Employee(String name,int age)
	{
		this.name =name;
		this.age=age;
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	public String toString()
	{
		return "������"+this.name+"�����䣺"+this.age;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
}
public class CloneDemo {
	public static void main(String args[])
	{
		Employee e1=new Employee("����",20);
		Employee e2=null;
		try
		{
			e2=(Employee)e1.clone();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		e2.setName("����");
		e2.setAge(28);
		System.out.println("����������ڴ��ַ�Ƚϣ�"+(e1==e2));
		System.out.println(e1);						//toString()
		System.out.println(e2);
	}
}
