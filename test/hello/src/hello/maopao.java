package hello;

public class maopao {
	public static void main(String args[]){
		int c[]={4,5,2,43,33,34,56,56,678,65,4567,3};
		System.out.println(c.length);
		int x,y;
		for(x=0;x<c.length;x++)
			for(y=0;y<c.length-x-1;y++){
				if(c[y]>c[y+1]){
					c[y]	=c[y+1]+c[y];
					c[y+1]	=c[y]-c[y+1];
					c[y]	=c[y]-c[y+1];
				}
			}
		for(int i=0;i<c.length;i++)
		System.out.print(c[i]+" ");
	}
}
