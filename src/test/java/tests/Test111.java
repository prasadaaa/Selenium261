package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test111
{
	public static void main(String[] args) throws Exception
	{
		//open browser, launch site and close banner 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.name("q"));
		Actions act=new Actions(driver);
		act.contextClick(e).perform();
	}
}







