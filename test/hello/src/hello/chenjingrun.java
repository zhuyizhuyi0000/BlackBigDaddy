package hello;

public class chenjingrun {
	public static void main(String args[]){
		int n=28;
		int n1=susuhe(n);
		int n2=n-n1;
		System.out.println(n+"="+n1+"+"+n2);
	}
	
	private static int susuhe(int n){
		int i=2;
		for(;i<n/2+1;i++){
			if(isprime(i)&&isprime(n-i))
				break;
		}
		return i;
	}
	
	private static boolean isprime(int n){
		for(int i=2;i<=Math.sqrt(n)+1;i++){
			if(n%i==0)
				return false;
		}
		return true;
	}
	
}
