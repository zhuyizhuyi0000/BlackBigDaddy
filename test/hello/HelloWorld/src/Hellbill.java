import java.io.UnsupportedEncodingException;


public class Hellbill {
	public static void main (String args[]) throws UnsupportedEncodingException
	  {
		String str1 = "\u5305\u5c0f\u4e4b   \u6218\u529b";
		String str2 = new String(str1.getBytes("GB2312"));
		System.out.print(str2);
	  }
}
