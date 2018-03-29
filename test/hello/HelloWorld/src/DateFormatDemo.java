import java.text.*;
import java.util.Date;
public class DateFormatDemo {
	public static void main(String args[])
	{
		SimpleDateFormat sp1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sp2=new SimpleDateFormat("yyyy��MM��dd�� hh��mm��ss��");
		try
		{
			Date d=sp1.parse("2005-03-14 18:30:13");
			System.out.println(sp2.format(d));
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
	}
}
