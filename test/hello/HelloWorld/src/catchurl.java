import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class catchurl {
 public static void main(String argv[]) {
  //Test t = new Test();
  //t.first();
  //Test.TSR();
  //Test.testDouPrase();
//  try {
//	  catchurl.testNetStream();
//  } catch (Exception e) {
//   e.printStackTrace();
//  }
	 
     // ��ʾ�����൱��String html=getHtml(String urlString);
    try{
	 List resultList = getContext(catchurl.testNetStream());
     for (Iterator iterator = resultList.iterator(); iterator.hasNext();)
     {
         String context = (String) iterator.next();
         System.out.println(context);
     }
     }catch (Exception e) {
       e.printStackTrace();
     	}
 }
 
 public static String testNetStream() throws Exception{
  URL url = null;
  url = new URL("http://youxi.baidu.com/zqtx/index/");
  InputStream in = url.openStream();
  byte[] b = new byte[10000];
  InputStream ins = url.openStream();
  ins.read(b);
  ins.close();
  String s = new String(b,"utf-8");
  System.out.println(s);
  return s;
 
 } 
 public static List getContext(String html) {
     List resultList = new ArrayList();
     Pattern p = Pattern.compile("<title>([^</title>]*)");//ƥ��<title>��ͷ��</title>��β���ĵ�
     Matcher m = p.matcher(html );//��ʼ����
     while (m.find()) {
         resultList.add(m.group(1));//��ȡ��ƥ��Ĳ���
     }
     return resultList;
 }
}
