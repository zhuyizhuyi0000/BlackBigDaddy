package abctest;

import java.util.ArrayList;
import java.util.HashSet;

//题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每
//位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。

public class lianxi2 {
	public static void main(String args[]){
		int c=1634;//9816
		int[] a=new int[4];
		for(int i=0;i<4;i++){//zheli jiu huan l 
			a[i]=c%10;
			c=c/10;
		}
		for(int i=0;i<4;i++){
			a[i]+=5;
			a[i]%=10;
		}
		//int temp;
		//temp=a[0];a[0]=a[3];a[3]=temp;
		//temp=a[1];a[1]=a[2];a[2]=temp;
		String abcd=""+a[0]+a[1]+a[2]+a[3];
		System.out.println(abcd);
		
		int max=0;
		String s="abbssdcecsd";
		ArrayList<Character> set=new ArrayList();
		ArrayList<Character> set1=new ArrayList();
		for(int i=0;i<s.length();){
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
				i++;
				if(max<set.size()){
					set1.clear();
					set1.addAll(set);
				}
				max=Math.max(max, set.size());
			}else{
				set.remove(0);
			}
		}
		System.out.println(set1);
	}
	
//	public static void change(char a,char b) 内存地址定了 作用范围不一样  改变不了
}


