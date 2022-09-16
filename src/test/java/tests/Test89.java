package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test89
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://www.gmail.com");
		Thread.sleep(5000); 
		//locate an element
		WebElement e=driver.findElement(By.name("identifier"));
		if(e.isEnabled())
		{
			String x=e.getAccessibleName(); //internally SWD remembered name
			String y=e.getAriaRole(); //internally SWD remembered type
			System.out.println(x+" "+y+" is enabled");
		}
		//close site
		driver.close();

	}

}
