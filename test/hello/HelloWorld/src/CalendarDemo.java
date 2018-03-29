import java.util.*;
public class CalendarDemo {
	public static void main(String args[])
	{
		Calendar c1=Calendar.getInstance();
		System.out.print(c1.get(c1.YEAR)+"年"+(c1.get(c1.MONTH)+1)+"月"+c1.get(c1.DAY_OF_MONTH)+"日"+c1.get(c1.HOUR_OF_DAY)+":"+c1.get(c1.MINUTE)+":"+c1.get(c1.SECOND));
				//month第一个月是0
	
		c1.add(c1.DAY_OF_YEAR,230);
		System.out.println();
		System.out.print(c1.get(c1.YEAR)+"年"+(c1.get(c1.MONTH)+1)+"月"+c1.get(c1.DAY_OF_MONTH)+"日"+c1.get(c1.HOUR_OF_DAY)+":"+c1.get(c1.MINUTE)+":"+c1.get(c1.SECOND));
		//month第一个月是0
	}
}
