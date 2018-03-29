package hello;

public class baoshu {
	public static void main(String args[]){
		int n=10000;
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=1;
		}
		int x=0;
		int go=0,kick=0; 
		for(;x<n;x++){
			go+=a[x];
			if(3==go){
				a[x]=0;
				go=0;
				kick++;
//				System.out.println("kick"+(x+1));
			}
			if(x==n-1 && kick != n-1){
				x=-1;
			}
			if(kick==n-1){
				break;
			}
		}
		for(int i=0;i<n;i++){
			if(1==a[i])
			System.out.println("win "+(i+1));
		}
	}
}
