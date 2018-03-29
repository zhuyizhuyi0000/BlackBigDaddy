import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



public class trylinkless 
{
		public static void main(String args[])
	{
		StringBuffer sb = new StringBuffer("");
		String content ="";
		try{
		URL url = new URL("http://youxi.baidu.com/receive_order_new.xhtml?oid=134595210947930483&store_oid=362a19a90848750b0&pay_oid=134595210947930483&amount=1&currency=CNY&store_name=baidu_wanba&pay_name=Yeepay.CMB&order_status=30&back_send=Y&return_attach=hand&sig=6331a6e9b219a61240c461c404e082a5");
//		http://10.26.221.52:8080/admin/order_find.xhtml?c=createNoticeUrl&back_send=Y&oid=362a19a90848750b0
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
