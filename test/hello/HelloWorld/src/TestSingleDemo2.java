class Person3
{
	String name;
	private static final Person3 c=new Person3();
	//在本类声明一个Person3对象p，注意此对象用final标记，表示不能再重新实例化
	//使用private只能在本类中产生实例化对象
	private Person3()
	{
		name ="张三";
	}
	public static Person3 getP()
	{
		return c;
	}
}

public class TestSingleDemo2 {
	public static void main(String[] args)
	{
		//声明一个Person3 类的对象
		Person3 p=null;	                        //声明一个Person3类，但未实例化
		p=Person3.getP();                       //调用Person类中的getP()方法，此方法返回Person3类的实例化对象
		System.out.println(p.name);
	}
}
