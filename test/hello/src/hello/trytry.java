package hello;

public class trytry {
	public static void main(String args[]){
		int x[]=new int[9];
		int cc[]={8,3,12,33,43,23,4,1,99};
		cpaixu(cc);
		shuchu(cc);
		
		
	}
	public static void cpaixu(int a[]){
		for(int x=0;x<a.length-1;x++)
			for(int y=0;y<a.length-1-x;y++){
				if(a[y]>a[y+1]){
					a[y]=a[y]+a[y+1];
					a[y+1]=a[y]-a[y+1];
					a[y]=a[y]-a[y+1];
				}
			}
	}
	public static void shuchu(int a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}System.out.println();
	}
}
