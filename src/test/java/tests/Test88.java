package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test88
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Locate element and get attribute value and property value
		WebElement e=driver.findElement(By.name("q"));
		System.out.println(e.getAttribute("maxlength")); //HTML attribute
		System.out.println(e.getAttribute("clientHeight")); //HTML property
		//get attribute value only
		System.out.println(e.getDomAttribute("maxlength")); //HTML attribute
		//get property value only
		System.out.println(e.getDomProperty("clientHeight")); //HTML property
		//Close site
		driver.close();
	}
}





