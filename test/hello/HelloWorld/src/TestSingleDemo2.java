class Person3
{
	String name;
	private static final Person3 c=new Person3();
	//�ڱ�������һ��Person3����p��ע��˶�����final��ǣ���ʾ����������ʵ����
	//ʹ��privateֻ���ڱ����в���ʵ��������
	private Person3()
	{
		name ="����";
	}
	public static Person3 getP()
	{
		return c;
	}
}

public class TestSingleDemo2 {
	public static void main(String[] args)
	{
		//����һ��Person3 ��Ķ���
		Person3 p=null;	                        //����һ��Person3�࣬��δʵ����
		p=Person3.getP();                       //����Person���е�getP()�������˷�������Person3���ʵ��������
		System.out.println(p.name);
	}
}
