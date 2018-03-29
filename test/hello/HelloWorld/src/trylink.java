import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



public class trylink 
{
		public static void main(String args[])
	{
		StringBuffer sb = new StringBuffer("");
		String content ="";
		try{
		URL url = new URL("http://youxi.baidu.com/my_charge_history.xhtml");
		@SuppressWarnings({ "deprecation", "unused" })
		String   post   =   "loginName= "   +   URLEncoder.encode("soldier0314") 
                +   "&password= "   +   URLEncoder.encode("soldier22") 
               ; 

URLConnection   conn   =   url.openConnection(); 
conn.setDoOutput(true); 
		InputStream in =url.openStream();
		
		
		while( in.read() != -1){
			int all = in.available();
			byte[] b = new byte[all];
			in.read(b);
			sb.append(new String(b,"utf-8"));
		}
		in.close();
		}catch(Exception e)
		{ 
			System.out.print("{找不到该链接，或该链接不可用：");
		}
		content = sb.toString();
		System.out.println(content);
	}
}
