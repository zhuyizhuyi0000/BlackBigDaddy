class Person7
{
	String name;
	int age;
	public Person7(String name,int age)
	{
		this.name =name;
		this.age=age;
	}
}
class student2 extends Person7
{
	String school;
	public student2()
	{
		super("2",22);
	}
}

public class Teststudentperson6demone {
	public static void main(String args[])
	{
		student2 s=new student2();
		s.school="233";
		System.out.println(s.name+s.age+s.school);
	}
}
