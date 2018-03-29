import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class changeListsz {
	public static void main(String args[])
	{
		final int ONE_COLS = 0;
		final int TWO_COLS = 1;
		final int THR_COLS = 2;

		Workbook wb =null;
		try{
			final String fileName="E:\\first.xls";
			File file =new File(fileName);
			wb = Workbook.getWorkbook(file);//���칤��book����
		}catch(Exception e){
			e.printStackTrace();
		}
//		if(wb ==null)
//			return null;
		Sheet sheet =wb.getSheet(0);//�������������
		
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
//		System.out.println("���ƣ�"+rows+"�У�"+cols+"�С�");
		String[][] tab =new String[rows][cols];
		try
		{
		for(int r=0;r < rows;r++)
		{
			Cell[] rowCells = sheet.getRow(r);
			for(int c=0; c<3;c++)
			{
				Cell cell = rowCells[c];
				String value = cell.getContents().trim();
				tab[r][c] = value;
				
				if(tab[r][ONE_COLS]=="" && r > 0)
				tab[r][ONE_COLS] = tab[r-1][ONE_COLS];
			}
		}
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
		}
	wb.close();
	
	String regEx="[^0-9]";
	Pattern p =Pattern.compile(regEx);
	for(int c=0;c <rows;c++)
	{
		Matcher m =p.matcher(tab[c][TWO_COLS]);
//		System.out.println(m.replaceAll("").trim());
		tab[c][TWO_COLS]=m.replaceAll("").trim();
	}
	
	
//	System.out.println(tab[1][2]);
	
	String[] sArray=new String[tab.length];
	long[] STime=new long[tab.length];
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR); 
	SimpleDateFormat sp1=new SimpleDateFormat("MM��dd��");
	SimpleDateFormat sp2=new SimpleDateFormat(year+"-MM-dd");
//	SimpleDateFormat sp3=new SimpleDateFormat("MM-dd");
	

	try
	{
		for(int t=0;t < tab.length;t++)
		{
		String date = tab[t][THR_COLS].substring(0, tab[t][THR_COLS].indexOf("��")+1);
		sArray[t] = date;
		tab[t][THR_COLS]=tab[t][THR_COLS].substring(tab[t][THR_COLS].indexOf("��")+1);
		tab[t][THR_COLS]=tab[t][THR_COLS].replace("��", ":");
//		System.out.println(sArray[t]);
		Date d =sp1.parse(sArray[t]);
//		System.out.println(sp2.format(d)+" "+tab[t][THR_COLS]);
		sArray[t] = sp2.format(d);		//string��ʱ��
		STime[t] = d.getTime()/1000;   //long��ʱ�䣬�ȴ�С
		tab[t][THR_COLS] =tab[t][THR_COLS];
//		System.out.println(sArray[t]);
//		System.out.println(tab[t][THR_COLS]);
		}
	}catch(ParseException e)
	{
		e.printStackTrace();
	}
	

	final String GAME[][]={
			{"������","262"},{"ս��","281"},{"����������","308"},
			{"��Ƥ","347"},{"����ս��","345"},{"���洫��","294"},
			{"���洫��B","294B"},{"������","108"},{"СС����","220"},
			{"��������2","354"},{"����","305"},{"��Ѫ����","312"},
			{"������","355"},{"�����","344"},{"��ħն","259"},
			};
	final String TIME[][]={
			{"11:00","10:57:30"},{"10:00","9:57:30"},{"12:00","11:57:30"},
			{"15:00","14:57:30"}
			};
	for(int i=0;i<tab.length;i++)
	{
		for(int j=0;j<GAME.length;j++)
		{
			if (tab[i][ONE_COLS].equals(GAME[j][0]))
				{
				tab[i][ONE_COLS] = GAME[j][1];
				break;
				}
		}
		for(int k=0;k<TIME.length;k++)
		{
			if (tab[i][THR_COLS].equals(TIME[k][0]))
			{
			tab[i][THR_COLS] =sArray[i]+" "+TIME[k][1];
			break;
			}
		}
	}
	
	
	int[] temp = new int[sArray.length];
	for(int i=0;i<sArray.length;i++)
	{
		temp[i]=i;
	}
//	System.out.println(sArray[1]);
//	System.out.println(STime[1]);
	String tempString;
	long templong;

	for(int i=sArray.length-1;i>0;i--)
	{
		for(int j=0;j<sArray.length-1;j++)
		{
			if(STime[j]>STime[j+1])
			{
				templong = STime[j];
				STime[j] = STime[j+1];
				STime[j+1] = templong;
				
				tempString = sArray[j];
				sArray[j] = sArray[j+1];
				sArray[j+1] = tempString;
				
				temp[j]=temp[j]+temp[j+1];
				temp[j+1]=temp[j]-temp[j+1];
				temp[j]=temp[j]-temp[j+1];
			}
		}
	}
	
	
	File f =new File("E:\\kf-"+sArray[0]+".txt");
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
	try
	{
	for(int x = 0; x < tab.length; x++)
	{
	int c =temp[x];
	if (x==0 || x>=1 && !sArray[x].equals(sArray[x-1]))
		out.write(sArray[x]+"\n");
	
    for(int y = 0; y < tab[x].length; y++)
    	{
    	out.write(tab[c][y]+"\t");
    	}
    out.write("\n");
	}
	}catch(IOException e1)
	{
		e1.printStackTrace();
	}
	try
	{
		out.close();
	}
	catch(IOException e2)
	{
		e2.printStackTrace();
	}
	
//	for(int x = 0; x < tab.length; x++)
//		{
//		int c =temp[x];
//		if (x==0 || x>=1 && !sArray[x].equals(sArray[x-1]))
//			System.out.println("����Ϊ��"+sArray[x]);
//		
//        for(int y = 0; y < tab[x].length; y++)
//        	{
////          System.out.println("��" + (x+1) + "�У���" + (y+1) +"�е������ǣ�" + tab[x][y]);
//        	System.out.print(tab[c][y]+"\t");
//          }
//        System.out.println("\n");
//       }
    }
}

		

