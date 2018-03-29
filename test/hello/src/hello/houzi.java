package hello;

public class houzi {
	public static void main(String args[]){
		for(int i=1;i<=20;i++){
			System.out.print(f1(i)+" ");
		}
		System.out.println(" ");
		for(int i=1;i<=20;i++){
			System.out.print(f2(i)+" ");
		}
		System.out.println(" ");
		double sum=0;
		for(int i=1;i<=20;i++){
			sum+=(double)f1(i)/f2(i); //类型转换
			System.out.println(sum);
		}
		System.out.println(sum);
	}
	
	public static int f1(int i){
		if(i==1) {
		return 2;}else if(i==2) {
		return 3;}else
		return f1(i-2)+f1(i-1);
	}
	public static int f2(int i){
		if(i==1) {
		return 1;}else if(i==2) {
		return 2;}else
		return f2(i-2)+f2(i-1);
	}
	
}
