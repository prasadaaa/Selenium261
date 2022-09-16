package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test83
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://www.google.co.in");
		Thread.sleep(5000); //waiting time to load complete page
		//Locate visible element and get tagname
		WebElement e=driver.findElement(By.xpath("//*[@aria-label='Search by voice']"));
		//get tag name
		String x=e.getTagName();
		System.out.println(x);
		//Close site
		driver.close();
	}
}
