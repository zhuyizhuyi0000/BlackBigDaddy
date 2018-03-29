package hello;

public class trytryr {
	public static void main(String args[]){
		int n=13;
		gui(n);
	}
	public static void gui(int n){
		int i=0;
		while(n!=1){
			if(n==1){
				System.out.println(n);
			}else if (n%2==0){
					n=oushu(n);
					System.out.println(n);
					i++;
				}else if(n%2!=0){
					n=jishu(n);
					System.out.println(n);
					i++;
				}
			}
		System.out.println("total = "+i);
	}
	
	public static int oushu(int a){
		if(a>1){
		return a/2;
		}else
			return 1;
	}
	public static int jishu(int a){
		if(a>1){
			return a*3+1;
		}else
			return 1;
	}
}
