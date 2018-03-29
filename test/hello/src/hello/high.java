package hello;

public class high {
	public static void main(String args[]){
		int h=10000;
		int a=h,sum=0;
		for(int i=1;i<10;i++){
			a=a/2;
			sum+=a*2;
//			System.out.println(a);
		}
		sum+=h;
		System.out.println(sum);
		System.out.println(a/2);
	}
}
