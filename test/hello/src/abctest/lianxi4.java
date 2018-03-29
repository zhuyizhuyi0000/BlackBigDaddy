package abctest;
import java.util.*;

public class lianxi4 {
	public static void main(String args[]){
		int n=5;
		String[] name=new String[n];
		for(int i=0;i<n;i++){
			name[i]=String.valueOf(i);
		}
		List<String> list=Arrays.asList(name);
			System.out.println(list);
		Iterator itr =list.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}
		LinkedList<String> list1=new LinkedList();
		list1.add("a");list1.add("b");list1.addFirst("c");list1.addLast("d");
		System.out.println(list1);
		HashMap<String,Integer> maap=new HashMap();
		maap.put("baba",123);maap.put("lala", 123);
		System.out.println(maap);
		String sss="abcaadcaabacbb";
		int a=0;
		HashSet baba =new HashSet();
		for(int i=0,j=0;i<sss.length();){
			if(!baba.contains(sss.charAt(i))){
				baba.add(sss.charAt(i));
				i++;
				a=Math.max(a,baba.size());
//				System.out.println(baba);
			}else{
				baba.remove(sss.charAt(j));
				j++;
//				System.out.println(baba);
			}
		}
		System.out.println(a);
//		System.out.println(baba);
	}
}
