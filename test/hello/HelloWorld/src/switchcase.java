
public class switchcase {
public static void main(String args[])
{
	int a=100,b=7;
	char oper='-';
//	char oper=0;
	switch(oper)  //选择值只能是字符或者常量
	{
	case'+':
		System.out.println(a+"+"+b+"="+(a+b));
		break;
	case'-':
		System.out.println(a+"-"+b+"="+(a-b));
		break;      //没有break就接着往下跑了
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
