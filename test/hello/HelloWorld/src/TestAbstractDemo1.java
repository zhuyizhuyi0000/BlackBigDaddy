abstract class Person9    //抽象类可以有一般方法
{
	String name;
	int age;
	String occupation;
	public Person9(String name,int age,String occupation)
	{
		this.name=name;
		this.age =age;
		this.occupation =occupation;   //整段注释  CTRL+/
	}
	public abstract String talk();  //抽象类 子类必须覆写
}

class student8 extends Person9
{
	public student8(String name,int age,String occupation)
	{
		super(name,age,occupation);   //抽象类有构造方法，必须在子类中被调用
	}

	public String talk()
	{
		return this.name+this.age+this.occupation;
	}
}

public class TestAbstractDemo1 {
  public static void main(String args[])
  {
	  student8 x=new student8("213",23,"213");
	  System.out.println(x.talk());
	  
  }
}
