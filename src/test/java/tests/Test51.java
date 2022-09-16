package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test51
{
	public static void main(String[] args) throws Exception
	{
		////Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch site using base URL
		long st=System.currentTimeMillis();
		driver.navigate().to("https://www.google.co.in");//no wait for page source
		long et=System.currentTimeMillis();
		System.out.println(et-st);
		Thread.sleep(5000); //wait for page source loading and convert into page
		//close site
		driver.close();
	}
}





