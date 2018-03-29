package hello;

public class evelen {
	public static void main(String args[]){
		int n=4,a=2,sum=0,b=0;
		sum=a;
		b=a;
		for(int i=2;i<=n;i++){
			b=b*10+a;
			sum+=b;
			System.out.println(b);
		}
		System.out.println(sum);
	}
}
