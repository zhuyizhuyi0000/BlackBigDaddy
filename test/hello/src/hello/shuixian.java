package hello;

public class shuixian {
	public static void main(String args[]){
//		int a,b,c,sum1,sum2;
//		for(a=1;a<=9;a++){
//			for(b=0;b<=9;b++){
//				for(c=0;c<=9;c++){
//					sum1=a*100+b*10+c;
//					sum2=a*a*a+b*b*b+c*c*c;
//					if(sum1==sum2){
//						System.out.println(sum1);
//					}
//				}
//			}
//		}
		int m,a,b,c,m2;
		for(m=101;m<1000;m++){
			a=m/100;
			b=m%100/10;
			c=m%10;
			if(a*a*a+b*b*b+c*c*c==m){System.out.println(m);}
		}
	}
}
