package abctest;


//公鸡五钱一只，母鸡三钱一只，小鸡一钱三只，现有百钱欲买百鸡，共有多少种买法？
public class ddma {
		public static void main(String args[]){
			for(int x=0;x<=20;x++){
				for(int y=0;y<=33;y++){
					for(int z=0;z<=100;z++){
						if((x+y+z==100)&&(5*3*x+3*3*y+z==300)){
							System.out.println("daji="+x+" muji="+y+" xiaoji="+z);
						}
					}
				}
			}
		
		int a=7;
		int b=4;
		int sum=0;
		for(int i=0;i<b;i++){
			sum+=a;
			a=a*10+a%10;
		}
		System.out.println(sum);
		
		int cdma=175;
		for(int i=2;i<=cdma;i++){
			if(cdma%i==0){
				System.out.println(i); 
				cdma/=i;
				i--;
				
			}
		}
		int c[]={23,2,34,22,3,4,32,123,43,23234,32,43,2,1};
//		for(int x=0;x<c.length;x++){
//			for(int y=0;y<c.length-1;y++){
//				if(c[y]>c[y+1]){
//					c[y]=c[y]+c[y+1];
//					c[y+1]=c[y]-c[y+1];
//					c[y]=c[y]-c[y+1];
//				}
//			}
//		}
		for(int i=0;i<c.length;i++){
		System.out.print(c[i]+" ");
		}
		
		
	}
}
