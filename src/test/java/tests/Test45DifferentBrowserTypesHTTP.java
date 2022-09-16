package tests;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test45DifferentBrowserTypesHTTP 
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver1=new ChromeDriver();//opens without history and cookies by default
		driver1.manage().window().maximize();
		//Launch site and do login via form filling
		driver1.get("http://www.testyou.in/Login.aspx"); 
		Thread.sleep(5000);
		driver1.findElement(By.xpath("(//img[contains(@src,'google.png')])[2]")).click();
		Thread.sleep(5000);
		driver1.findElement(By.name("identifier")).sendKeys("magnitiait"); 
		driver1.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver1.findElement(By.name("password")).sendKeys("Magnitia@44");
		driver1.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		//Collect all cookies from chrome browser
		Set<Cookie> s=driver1.manage().getCookies();
		ArrayList<Cookie> l=new ArrayList<Cookie>(s);
		//Take new window in firefox browser
		WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver2=new FirefoxDriver();
        //Launch same site and avoid re-login via session cookie adding
        driver2.get("http://www.testyou.in/Login.aspx"); 
      	Thread.sleep(5000);
      	//Add cookies from chrome to firefox and then refresh page
      	for(Cookie c:l)
		{
			try
			{
				driver2.manage().addCookie(c);
			}
			catch(Exception ex)
			{
			}
		}
      	driver2.navigate().refresh();
      	Thread.sleep(5000); 
     
	}
}
