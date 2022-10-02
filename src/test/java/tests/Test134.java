package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test134 
{
	public static void main(String[] args) throws Exception
	{
		//search for target word in given text using Regexp
		Pattern p=Pattern.compile("[0-9]+");
		Matcher m=p.matcher("India won 2nd world cup in india in 2011");
		//Get count of target word's occurrences 
		int noow=0;
		while(m.find())
		{
			noow++;
			System.out.println(m.group());
		}
		System.out.println("Total count of results is "+noow);
	}
}
