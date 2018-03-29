package hello;

public class trytrytrytry {
	//已知 XYZ+YZZ=532，其中，X、Y、Z 为数字，编程求出 X、Y 和 Z 的值
	public static void main(String args[]){
		int xyz=0;
		int x=0;
		int y=0;
		int z=0;
		for(xyz=100;xyz<432;xyz++){
			x=xyz/100;
			y=(xyz/10)%10;
			z=xyz%10;
			if(xyz+y*100+z*11==532){
				System.out.println("x ="+x);
				System.out.println("y ="+y);
				System.out.println("z ="+z);
				break;
				}
		}
	}
}
