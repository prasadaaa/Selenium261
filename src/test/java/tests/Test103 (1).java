package tests;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GooglePageExplicit;

public class Test103
{
	public static void main(String[] args)
	{
		//Open browser 
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Locate and operate element
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//create object to page class
		GooglePageExplicit obj=new GooglePageExplicit(driver,wait);
		//Launch site
		driver.get("http://www.google.co.in");
		obj.fillSearchbox("abdulkaklam");
		
	}
}
