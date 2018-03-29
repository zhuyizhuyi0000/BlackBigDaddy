package hello;

public class trytrytrytryt {
	public static void main(String args[]){
		String abc=new StringBuffer().append("a").append("dd").toString();
		StringBuffer ddc=new StringBuffer(abc);
		ddc.reverse().toString();//反向输出  可以直接拿来对比是否是对称字符串
		System.out.println(ddc);
		
		String adc="daabbccbbaad";
		boolean n=false;
		n=new StringBuffer(adc).reverse().toString().equals(adc);
		System.out.println(n);
		
		String x=new StringBuffer(adc).insert(2, "212").toString();
		String y=new StringBuffer(adc).replace(2, 8, "12").toString();
		String z=adc.replace("a", "");
		
		System.out.println(x);
		System.out.println(y);
		System.out.println("z= "+z);
		
		boolean c=adc.contains("bba");
		boolean d=adc.startsWith("bbc",3);
		boolean e=adc.endsWith("aad");
		System.out.println(c+" "+d+" "+e);
		
		int dd=adc.indexOf("b");
		int ff=adc.lastIndexOf("a");
		
	}
}
