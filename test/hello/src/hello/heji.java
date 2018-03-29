package hello;

public class heji {
	public static void main(String args[]){
		long sum=0;
		long he=1;
		for(int i=1;i<=20;i++){
			he=he*i;
			sum+=he;
			System.out.println(he);
		}
		System.out.println(sum);
	}
}
