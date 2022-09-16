package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test52
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch google
		driver.navigate().to("https://www.google.co.in");
		Thread.sleep(5000); 
		//goto facebook
		driver.navigate().to("https://www.facebook.com");
		Thread.sleep(5000); 
		//back to google
		driver.navigate().back();
		Thread.sleep(5000);
		//forward to facebook
		driver.navigate().forward();
		Thread.sleep(5000);
		//refresh facebook
		driver.navigate().refresh();
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}





