package hello;

public class tuzi {
	public static void main(String args[]){
		int m =3;
		int hh=f(m);
		System.out.println(hh);
	}
	public static int f(int n){
		if (n== 1 || n== 2){
			return 1;
			}else
		return f(n-1)+f(n-2);
	}
}
