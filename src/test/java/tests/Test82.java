package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test82
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://www.flipkart.com");
		Thread.sleep(5000); 
		//take screenshot of an element 
		//which is covered by other element like banner
		WebElement e=driver.findElement(By.xpath("//button[@type='submit']"));
		File dest=new File("coveredelementpic.png"); //save in current project folder by default
		File src=e.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,dest);
		//close site
		driver.close();
	}
}
