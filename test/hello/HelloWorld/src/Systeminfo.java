import java.util.*;
public class Systeminfo {
	public static void main(String args[])
	{
		Properties sp=System.getProperties();
		Enumeration e=sp.propertyNames();
		while(e.hasMoreElements())
		{
			String key =(String)e.nextElement();
			System.out.print(key+"="+sp.getProperty(key));
		}
	}
}
