package hello;
import java.util.*;

public class leiji2 {
	public static void main(String args[]){
		HashSet hs=new HashSet();
		hs.add("dd");
		hs.add("ff");
		hs.add("aa");
		hs.add("rr");
		hs.add("gg2");
		hs.add("aa");
		
		System.out.println(hs);
		
		TreeSet hs1=new TreeSet();
		hs1.add("dd");
		hs1.add("ff");
		hs1.add("aa");
		hs1.add("rr");
		hs1.add("gg2");
		hs1.add("aa");
		System.out.println(hs1);
	}
}
