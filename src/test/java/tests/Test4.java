package tests;

import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4
{
	public static void main(String[] args)
	{
		//download "iedriverserver software" to work with "ie" browser
		WebDriverManager.iedriver().setup();
		//Access ie browser using that iedriverserver software
		InternetExplorerDriver driver=new InternetExplorerDriver();
		//launch site
		driver.get("http://www.facebook.com");
	}
}
