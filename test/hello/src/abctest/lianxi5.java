package abctest;

import java.util.ArrayList;
import java.util.List;

public class lianxi5{
	public static void main(String args[]){
		int left=1;
		int right=22;
		boolean baba=false;
		List<Integer> list=new ArrayList();
		int tmp=0;
		for(int i=left;i<=right;i++){
			tmp=i;
			for(;tmp>0;tmp/=10){
				if(tmp%10==0){
					baba=false;
					break;
				}else if(i%(tmp%10)==0) {
					baba=true;	
				}else{
					baba=false;
					break;
				}
			}
			if(baba)list.add(i);
		}
		System.out.println(list);
	}
}