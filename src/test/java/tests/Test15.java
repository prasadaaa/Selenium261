package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test15
{
	public static void main(String[] args)
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/tags/tag_input.asp");
		driver.findElement(By.linkText("Try it Yourself »")).click();
		//get source code
		Set<String> x=driver.getWindowHandles();
		System.out.println(x);
		//close all tabs/windows
		driver.quit();
	}
}







