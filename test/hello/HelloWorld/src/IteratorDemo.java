import java.util.*;
public class IteratorDemo {
	public static void main(String args[])
	{
		ArrayList al=new ArrayList();   //ArrayList 可增长的动态数组
		al.add("c");
		al.add("a");
		al.add("e");
		al.add("b");
		al.add("d");
		al.add("f");
		
		System.out.print("al中原始内容为：");
		
		Iterator itr =al.iterator();
		while(itr.hasNext())   			//如果有下一个元素，返回true
		{
			Object element =itr.next();
			System.out.print(element +" ");
		}
		System.out.println();
		
		ListIterator litr=al.listIterator();
		while(litr.hasNext())   			//如果有下一个元素，返回true
		{
			Object element =litr.next();
			litr.set(element + "+");
		}
		System.out.print("al被修改之后的内容:");
		itr =al.iterator();
		while(itr.hasNext())
		{
			Object element =itr.next();
			System.out.print(element +" ");
		}
		System.out.println();
		
		System.out.print("将列表反向输出：");
		while(litr.hasPrevious())
		{
			Object element =litr.previous();
			System.out.print(element +" ");
		}
		System.out.println();
		
	}
	
}
