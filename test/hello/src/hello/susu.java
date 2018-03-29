package hello;

public class susu {
	public static void main(String args[]){
	
		int i=212762647;
		int g=2;
		boolean c =true;
		for(int d =2;d<i ;d++ ){
			if(i%d==0){
				c = false;
				g=d;
				break;
			}else{
				g=1;
			}
		}
		String y="";
		if(c){ 
			y="丫是素数";
			System.out.println(y);
		}else{
			 y=String.valueOf(g);
			 System.out.println("丫"+c+",被"+g+"整除");
		};
		
	}
	
}
