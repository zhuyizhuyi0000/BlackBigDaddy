import java.util.Arrays;


public class arraycopy {
public static void main(String args[])
{
	int a1[]={1,2,3,4,5};
	int a2[]={9,8,7,6,5,4,3};
	System.arraycopy(a1, 1, a2, 0, 3); //����Դ������±�1��ʼ��3��Ԫ�ص�Ŀ�����飬��Ŀ�������±�0��ʼ
	int i;
	for(i=0;i<a1.length;i++)
		System.out.print(a1[i]+" ");
	System.out.println(" ");
	for(i=0;i<a2.length;i++)
		System.out.print(a2[i]+" ");
	System.out.println(" ");
	
	Arrays.sort(a2);           //��������
	for(i=0;i<a2.length;i++)
		System.out.print(a2[i]+" ");
}
}



