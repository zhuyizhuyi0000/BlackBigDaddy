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

public class catchUrl implements Runnable{
	public String GW =dt_JFrame.getGW();
	public String PT =dt_JFrame.getPT();
	public final static String KL ="#";
	public final static String SY ="index";
	public String GWHTML =dt_JFrame.getGWTHML();
	
	public static List<LinkState> allList = new ArrayList<LinkState>(); //放所有链接
	
	List<LinkState> allLink = new ArrayList<LinkState>();//放域下官网的链接
	List<PageState> gwLink = new ArrayList<PageState>();//放域下官网的链接
	
	static Set<String> lbLink = new TreeSet<String>();//放列表页
	
	List<String> wzLink = new ArrayList<String>();//放文章页
	
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
	public static boolean isGWHTML(String htmllink)
	{
		boolean b = false;
		String ishtml ="(http|https)+://+(youxi.baidu.com|game.skycn.com)/[^\\s]*/";
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
			System.out.print("{找不到该链接，或该链接不可用："+htmllink+";}");
			String DS ="找不到该链接，或该链接不可用："+htmllink+"\n";
       	 	dt_JFrame.settextArea(DS);
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
	
	public static String getTitle(String htmllink) throws IOException {
	     if(htmllink == null || htmllink.length() <= 0)
	    	 return "没给抓的链接";
		 String resultList = "";
	     String html ="";
	     html = catchUrl.getHTMLResource(htmllink);
	     Pattern p = Pattern.compile("<title>([^</title>]*)");//匹配<title>开头，</title>结尾的文档
	     Matcher m = p.matcher(html );
	     if (m.find()) {
	         resultList=m.group(1);
	         return resultList;
	     }else{
	    	 return "没有找到title";
	     }
//	     System.out.print(resultList);
	 }
	
	 public static List getLink(String htmllink) throws IOException {
		 if(htmllink == null || htmllink.length() <= 0 || htmllink.equals(""))
		     return null;
		 String dd="";
		 String ff="";
		 dd =catchUrl.getHTMLResource(htmllink);
		 ff =catchUrl.delkongbai(dd);
	     List resultList = new ArrayList();
	     Pattern p = Pattern.compile("<a\\s.*?href=\"([^\"]+)\"[^>]*>(.*?)</a>");
		 Matcher m = p.matcher(ff);//开始编译
	     while (m.find()) {
	         resultList.add(m.group());//获取被匹配的部分
	     }
	     return resultList;
	 }
	 
	 public static LinkState renewlink(String html,String htmllink){
		 String link ="";
		 String name ="";
		 String tar  ="";
		 String father_link=htmllink;
		 int level =0;
		 
		 String GW =dt_JFrame.getGW();
		 String PT =dt_JFrame.getPT();
		 String GWHTML =dt_JFrame.getGWTHML();
		 
		 String regxtt ="<a\\s.*?href=\"([^\"]+)\"[^>]*>(.*?)</a>";
		 String regxtar ="<a\\s.*?target=\"([^\"]+)\"[^>]*>(.*?)</a>";
		 String ccc = html;
		 Pattern p = Pattern.compile(regxtt);
		 Matcher f = p.matcher(ccc);//开始编译
		 Pattern t = Pattern.compile(regxtar);
		 Matcher ar = t.matcher(ccc);//开始编译
		 if (f.matches())
		 {
			 link =f.group(1);
			 name =f.group(2).trim();
			 while(ar.find())
			 {
				 tar = ar.group(1);
			 }
		 }
		 if(link.equals(KL) || link.equals("") || link.length()<=0 || link == null){
			 level =99;		//空连接
		 }else if(!isHTML(link)){
			 level =88;     //链接不是个网址
		 }else if(!link.contains(PT)){
			 level =9;		//非域名内链
		 }else if(link.contains("?")){
			 level =8;		//含参数
		 }else if(!link.contains(GW)){
			 level =7;		//平台内链，非此官网下链接
		 }else if(!link.contains(GW+"/")){
			 level =3;		//官网缩写后面有其他东西
		 }else{
			 String ddd =link.substring(link.lastIndexOf(GW)+GW.length()+1); 
//			 System.out.println(ddd);
			 String regexlevel="[0-9]+?";
			 Pattern q=Pattern.compile(regexlevel);
			 Matcher w=q.matcher(ddd);
			 if(w.find()){		
				level = 2;		//文章页
				}else if(link.equals(GWHTML)){
					level = 0;	//本身
				}else{
					level = 1;	//列表页
				}
		 }
//		    System.out.println(ccc);
//		    System.out.println(link);
//		    System.out.println(name);
//		    System.out.println(tar);
//		    System.out.println(father_link);
//		    System.out.println(level);
		 
		 return new LinkState(link,name,tar,father_link,level);
	 } 
	 
	 public static PageState testlink(LinkState linkstate) throws IOException
	 {
		 String title ="";
		 String state  ="";
		 String Link = linkstate.getlink();
		 title=catchUrl.getTitle(Link);
		 return new PageState(linkstate,title,state);
	 }
	public void run()
	{
//		System.out.println("1"+GWHTML);
//		System.out.println("2"+dt_JFrame.getGWTHML());
//		System.out.println("3"+GW);
//		System.out.println("4"+dt_JFrame.getGW());
//		System.out.println("5"+PT);
//		System.out.println("6"+dt_JFrame.getPT());
		if (!isHTML(GWHTML)){
			System.out.println("给了个不符合要求的网址，要带上http://"+"\n"+GWHTML);
			System.exit(0);
		}
		
		dt_JFrame.setprogressBar(5); 
		try {
			String title=catchUrl.getTitle(GWHTML);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List Linked = null;
		try {
			Linked = catchUrl.getLink(GWHTML);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	//拿到所有链接

		dt_JFrame.setprogressBar(10); 

		
		try{
		     for (Iterator iterator = Linked.iterator(); iterator.hasNext();)
		     {
		         String context = iterator.next().toString();
//		         System.out.println(context);
		         LinkState linkstate =catchUrl.renewlink(context,GWHTML);
		         String Linkcc = linkstate.getlink();//整条，父链
		         int levelcc = linkstate.getlevel();
		         if (levelcc == 1 || levelcc == 2 || levelcc == 3 && !allLink.contains(linkstate) && !Linkcc.contains(SY))
		        	 allLink.add(linkstate);
		         if (levelcc == 1 && !lbLink.contains(Linkcc) && !Linkcc.equals(GWHTML))
		        	 lbLink.add(Linkcc);
		         if (levelcc == 2 && !wzLink.contains(Linkcc))
		        	 wzLink.add(Linkcc);
		         allList.add(linkstate);
//		         System.out.println(linkstate);
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
		dt_JFrame.setprogressBar(15); 
		int i=5;
		int length =0;
		if (wzLink.size() > i){
			length =wzLink.size();	
			int middle =length/2;
			lbLink.add(wzLink.get(0)); 
			lbLink.add(wzLink.get(1)); 
			lbLink.add(wzLink.get(middle)); 
			lbLink.add(wzLink.get(length-1));
			lbLink.add(wzLink.get(length-2));
		}else{
			length = wzLink.size();
			if(length != 0){
			for(int c=0;c < length;c++)
				lbLink.add(wzLink.get(c)); 
			}//抽首页上的所有文章页做全链接检查
		}
//		System.out.println(allLink.size());
//		System.out.print(lbLink.size());
//		System.out.print(Linked.size());
//		System.out.println(allLink);
//		System.out.println(lbLink);
//		System.out.print(ff);
//		System.out.print(title);
//		System.out.print(allList);
		dt_JFrame.setprogressBar(25); 
		try{
		     for (Iterator iterator_lb = lbLink.iterator(); iterator_lb.hasNext();)//列表页的类集
		     {
		         String context_lb = iterator_lb.next().toString();	//列表页的每一个链接     
//		         System.out.println(context_lb);
//		         String title=catchUrl.getTitle(context_lb);
		 		 List Linked_lb =catchUrl.getLink(context_lb);	//将每一个链接取链接里的所有链接
		 		 
//		         System.out.println(context_lb);
//		         System.out.println(Linked_lb);
		 		try{
				     for (Iterator iterator_ed = Linked_lb.iterator(); iterator_ed.hasNext();)//A域下 取一个B链接
				     {
				         String context_ed = iterator_ed.next().toString();//域下B链接
				         LinkState linkstate = catchUrl.renewlink(context_ed,context_lb); //LinkState类
				         String Linkdd = linkstate.getlink();//linkdd:B的链接 ；context_ed：列表页中<a>的一条条 ；context_al：父链、列表页
				         int leveldd = linkstate.getlevel();

				         allList.add(linkstate);
				         if (leveldd == 1 || leveldd == 2 || leveldd == 3 && !allLink.contains(linkstate))
				         {
				        	
				        	 allLink.add(linkstate);
//				        	 System.out.println(linkstate);
				         }
				         if (leveldd == 1 && !lbLink.contains(Linkdd) && !Linkdd.contains(SY))
				         {
//				        	 lbLink.add(Linkdd);
				        	 System.out.println("未查的列表页："+Linkdd);
				        	 String Weicha ="未查的列表页："+Linkdd+"\n";
				        	 dt_JFrame.settextArea(Weicha);
				         }
				         
//				         System.out.println(catchUrl.renewlink(context,htmllink));
				     }
				     }catch (Exception e) {
				       e.printStackTrace();
				     }
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
//		System.out.println(allLink.size());
//		System.out.println(allLink);
//		try{
//		     for (Iterator<LinkState> iterator = allLink.iterator(); iterator.hasNext();)	//官网域下链接，准备测其他
//		     {
//		         LinkState linkstate =iterator.next();
//		         PageState pagestate =catchUrl.testlink(linkstate);
//		         
//		         String Linkff_link = linkstate.getlink();
//		         String Linkff_name = linkstate.getname();
//		         String Linkff_tar = linkstate.gettar();
//		         String Linkff_far = linkstate.father_link();
//		         int Linkff_level =linkstate.getlevel();
//		         String title =catchUrl.getTitle(Linkff_link);;
//		         dt_JFrame.settable_6(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level,title);
//		         
//		         gwLink.add(pagestate);
//		     }
//		     }catch (Exception e) {
//		       e.printStackTrace();
//		     }
//		try{
//		     for (Iterator<PageState> iterator = gwLink.iterator(); iterator.hasNext();)	//官网域下链接，准备测其他
//		     {
//		    	 PageState linkstate =iterator.next();
////		         System.out.println(linkstate);
//		     }
//		     }catch (Exception e) {
//		       e.printStackTrace();
//		     }
		
//		File f =new File("E:\\123321112323211.txt");
//		if(f.exists())
//			f.delete();
//		else
//			try
//			{
//			f.createNewFile();	
//			}catch(Exception e)
//			{
//				System.out.println(e.getMessage());
//			}
//		Writer out =null;
//		try
//		{
//			out = new FileWriter(f);
//		}catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		try{
//		     for (Iterator<LinkState> iterator = allList.iterator(); iterator.hasNext();)	//所有链接
//		     {
//		         LinkState linkstate =iterator.next();
//		         String Linkff = linkstate.getlink();
//		         if(linkstate.getlevel() == 99){
//		         out.write(linkstate.toString());
//		         out.write("\n");}
////		         System.out.println(Linkff);
//		     }
//		     }catch (Exception e) {
//		       e.printStackTrace();
//		     }
//		try
//		{
//			out.close();
//		}
//		catch(IOException e2)
//		{
//			e2.printStackTrace();
//		}
		dt_JFrame.setprogressBar(30); 
		int ii =0;
		int cc =35;
		try{
		     for (Iterator<LinkState> iterator = allList.iterator(); iterator.hasNext();)	//所有链接
		     {
		         LinkState linkstate =iterator.next();
		         String Linkff_link = linkstate.getlink();
		         String Linkff_name = linkstate.getname();
		         String Linkff_tar = linkstate.gettar();
		         String Linkff_far = linkstate.father_link();
		         int Linkff_level =linkstate.getlevel();
		         if(Linkff_level == 99 || Linkff_level == 88){
		        	 dt_JFrame.settableKL(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level == 9){
		        	 dt_JFrame.settableFPT(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level ==7 || Linkff_level ==8){
		        	 dt_JFrame.settableCAN(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level == 1 ||Linkff_level == 2||Linkff_level == 3 || Linkff_level == 0 ){
		        	 dt_JFrame.settableGW(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		        	 String title =catchUrl.getTitle(Linkff_link);;
			         dt_JFrame.settable_6(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level,title);
		         
		         }
		         if(Linkff_level == 99){
		        	 dt_JFrame.settable_k(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level == 88){
		        	 dt_JFrame.settable_5(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level == 9){
		        	 dt_JFrame.settable_1(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level ==8){
		        	 dt_JFrame.settable_3(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level ==7){
		        	 dt_JFrame.settable_2(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }else if(Linkff_level == 1){
		        	 dt_JFrame.settable_4(Linkff_link,Linkff_name,Linkff_tar,Linkff_far,Linkff_level);
		         }
		         ii++;
		         
		         if(ii==10 && cc < 95){
		        	 dt_JFrame.setprogressBar(cc);
		        	 ii = 0;
		        	 cc = cc + 5;
		         }
		    
		         System.out.println(linkstate);
//		         System.out.println(Linkff);
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
		dt_JFrame.setprogressBar(98); 
		try{
		     for (Iterator iterator = lbLink.iterator(); iterator.hasNext();)	//所有链接
		     {
		         String Linkff = iterator.next().toString();
		         System.out.println(Linkff);
		         String Linkff_dd = Linkff + "\n";
		         dt_JFrame.settextArea1(Linkff_dd);
		     }
		     }catch (Exception e) {
		       e.printStackTrace();
		     }
		System.out.println(allList.size());
		System.out.println(allLink.size());
		System.out.println(lbLink.size());
//		System.out.println(lbLink);
		dt_JFrame.setallList(String.valueOf(allList.size()));
		dt_JFrame.setallLink(String.valueOf(allLink.size()));
		dt_JFrame.setlbLink(String.valueOf(lbLink.size()));
		
		dt_JFrame.setprogressBar(100); 
		dt_JFrame.setbutton();
	}	
	
	
	public static void main(String[] args)
	{
//		catchUrl q =new catchUrl();
//		new Thread(q).start();
		dt_JFrame ff =new dt_JFrame();
	}
	
}
