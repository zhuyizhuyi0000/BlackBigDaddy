package hello;

public class jiayibai {
	public static void main(String args[]){
		int i;
		for(i=1;i<10000;i++){
		double c=Math.sqrt(i+100);
		double d=Math.sqrt(i+268);
		if(c%1==0 && d%1==0){
		System.out.println(i+" "+c+" "+d);
		}
		}
		
		
	}
}
