package tests;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GooglePage;

public class Test57
{
	public static void main(String[] args)
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Create object to Page class
		GooglePage gp=new GooglePage(driver);
		//Launch site
		driver.get("http://www.google.co.in");
		//Get text of link 1000 times
		long a=gp.getTimeWithoutCacheLookup();
		System.out.println("Time taken in seconds Without cache " +a); 
		//Get text of link 1000 times
		long b=gp.getTimeWithCacheLookup();
		System.out.println("Time taken in seconds With cache " +b); 
		//close site
		driver.close();
	}
}









