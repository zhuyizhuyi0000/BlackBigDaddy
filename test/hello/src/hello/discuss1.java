package hello;

public class discuss1 {
	public static void main(String args[]){
	Heiheihei q=new Heiheihei();
	q.setName("black");
	q.setAge(21);
	q.say();
	int hh =q.getAge();
	System.out.println(hh);
	Heiheihei p=new Heiheihei("lalal",123);
	}
}

class Heiheihei{
	private String name;
	private int age;
	public Heiheihei(){
		System.out.println("gouzao");
	}
	public Heiheihei(String name,int age){
		this.name=name;
		this.age=age;
		say();
	}
	public void say(){
		System.out.println("baba is "+name+" and "+age+" haha ");
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age; 
	}
}
