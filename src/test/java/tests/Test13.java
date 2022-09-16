package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test13
{
	public static void main(String[] args)
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		//get source code
		String x=driver.getPageSource();
		System.out.println(x);
		//Test case-1:
		if(x.contains("html"))
		{
			System.out.println("page designed in HTML");
		}
		else
		{
			System.out.println("page not designed in HTML");
		}
		//Test case-2:
		if(x.contains("svg"))
		{
			System.out.println("page designed in SVG");
		}
		else
		{
			System.out.println("page not designed in SVG");
		}
		//Test case-3:
		if(x.contains("shadow-root"))
		{
			System.out.println("page designed in Webcomponents");
		}
		else
		{
			System.out.println("page not designed in Webcomponents");
		}
		driver.close();
	}
}







