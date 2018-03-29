import java.util.Arrays;


public class arraycopy {
public static void main(String args[])
{
	int a1[]={1,2,3,4,5};
	int a2[]={9,8,7,6,5,4,3};
	System.arraycopy(a1, 1, a2, 0, 3); //复制源数组从下标1开始的3个元素到目标数组，从目标数组下标0开始
	int i;
	for(i=0;i<a1.length;i++)
		System.out.print(a1[i]+" ");
	System.out.println(" ");
	for(i=0;i<a2.length;i++)
		System.out.print(a2[i]+" ");
	System.out.println(" ");
	
	Arrays.sort(a2);           //数组排序
	for(i=0;i<a2.length;i++)
		System.out.print(a2[i]+" ");
}
}



