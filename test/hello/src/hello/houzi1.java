package hello;

public class houzi1 {
	public static void main(String args[]){
		int x=2,y=1,temp;
		double sum=0;
		for(int i=1;i<=20;i++){
			sum+=(double)x/y;
			temp=x;
			x=x+y;
			y=temp;
		}
		System.out.println(sum);
	}
}
