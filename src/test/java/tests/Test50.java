package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test50
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch site using base URL
		long st=System.currentTimeMillis();
		driver.get("https://www.google.co.in"); //wait and get page source
		long et=System.currentTimeMillis();
		System.out.println(et-st);
		Thread.sleep(5000); //only wait for converting into page
		//close site
		driver.close();
	}
}






