package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test79
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://www.google.co.in");
		Thread.sleep(5000); 
		//handle banner if exists
		try
		{
			driver.switchTo().frame("callout");
			driver.findElement(By.xpath("//button[text()='No thanks']")).click();
			Thread.sleep(5000); 
			driver.switchTo().defaultContent();
		}
		catch(Exception ex)
		{
		}
		//Locate an visible element and get screenshot
		WebElement e=driver.findElement(By.xpath("//div[@aria-label='Search by voice']"));
		//Way-1: as a file
		File dest1=new File("elementpic.png"); //save in current project folder by default
		File src1=e.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1,dest1);
		//Way-2: as Base64 string
		String src2=e.getScreenshotAs(OutputType.BASE64);
		System.out.println(src2);
		//Way-3: as bytes
		byte src3[]=e.getScreenshotAs(OutputType.BYTES);
		//use src3 array in cucumber reports
		//close site
		//driver.close();

	}

}
