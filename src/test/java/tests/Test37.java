package tests;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test37
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//define time limit on default waiting of SWD code for page source from server
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		//Launch site
		driver.get("http://www.google.co.in");
	}
}









