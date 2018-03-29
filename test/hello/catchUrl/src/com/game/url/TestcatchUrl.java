package com.game.url;


import com.game.p.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestcatchUrl implements Runnable{
	final static String GW ="hp";
	final static String PT ="youxi.baidu.com";
	final static String KL ="#";
	final static String SY ="index";
	final static String JD ="��";
	
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
	    if(htmllink == null || htmllink.length() <= 0)
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
			return null;
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
	

	
//	 public static LinkState getJD(String html,String htmllinkcc) throws IOException{
//		 if(html == null || html.length() <= 0)
//	    	 return null;
//		 String htmlcc ="";
//	     Pattern p = Pattern.compile("<a\\s.*?href=\"([^\"]+)\"[^>]*>(.*?)</a>");
//		 Matcher m = p.matcher(html);//��ʼ����
//	     while (m.find()) {
//	         htmlcc = m.group(1);//��ȡ��ƥ��Ĳ���
//	     }
//		 String resultList = "";
//	     String htmllink = catchUrl.getHTMLResource(htmlcc);
//		 String link ="";
//		 String name ="";
//		 String tar  ="";
//		 String father_link=htmlcc;
//		 int level =0;
//		 
//		 String regxtt ="<.*?>(.*?)</.*?>";
//		 String ccc = htmllink;
//		 Pattern d = Pattern.compile(regxtt);
//		 Matcher f = d.matcher(ccc);//��ʼ����
//
//		 if (f.find())
//		 {
//			 name =f.group(1).trim();
//			 if (name.contains(JD))
//			  new LinkState(link,name,tar,father_link,level);
//		 }
//		
//	 return null;
//
//	 } 
	 
	 
	 
	 
	 public static List getBQ(String htmllink) throws IOException {
		 if(htmllink == null || htmllink.length() <= 0 || htmllink.equals(""))
		     return null;
		 String dd="";
		 String ff="";
		 dd =TestcatchUrl.getHTMLResource(htmllink);
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
	 
	 public static List getLink(String htmllink) throws IOException {
		 if(htmllink == null || htmllink.length() <= 0 || htmllink.equals(""))
		     return null;
		 String dd="";
		 String ff="";
		 dd =TestcatchUrl.getHTMLResource(htmllink);
		 if (dd ==null || dd.length() <=0)
			 return null;
		 ff =TestcatchUrl.delkongbai(dd);
	     List resultList = new ArrayList();
	     Pattern p = Pattern.compile("<a\\s.*?href=\"([^\"]+)\"[^>]*>(.*?)</a>");
		 Matcher m = p.matcher(ff);//��ʼ����
	     while (m.find()) {
	         resultList.add(m.group());//��ȡ��ƥ��Ĳ���
	     }
	     return resultList;
	 }
	 
	 public static LinkState renewlink(String html,String htmllink){
		 String link ="";
		 String name ="";
		 String tar  ="";
		 String father_link=htmllink;
		 int level =0;
		 
		 String regxtt ="<a\\s.*?href=\"([^\"]+)\"[^>]*>(.*?)</a>";
		 String ccc = html;
		 Pattern p = Pattern.compile(regxtt);
		 Matcher f = p.matcher(ccc);//��ʼ����

		 if (f.matches())
		 {
			 link =f.group(1);
		 }
		 if(link.equals(KL) || link.equals("") || link.length()<=0 || link == null){
			 level =99;		//������
		 }else if(!isHTML(link)){
			 level =88;     //���Ӳ��Ǹ���ַ
		 }else if(!link.contains(PT)){
			 level =9;		//����������
		 }else if(link.contains(SY) && !link.contains("xzcq/index")){
			 level =8;		//����index  ����
		 }else if(link.contains("select") && !link.contains("xzcq/select")){
			 level =7;		//ѡ��ҳ
		 }else if(link.contains("login_game")){
			 level =6;		//
		 }else if(link.contains("#")){
					level = 5;	//
		 }else if(link.contains("hp/") ||link.contains("ddt/") ||link.contains("zq/")||link.contains("zt/")||link.contains("ftx/")||link.contains("sgs/")||link.contains("tmz/")||link.contains("pvz/")||link.contains("xxj/")||link.contains("hzw/")||link.contains("sjqk/")||link.contains("ogzq/")){
					level = 4;	//�б�ҳ
				}else{
					level = 1;
					return new LinkState(link,name,tar,father_link,level);
				}
		  
		 return null;
	 } 
	 public static LinkState renewJD(String html,String htmllink){
		 String link ="";
		 String name ="";
		 String tar  ="";
		 String father_link=htmllink;
		 int level =0;
		 
		 String regxtt ="<.*?>(.*?)</.*?>";
		 String ccc = html;
		 Pattern p = Pattern.compile(regxtt);
		 Matcher f = p.matcher(ccc);//��ʼ����

		 if (f.matches())
		 {
			 name =f.group(1).trim();
			 if(name.contains(JD))
				 return new LinkState(link,name,tar,father_link,level);
		 }
		 
		return null;

	 } 
	
	public  void run()
	{
		String htmllink ="http://youxi.baidu.com";
		if (!isHTML(htmllink)){
			System.out.println("���˸�������Ҫ�����ַ��Ҫ����http://");
			System.exit(0);
		}
		
		
		List Linked = null;
		try {
			Linked = TestcatchUrl.getLink(htmllink);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	//�õ���������
		List Linkbq = null;
		try {
			Linkbq = TestcatchUrl.getBQ(htmllink);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	//�õ���������
		
		List<String> allList = new ArrayList<String>(); //����������
		
		List<String> allLink = new ArrayList<String>();//�����¹���������
		
		List<String> lbLink = new ArrayList<String>();//���б�ҳ
		
		List<String> wzLink = new ArrayList<String>();//������ҳ
		
		List<LinkState> JDLink = new ArrayList<LinkState>();//��jd
		

		try{
		     for (Iterator iterator = Linked.iterator(); iterator.hasNext();)
		     {
		         String context = iterator.next().toString();
//		         System.out.println(context);
		         LinkState linkstate =TestcatchUrl.renewlink(context,htmllink);
		         if (linkstate != null && !Linked.contains(linkstate.getlink()) && !linkstate.getlink().equals(htmllink)){
		         String linklink =linkstate.getlink();
		         allList.add(linklink);
		         }
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
		try{
		     for (Iterator iterator = Linkbq.iterator(); iterator.hasNext();)
		     {
		         String context = iterator.next().toString();
//		         System.out.println(context);
		         LinkState linkstate =TestcatchUrl.renewJD(context,htmllink);
		         if (linkstate != null)
		         JDLink.add(linkstate);
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
		try{
		     for (Iterator iterator_lb = allList.iterator(); iterator_lb.hasNext();)//�б�ҳ���༯
		     {
		         String context_lb = iterator_lb.next().toString();	//�б�ҳ��ÿһ������     
		         
		 		 List Linked_lb =TestcatchUrl.getLink(context_lb);	//��ÿһ������ȡ���������������
		 		 List Linkbq_lb =TestcatchUrl.getBQ(context_lb);	//�õ���������
		 		try{
				     for (Iterator iterator_ed = Linked_lb.iterator(); iterator_ed.hasNext();)//A���� ȡһ��B����
				     {
				         String context_ed = iterator_ed.next().toString();//����B����
				         LinkState linkstate = TestcatchUrl.renewlink(context_ed,context_lb); //LinkState��
				         if (linkstate != null && !allList.contains(linkstate.getlink()) && !linkstate.getlink().equals(htmllink)){
					         String linklink =linkstate.getlink();
					         allLink.add(linklink);
					         }
				     }
				     }catch (Exception e) {
				       e.printStackTrace();
				     }
		 		try{
				     for (Iterator iterator_ed = Linkbq_lb.iterator(); iterator_ed.hasNext();)
				     {
				         String context_ed = iterator_ed.next().toString();
//				         System.out.println(context);
				         LinkState linkstate =TestcatchUrl.renewJD(context_ed,context_lb);
				         if (linkstate != null)
				         JDLink.add(linkstate);
				     }
				     }catch (Exception e) {
				       e.printStackTrace();
				     }
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }

		
		try{
		     for (Iterator iterator_nk = allLink.iterator(); iterator_nk.hasNext();)//�б�ҳ���༯
		     {
		         String context_cc = iterator_nk.next().toString();	//�б�ҳ��ÿһ������     
		         
		 		 List Linked_lb =TestcatchUrl.getLink(context_cc);	//��ÿһ������ȡ���������������
		 		List Linkbq_lb =TestcatchUrl.getBQ(context_cc);	//�õ���������
		 		try{
				     for (Iterator iterator_ed = Linked_lb.iterator(); iterator_ed.hasNext();)//A���� ȡһ��B����
				     {
				         String context_dd = iterator_ed.next().toString();//����B����
				         LinkState linkstate = TestcatchUrl.renewlink(context_dd,context_cc); //LinkState��
        if (linkstate != null && !allList.contains(linkstate.getlink()) && !allLink.contains(linkstate.getlink())&& !linkstate.getlink().equals(htmllink)){
	         String linklink =linkstate.getlink();
	         lbLink.add(linklink);
	         }
				     }
				     }catch (Exception e) {
				       e.printStackTrace();
				     }
		 		try{
				     for (Iterator iterator_ed = Linkbq_lb.iterator(); iterator_ed.hasNext();)
				     {
				         String context_dd = iterator_ed.next().toString();
//				         System.out.println(context);
				         LinkState linkstate =TestcatchUrl.renewJD(context_dd,context_cc);
				         if (linkstate != null)
				         JDLink.add(linkstate);
				     }
				     }catch (Exception e) {
				       e.printStackTrace();
				     }
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
//		try{
//		     for (Iterator iterator_ck = lbLink.iterator(); iterator_ck.hasNext();)//�б�ҳ���༯
//		     {
//		         String context_cc = iterator_ck.next().toString();	//�б�ҳ��ÿһ������     
//		         
//		 		 List Linked_lb =TestcatchUrl.getLink(context_cc);	//��ÿһ������ȡ���������������
//		 		List Linkbq_lb =TestcatchUrl.getBQ(context_cc);	//�õ���������
//		 		try{
//				     for (Iterator iterator_ed = Linked_lb.iterator(); iterator_ed.hasNext();)//A���� ȡһ��B����
//				     {
//				         String context_dd = iterator_ed.next().toString();//����B����
//				         LinkState linkstate = TestcatchUrl.renewlink(context_dd,context_cc); //LinkState��
//				         if (linkstate != null){
//					         String linklink =linkstate.getlink();
//					         wzLink.add(linklink);
//					         }
//				     }
//				     }catch (Exception e) {
//				       e.printStackTrace();
//				     }
//		 		try{
//				     for (Iterator iterator_ed = Linkbq_lb.iterator(); iterator_ed.hasNext();)
//				     {
//				         String context_dd = iterator_ed.next().toString();
////				         System.out.println(context);
//				         LinkState linkstate =TestcatchUrl.renewJD(context_dd,context_cc);
//				         if (linkstate != null)
//				         JDLink.add(linkstate);
//				     }
//				     }catch (Exception e) {
//				       e.printStackTrace();
//				     }
//		     }
//		     }catch (Exception e) {
//		       e.printStackTrace();
//		     }
		
		
		try{
		     for (Iterator iterator_dk = lbLink.iterator(); iterator_dk.hasNext();)//�б�ҳ���༯
		     {
		         String context_cc = iterator_dk.next().toString();	//�б�ҳ��ÿһ������     
		         
		 
		 		List Linkbq_lb =TestcatchUrl.getBQ(context_cc);	//�õ���������

		 		try{
				     for (Iterator iterator_ed = Linkbq_lb.iterator(); iterator_ed.hasNext();)
				     {
				         String context_dd = iterator_ed.next().toString();
//				         System.out.println(context);
				         LinkState linkstate =TestcatchUrl.renewJD(context_dd,context_cc);
				         if (linkstate != null)
				         JDLink.add(linkstate);
				     }
				     }catch (Exception e) {
				       e.printStackTrace();
				     }
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
			
		File f =new File("E:\\1233211111.txt");
		if(f.exists())
			f.delete();
		else
			try
			{
			f.createNewFile();	
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		Writer out =null;
		try
		{
			out = new FileWriter(f);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		try{
		 for (Iterator<LinkState> iterator = JDLink.iterator(); iterator.hasNext();)	//��������
		 {
		     LinkState linkstate =iterator.next();
		     out.write(linkstate.toString());
		     out.write("\n");
		 }
		 out.write(JDLink.size());
		 }catch (Exception e) {
		   e.printStackTrace();
		 }
		try
		{
			out.close();
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
//		try{
//		     for (Iterator<LinkState> iterator = JDLink.iterator(); iterator.hasNext();)	//��������
//		     {
//		         LinkState linkstate =iterator.next();
//		         System.out.println(linkstate);
//		         System.out.println("1");
//		     }
//		     }catch (Exception e) {
//		       e.printStackTrace();
//		     }
//		System.out.println(JDLink.size());
	}	

//	public static void main(String[] args)
//	{
//		TestcatchUrl t =new TestcatchUrl();
//		new Thread(t).start();
//
//
//		
//	}
}
