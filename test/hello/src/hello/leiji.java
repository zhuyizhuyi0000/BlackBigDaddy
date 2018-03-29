package hello;

import java.util.*;

public class leiji {
	public static void main(String args[]){
		ArrayList a=new ArrayList();
		a.add("a");
		a.add("b");
		a.add(0, "c");
		a.remove("b");
		a.remove(1);
		a.add("c");
		System.out.println(a+" "+a.size());
		
		Iterator c=a.iterator();
		while(c.hasNext()){
			Object ele = c.next();
			System.out.print(ele+" ");
		}System.out.println();
		
		ListIterator cc=a.listIterator();
		while(cc.hasNext()){
			Object elel=cc.next();
			cc.set(elel+"baba"+cc.nextIndex());
		}
		c=a.iterator();
		while(c.hasNext()){
			Object ele = c.next();
			System.out.print(ele+" ");
		}System.out.println();
		while(cc.hasPrevious()){
			System.out.print(cc.previous()+" ");
		}System.out.println();

//		一．相同点
//		都是迭代器，当需要对集合中元素进行遍历不需要干涉其遍历过程时，这两种迭代器都可以使用。
//
//		二．不同点
//		1.使用范围不同，Iterator可以应用于所有的集合，Set、List和Map和这些集合的子类型。而ListIterator只能用于List及其子类型。
//		2.ListIterator有add方法，可以向List中添加对象，而Iterator不能。
//		3.ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator不可以。
//		4.ListIterator可以定位当前索引的位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。
//		5.都可实现删除操作，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改。
		
		LinkedList ll=new LinkedList();
		ll.add("j");
		ll.add("k");
		ll.addLast("c");
		ll.add("k");
		ll.addFirst("d");
		ll.removeLast();
		Object d=ll.get(2);
		ll.set(2,d+"jdjj" );
		
		System.out.println(ll+" "+ll.size());
	}
}
