package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test19
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//Locate element
		WebElement e=driver.findElement(By.name("q"));
		//operate element to goto next page
		e.sendKeys("abdul kalam",Keys.ENTER);
		Thread.sleep(5000);
		//back to previous page
		driver.navigate().back(); //DOM changed
		Thread.sleep(5000);
		//operate element once again
		e.sendKeys("APJ abdul kalam",Keys.ENTER);
		Thread.sleep(5000);
	}
}






