
public class switchcase {
public static void main(String args[])
{
	int a=100,b=7;
	char oper='-';
//	char oper=0;
	switch(oper)  //ѡ��ֵֻ�����ַ����߳���
	{
	case'+':
		System.out.println(a+"+"+b+"="+(a+b));
		break;
	case'-':
		System.out.println(a+"-"+b+"="+(a-b));
		break;      //û��break�ͽ�����������
	case'*':
		System.out.println(a+"*"+b+"="+(a*b));
		break;
	case 0:
		System.out.println(a+"/"+b+"="+(a/b));
		break;
	default:
		System.out.println("!");


	}
}
}
