interface F
{
	int i =10;
	public void sayi();
}
interface E
{
	int x=40;
	public void saye();
}
interface G extends F,E
{
	int j=20;
	public void sayj();
}
class C implements G   //C必须实现ABE3个接口的抽象方法
{
	public void sayi()
	{
		System.out.println("i="+i);
	}
	public void sayj()
	{
		System.out.println("j="+j);
	}
	public void saye()
	{
		System.out.println("e="+x);
	}
}
public class TestInterfaceDemo {
public static void main(String[] args)
{
	C c=new C();
	c.sayi();
	c.sayj();
}
}
