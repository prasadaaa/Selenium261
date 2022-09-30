package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test112
{
	public static void main(String[] args) throws Exception
	{
		//open browser, launch site and close banner 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//Close banner if exists
		try
		{
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
		}
		//Move mouse to specific element
		WebElement e1=driver.findElement(By.xpath("//div[text()='Mobiles']"));
		Actions act=new Actions(driver);
		//move to an element
		act.moveToElement(e1).perform();
		Thread.sleep(5000);
		//Move mouse to specific area in page from current element
		act.moveByOffset(180,0).perform(); //move to right
		Thread.sleep(5000);
		//Back to previous element
		act.moveToElement(e1).perform();
		Thread.sleep(5000);
		//Move mouse to specific area in page from current element
		act.moveByOffset(-180,0).perform(); //move to left
	}
}







