package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test30 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		//Launch site using base URL
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000); 
		try
		{
			driver.findElement(By.xpath(
			  "(//span[text()='Login'])[1]/preceding::button[1]")).click();
			Thread.sleep(5000); 
		}
		catch(Exception ex)
		{
			System.out.println("No banner this time");
		}
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("(//img[@alt='Shop Now'])[1]")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath(
				"(//img[contains(@alt,'realme Narzo')])[1]")).click();
		Thread.sleep(5000);
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		String x=driver.findElement(By.xpath(
				"//img[@id='price-info-icon']/preceding::div[3]")).getText();
		System.out.println(x);
		driver.quit();
	}
}
