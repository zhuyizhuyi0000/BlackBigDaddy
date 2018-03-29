package abctest;

public class stringgogo {
	public static void main(String args[]){
		String abc="j呼啦啦啦，加java睡大觉";
		int length=abc.length();
		char[] stringarr =abc.toCharArray();
		
		for(int i=0;i<length;i++){
			if('j'==stringarr[i]){
				System.out.print(i);
				System.out.println();
				}
			System.out.print(stringarr[i]);
		}
	}
}
