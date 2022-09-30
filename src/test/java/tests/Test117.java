package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test117
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();    
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		Thread.sleep(5000);
		//1. Tool-tip is "title" attribute value for target element
		WebElement e1=driver.findElement(By.linkText("SQL"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		//2. Tool-tip is child element to target element
		WebElement e2=driver.findElement(By.xpath("//div[contains(text(),'Top')]"));
		Actions a=new Actions(driver);
		a.clickAndHold(e2).perform();
		String y=e2.findElement(By.xpath("child::span")).getText();
		System.out.println(y);
		a.release(e2).perform(); 
		//close site
		driver.close();
	}
}








