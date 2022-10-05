package tests;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test147b
{
	public static void main(String[] args)
	{
		//Range slider with min and max both will be changed
		//Take value from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter min value to set");
		int min=sc.nextInt(); //99
		System.out.println("Enter max value to set");
		int max=sc.nextInt(); //349
		sc.close();
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();         
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/slider/#range");
		//set values in range slider
		driver.switchTo().frame(0);
	    WebElement minslider=wait.until(ExpectedConditions.visibilityOfElementLocated(
	    		                        By.xpath("//div[@id='slider-range']/span[1]")));
	    while(true)
	    {
	    	WebElement amount=driver.findElement(By.id("amount"));
	    	String temp=amount.getAttribute("value");
	    	System.out.println(temp);
	    	if(temp.contains("$"+min) || temp.contains("$"+(min+1)))
	    	{
	    		break;
	    	}
	    	else
	    	{
	    		Actions act=new Actions(driver);
	    		act.dragAndDropBy(minslider,1,0).perform();
	    	}
	    }
	    WebElement maxslider=wait.until(ExpectedConditions.visibilityOfElementLocated(
                						By.xpath("//div[@id='slider-range']/span[2]")));
	    while(true)
	    {
	    	WebElement amount=driver.findElement(By.id("amount"));
	    	String temp=amount.getAttribute("value");
	    	System.out.println(temp);
	    	if(temp.contains("- $"+max) || temp.contains("- $"+(max+1)))
	    	{
	    		break;
	    	}
	    	else
	    	{
	    		Actions act=new Actions(driver);
	    		act.dragAndDropBy(maxslider,1,0).perform();
	    	}
	    }
	    
	}
}







