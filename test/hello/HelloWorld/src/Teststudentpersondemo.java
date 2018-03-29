class Person6
{
	String name;
	int age;
	public Person6()
	{
		System.out.println("1");
	}
}

class student extends Person6
{
	String school;
	public student()
	{
		super();
		System.out.println("2");
	}
}

public class Teststudentpersondemo {
	public static void main(String args[])
	{
	student d =new student();
	}
}
