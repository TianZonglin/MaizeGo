package ort.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testhuiche 
{
	public static String replaceBlank(String str) 
	{
		String dest ="";
		if (str!=null) 
		{
			
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	public static String replaceBlank2(String str) 
	{
        Pattern p = Pattern.compile("/s*| | | ");
        System.out.println("before:" + str);
        Matcher m = p.matcher(str);
        String after = m.replaceAll("");
        after = after.replaceAll("��", "");
        System.out.println("after:" + after);
        return after;
	}
	public static void main(String[] args) 
	{
	    System.out.println(testhuiche.replaceBlank2("just do it!"));
	}
}
