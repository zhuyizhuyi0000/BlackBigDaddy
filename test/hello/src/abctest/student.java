package abctest;

import java.util.ArrayList;


public class student {
	public static void main(String args[]){
		Studend stu1=new Studend("baba1",211,'男',172,"18767876561");
		Studend stu2=new Studend("baba2",212,'男',173,"18767876562");
		Studend stu3=new Studend("baba3",213,'男',174,"18767876563");
		ArrayList<Studend> listha = new ArrayList<Studend>();
		listha.add(stu1);
		listha.add(stu2);
		listha.add(stu3);
		for(Object object : listha){
			System.out.println(object);
		}
	}
	
}

class Studend{
	private String name;
	private int age;
	private char sex;
	private int height;
	private String phone;
	public Studend(){}
	public Studend(String name,int age,char sex,int height,String phone){
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.height=height;
		this.phone=phone;
	}
	public String toString(){
		return name+" "+age+" "+sex+" "+height+" "+phone;
	}
}
