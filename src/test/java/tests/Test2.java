package tests;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2
{
	public static void main(String[] args)
	{
		//download geckodrier software to work with firefox bowser
		WebDriverManager.firefoxdriver().setup();
		//Access firefox browser using gecko driver
		FirefoxDriver driver=new FirefoxDriver();
		//Launch site
		driver.get("http://www.irctc.co.in");
	}
}
