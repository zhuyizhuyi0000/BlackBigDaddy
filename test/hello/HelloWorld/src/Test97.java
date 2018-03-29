
public class Test97 {

	static String a ="string-a";
	static String b;
	
	String c="string-c";
	String d;
	
	static{
		printStatic("before static");
		b="string-b";
		printStatic("after static");
	}
	
	public static void printStatic(String title){
	System.out.println("----------"+title+"-------------");
	System.out.println("a=\""+a+"\"");
	System.out.println("b=\""+b+"\"");
	}
	
	public Test97(){
		print("before constructor");
		d="string-d";
		print("after constructor");
	}
	
	public void print(String title){
		System.out.println("----------"+title+"-----------");
		System.out.println("a=\""+a+"\"");
		System.out.println("b=\""+b+"\"");
		System.out.println("a=\""+c+"\"");
		System.out.println("b=\""+d+"\"");
	}
	
	public static void main(String args[]){
		new Test97();
	}
	
}
