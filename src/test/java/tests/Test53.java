package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test53
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch google
		driver.get("https://www.google.co.in");
		Thread.sleep(5000); 
		//get all hyper links
		List<WebElement> le=driver.findElements(By.tagName("a"));
		System.out.println(le.size());
		for(WebElement e:le)
		{
			driver.executeScript("arguments[0].style.border='5px dotted green';",e);
		}
		//close site
		//driver.close();
	}
}





