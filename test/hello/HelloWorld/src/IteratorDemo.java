import java.util.*;
public class IteratorDemo {
	public static void main(String args[])
	{
		ArrayList al=new ArrayList();   //ArrayList �������Ķ�̬����
		al.add("c");
		al.add("a");
		al.add("e");
		al.add("b");
		al.add("d");
		al.add("f");
		
		System.out.print("al��ԭʼ����Ϊ��");
		
		Iterator itr =al.iterator();
		while(itr.hasNext())   			//�������һ��Ԫ�أ�����true
		{
			Object element =itr.next();
			System.out.print(element +" ");
		}
		System.out.println();
		
		ListIterator litr=al.listIterator();
		while(litr.hasNext())   			//�������һ��Ԫ�أ�����true
		{
			Object element =litr.next();
			litr.set(element + "+");
		}
		System.out.print("al���޸�֮�������:");
		itr =al.iterator();
		while(itr.hasNext())
		{
			Object element =itr.next();
			System.out.print(element +" ");
		}
		System.out.println();
		
		System.out.print("���б��������");
		while(litr.hasPrevious())
		{
			Object element =litr.previous();
			System.out.print(element +" ");
		}
		System.out.println();
		
	}
	
}
