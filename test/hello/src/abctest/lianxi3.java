package abctest;

public class lianxi3 {
	public static void main(String args[]){
//		dayin(yanghui(7));
		int sum=6;
		for(int i=1;i<=sum;i++){
			dayin(yanghui(i),sum);
		}
	}
	public static int[] yanghui(int n){
		int[] a=new int[n];
		a[0]=1;
		a[n-1]=1;
		if(n>2){
			int[] b=yanghui(n-1);
			for(int i=2;i<n;i++){
				a[i-1]=b[i-1]+b[i-2]; //nima 
			}
		}
		return a;
	}
	public static void dayin(int[] n,int sum){
		int a=n.length;
		int gezi=0;
		gezi=(sum-a);
		for(int b=0;b<gezi;b++){
			System.out.print(" ");
		}
		for(int i=0;i<n.length;i++){
			System.out.print(n[i]+" ");
		}
		System.out.println();
	}
}


