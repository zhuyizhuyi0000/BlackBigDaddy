class Person2
{
	private String name;
	private int age;
	
	public Person2()   //������������ ��Person2()���������ʱ����Ҳ������췽�����±���
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
		Person2 p =new Person2("����",25);
				System.out.println(p.talk());
	}
}
