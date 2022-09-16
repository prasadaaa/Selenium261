package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test80
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://www.gmail.com");
		Thread.sleep(5000); 
		//take screenshot of a hidden element
		WebElement e=driver.findElement(By.name("hiddenPassword"));
		File dest=new File("hiddenelementpic.png"); //save in our project folder by default.
		File src=e.getScreenshotAs(OutputType.FILE); 
		//generate blank screen shot as per width & height of hidden element in page source.
		FileHandler.copy(src,dest);
		//Close site
		driver.close();
	}
}
