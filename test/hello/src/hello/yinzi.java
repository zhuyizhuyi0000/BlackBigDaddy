package hello;

public class yinzi {
	public static void main(String args[]){
		for(int i=1;i<100000;i++){
			int d=f(i);
			if(i==d){
		System.out.println(d);
			}
		}
	}
	public static int f(int c){
		int sum=1,a=0,i=2;
		while(i<=c){
			if(c%i==0){
				a=i;
				c=c/i;
				sum+=a;
			}else{i++;}
		}
		
		return sum;
	}
}
