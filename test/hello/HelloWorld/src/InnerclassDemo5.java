class Outer2
{
	int score =95;
	void Inst(final int s)
	{
		final int temp =20; //�ڷ����ж�����ڲ��ֻ࣬�ܷ��ʷ����е�final���͵ľֲ�����
		class Inner2
		{
			void display()
			{
				System.out.println("score ="+(score+temp+s));
			}
		}
		Inner2 in =new Inner2();
		in.display();
	}
}
public class InnerclassDemo5 {
	public static void main(String args[])
	{
		Outer2 c =new Outer2();
		c.Inst(6);
	}
}
