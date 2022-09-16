package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test32
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		//Fill active element(EmailId)
		driver.switchTo().activeElement().sendKeys("abdulkalam",Keys.TAB);
		Thread.sleep(5000);
		//Fill active element(Password)
		driver.switchTo().activeElement().sendKeys(
				"batch261",Keys.TAB, Keys.TAB);
		Thread.sleep(5000);
		//Click on active element
		driver.switchTo().activeElement().click();
	}
}

