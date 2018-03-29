import java.io.*;

public class DataStreamDemo {
	public static void main(String args[]) throws IOException
	{
		//将数据写入某一种载体
		DataOutputStream out=new DataOutputStream(new FileOutputStream("D:\\tempp.txt"));
		double prices[]={19.88,9.22,13.22,5.23,4.23};
		int[] units={10,10,20,39,40};
		String[] descs={"diqiuren","car","cup","bed","glass"};
		
		//向数据过滤流写入主要类型
		for(int i=0;i<prices.length;i++)
		{
			//写入，用tab分开
			out.writeDouble(prices[i]);
			out.writeChar('\t');
			
			out.writeInt(units[i]);
			out.writeChar('\t');
			
			out.writeChars(descs[i]);
			out.writeChar('\n');
		}
		out.close();
		
		//将数据读出
		DataInputStream in=new DataInputStream(new FileInputStream("D:\\tempp.txt"));
		double price;
		int unit;
		StringBuffer desc;
		double total =0.0;
		
		try
		{
			//当文本被全部读出以后会抛出EOFException异常，中断循环
			while(true)
			{
				price =in.readDouble();
				in.readChar(); //跳过tab
				unit=in.readInt();
				in.readChar();
				char chr;
				desc =new StringBuffer();
				
				while ((chr=in.readChar())!='\n')
				{
					desc.append(chr);
				}
				System.out.println("订单信息："+"产品名称："+desc+",\t数量:"+unit+"，\t价格："+price);
				total=total+unit*price;
			}
		}
		catch(EOFException e)
		{
			System.out.println("\n总共需要:"+total);
		}
		in.close();
	}
}
