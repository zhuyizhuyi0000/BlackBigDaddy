import java.io.*;
public class CharDemo {
	public static void main(String args[])
	{
		File d =new File("D:\\tem.txt");
		Writer out =null;
		try
		{
			out=new FileWriter(d);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		//声明了一个STRING类型的对象
		String str="HELLO WORLD!!!";
		try
		{
			//将str内容写入到文件之中
			out.write(str);
		}
		catch(IOException e1)
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
		
		Reader in=null;
		try
		{
			in=new FileReader(d);
		}
		catch(FileNotFoundException e3)
		{
			e3.printStackTrace();
		}
		
		char c1[]=new char[1024];
		int i=0;
		try
		{
			i = in.read(c1);
		}
		catch(IOException e4)
		{
			e4.printStackTrace();
		}
		try
		{
			in.close();
		}
		catch(IOException e5)
		{
			e5.printStackTrace();
		}
		try
		{
			in.close();
		}
		catch(IOException e5)
		{
			e5.printStackTrace();
		}
		
		System.out.println(new String(c1,0,i));
		for(int c=0;c<=i;c++)
			System.out.print(c1[c]+" ");
		System.out.println();
		System.out.print(c1[5]+" "+c1[6]);
	}
}
