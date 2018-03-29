class Person8
{
	String name;
	int age;
	public String talk()
	{
		return "I'm"+this.name+",age is "+this.age;
	}
}
class student3 extends Person8
{
	String school;
	public student3(String name,int age,String school)
	{
		this.name=name;
		this.age=age;
		this.school=school;
	}
	public String talk()
	{
		return super.talk()+",I'm in"+this.school;
	}
}
public class TestoverDemo2 {
	public static void main(String args[])
	{
		student3 f=new student3("2ew",23,"32");
		System.out.println(f.talk());
	}
}
