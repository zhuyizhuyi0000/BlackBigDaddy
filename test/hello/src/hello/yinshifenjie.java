package hello;

public class yinshifenjie {
	public static void main(String args[]){
		int n=99999;
		System.out.print(n+"=");
		f(n);
	}
	
	public static void f(int n){
		int i,k=0;
		if(n<=1){
			k=n;
			System.out.print(" !! ");
			}
		
		for(i=2;i<n;i++){
			if(n%i==0){
				k=i;
				System.out.print(k);
				n=n/k;
				i--;
				System.out.print("*");
			}
		}
		System.out.print(n);
	}
}
