package com.game.url;


import com.game.p.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class catchUrl_dy implements Runnable{
	public String htmlcx =dt_JFrame.getCxlj();
	public String dylj  =dt_JFrame.getDylj();
	public final static String KL_dy ="#";
	public static String dyym =dt_JFrame.getDyym();
	
	public static List<LinkState> allList_dy = new ArrayList<LinkState>(); 
	
	List<LinkState> allLink_dy = new ArrayList<LinkState>();

	
	public static boolean isHTML(String htmllink)
	{
		boolean b = false;
		String ishtml ="(http|https)+://[^\\s]*";
	    if(htmllink == null || htmllink.length() <= 0 || htmllink.equals(""))
	    	return b;
		
		Pattern p = Pattern.compile(ishtml);
	    Matcher m = p.matcher(htmllink);
	    if (m.matches()) {
		b = true;
	    }
	    return b;
	}
		public static String getHTMLResource(String htmllink) throws IOException
	{
	    if(htmllink == null || htmllink.length() <= 0 || htmllink.equals("http://"))
	    	return null;
		StringBuffer sb = new StringBuffer("");
		String content ="";
		try{
		URL url = new URL(htmllink);
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
			System.out.print("{�Ҳ��������ӣ�������Ӳ����ã�"+htmllink+";}");
			String DS ="�Ҳ��������ӣ�������Ӳ����ã�"+htmllink+"\n";
       	 	dt_JFrame.settextArea_dy(DS);
		}
		content = sb.toString();
//		System.out.print(content);
		return content;
	}
	
	public static String delkongbai(String html) {
	     if(html == null || html.length() <= 0)
	    	 return null;
	     String resultList = "";
	     resultList = html.replaceAll("\n|\r", "");
//	     System.out.print(resultList);
	     return resultList;
	 }
	
	public static void getTitle(String htmllink) throws IOException {
	     if(htmllink == null || htmllink.length() <= 0){
	    	 dt_JFrame.settextArea_dy("����Ϊ��");
	    	 return;
	     }
		 String resultList = "";
	     String html ="";
	     html = catchUrl_dy.getHTMLResource(htmllink);
	     Pattern p = Pattern.compile("<title>([^</title>]*)");//ƥ��<title>��ͷ��</title>��β���ĵ�
	     Matcher m = p.matcher(html );
	     if (m.find()) {
	         resultList=m.group(1);
	         dt_JFrame.settextArea_dy("�����ҵ�ҳ��title��"+resultList);
	         return;
	     }else{
	    	 dt_JFrame.settextArea_dy("û���ҵ�title");
	    	 return;
	     }
//	     System.out.print(resultList);
	 }
	 public static List getBQ(String htmllink) throws IOException {
		 if(htmllink == null || htmllink.length() <= 0 || htmllink.equals(""))
		     return null;
		 String dd="";
		 String ff="";
		 dd =catchUrl_dy.getHTMLResource(htmllink);
		 if (dd ==null || dd.length() <=0)
			 return null;
		 ff =TestcatchUrl.delkongbai(dd);
	     List resultList = new ArrayList();
	     Pattern p = Pattern.compile("<.*?>(.*?)</.*?>");
		 Matcher m = p.matcher(ff);//��ʼ����
	     while (m.find()) {
	         resultList.add(m.group());//��ȡ��ƥ��Ĳ���
	     }
	     return resultList;
	 }
	 public static String renewJD(String html){
		 String name ="";
		 int level =0;
		 
		 String regxtt ="<.*?>(.*?)</.*?>";
		 String ccc = html;
		 Pattern p = Pattern.compile(regxtt);
		 Matcher f = p.matcher(ccc);//��ʼ����

		 if (f.matches())
		 {
			 name =f.group(1).trim();
			 if(name.contains(dyym)){
				 return name;
				 }else{
					 return "";
				 }
		 }
		 
		return null;

	 } 
	 public static List getLink(String htmllink) throws IOException {
		 if(htmllink == null || htmllink.length() <= 0 || htmllink.equals(""))
		     return null;
		 String dd="";
		 String ff="";
		 dd =catchUrl_dy.getHTMLResource(htmllink);
		 if (dd ==null || dd.length() <=0)
			 return null;
		 ff =catchUrl_dy.delkongbai(dd);
	     List resultList_dy = new ArrayList();
	     Pattern p = Pattern.compile("<a\\s.*?href=\"([^\"]+)\"[^>]*>(.*?)</a>");
		 Matcher m = p.matcher(ff);//��ʼ����
	     while (m.find()) {
	         resultList_dy.add(m.group());//��ȡ��ƥ��Ĳ���
	     }
	     return resultList_dy;
	 }
	 
	 public static LinkState renewlink(String html,String htmllink){
		 String link ="";
		 String name ="";
		 String tar  ="";
		 String father_link=htmllink;
		 int level =0;
		 
		 String regxtt ="<a\\s.*?href=\"([^\"]+)\"[^>]*>(.*?)</a>";
		 String regxtar ="<a\\s.*?target=\"([^\"]+)\"[^>]*>(.*?)</a>";
		 String ccc = html;
		 Pattern p = Pattern.compile(regxtt);
		 Matcher f = p.matcher(ccc);//��ʼ����
		 Pattern t = Pattern.compile(regxtar);
		 Matcher ar = t.matcher(ccc);//��ʼ����
		 if (f.matches())
		 {
			 link =f.group(1);
			 name =f.group(2).trim();
			 while(ar.find())
			 {
				 tar = ar.group(1);
			 }
		 }
		 return new LinkState(link,name,tar,father_link,level);
	 } 
	 
	 public void run()
	{
		if (!isHTML(htmlcx)){
			System.out.println("���˸�������Ҫ�����ַ��Ҫ����http://"+"\n"+htmlcx);
			System.exit(0);
		}
		
//		dt_JFrame.setprogressBar_dy(5); 
		try {
			getTitle(htmlcx);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		dt_JFrame.setprogressBar_dy(10); 
		List Linked_dy = null;
		try {
			Linked_dy = catchUrl_dy.getLink(htmlcx);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	//�õ���������

//		dt_JFrame.setprogressBar_dy(15); 
		
		
		
		if(!dyym.equals("")){
		List Linked_dy_gj = null;
		List allgjz =null;
		String fj ="";
		try {
			Linked_dy_gj = catchUrl_dy.getBQ(htmlcx);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	//�õ���������
		try{
		     for (Iterator<String> iterator = Linked_dy_gj.iterator(); iterator.hasNext();)	//��������
		     {
		         String gjzz =iterator.next();
		         fj=renewJD(gjzz);
		         if(!fj.equals("")){
		        	 dt_JFrame.settable_gjz(gjzz,fj);
		         }
		     }
		}catch (Exception e) {
			       e.printStackTrace();
			     }
			
		
		}
		
		
		
		
		
		try{
		     for (Iterator iterator = Linked_dy.iterator(); iterator.hasNext();)
		     {
		         String context = iterator.next().toString();
//		         System.out.println(context);
		         LinkState linkstate =catchUrl_dy.renewlink(context,htmlcx);
		         allLink_dy.add(linkstate);
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
		
//		dt_JFrame.setprogressBar_dy(25); 
		int ii =0;
		int cc =35;
		try{
		     for (Iterator<LinkState> iterator = allLink_dy.iterator(); iterator.hasNext();)	//��������
		     {
		         LinkState linkstate =iterator.next();
		         String Linkff_link = linkstate.getlink();
		         String Linkff_name = linkstate.getname();
		         String Linkff_tar = linkstate.gettar();
		         dt_JFrame.settable_dyall(Linkff_link,Linkff_name,Linkff_tar);
		        if(!dylj.equals("")){
		         if(Linkff_link.contains(dylj)){
		        	 dt_JFrame.settable_dybh(Linkff_link,Linkff_name,Linkff_tar);
		         }else{
		        	 dt_JFrame.settable_dybbh(Linkff_link,Linkff_name,Linkff_tar);
		         }
		        }
//		        if(!dyym.equals("")){
//			         if(Linkff_link.contains(dyym)){
//			        	 dt_JFrame.settable_gjz(Linkff_name,all);
//			         }
//			        }
		         
		         ii++;
		         
		         if(ii==3 && cc < 95){
//		        	 dt_JFrame.setprogressBar_dy(cc);
		        	 ii = 0;
		        	 cc = cc + 5;
		         }
		    
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
//		dt_JFrame.setprogressBar_dy(98); 
//		
//		dt_JFrame.setprogressBar_dy(100); 
		dt_JFrame.settextField(String.valueOf(allLink_dy.size()));
		dt_JFrame.setbutton_dy();
	}	
	
	
	
	
}
