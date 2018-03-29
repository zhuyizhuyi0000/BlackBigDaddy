package hello;

public class discuss {
	public static void main(String args[]){
		Heihei p=new Heihei();
		p.a="hualala";
		p.b="hualala";
		System.out.println(p.ee(p.a,p.b));
	}
}
class Heihei{
	String b;
	String a;
	String name;
	
	void talk(){
		System.out.println("cc");
	}
	boolean ee(String a,String b){
		if(a.equals(b)){
			return true;
		}else{
			return false;
		}
	}
	
}
