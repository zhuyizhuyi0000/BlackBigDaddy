import java.util.regex.Pattern;
import java.util.*;
import java.util.regex.Matcher;

public class zhengze {
	public static void main(String args[])
	{
		String a="love23next234csdn3423javaeye";
		String regEx="[^0-9]";
		Pattern p =Pattern.compile(regEx);
		Matcher m =p.matcher(a);
		System.out.println(m.replaceAll("").trim());

	}
}
