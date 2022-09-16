package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test91
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://shop.polymer-project.org/");
		Thread.sleep(5000); 
		//Element is under single shadow DOM.
		driver.findElement(By.xpath("//shop-app[@page='home']"))
		      .getShadowRoot()
		      .findElement(By.linkText("Ladies T-Shirts")).click();
	}
}







