abstract class Person9    //�����������һ�㷽��
{
	String name;
	int age;
	String occupation;
	public Person9(String name,int age,String occupation)
	{
		this.name=name;
		this.age =age;
		this.occupation =occupation;   //����ע��  CTRL+/
	}
	public abstract String talk();  //������ ������븲д
}

class student8 extends Person9
{
	public student8(String name,int age,String occupation)
	{
		super(name,age,occupation);   //�������й��췽���������������б�����
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
