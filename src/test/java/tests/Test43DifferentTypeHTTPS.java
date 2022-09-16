package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test43DifferentTypeHTTPS
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver1=new ChromeDriver();
		//Maximize browser
		driver1.manage().window().maximize();
		//Launch site
		driver1.get("https://www.gmail.com");
		Thread.sleep(3000);
		//do login
		driver1.findElement(By.name("identifier")).sendKeys("magnitiait");
		driver1.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(3000);
		driver1.findElement(By.name("password")).sendKeys("Magnitia@44");
		driver1.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(3000);
		Set<Cookie> s=driver1.manage().getCookies();
		List<Cookie> l=new ArrayList<Cookie>(s);
		//Take new different browser window/tab
		WebDriverManager.firefoxdriver().setup();
		RemoteWebDriver driver2=new FirefoxDriver();
		//Maximize browser
		driver2.manage().window().maximize();
		//Launch site
		driver2.get("https://www.gmail.com");
		Thread.sleep(3000);
		//add cookies of chrome to firefox and then refresh page
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
		driver2.navigate().refresh(); //no reaction ue to HTTPS
		Thread.sleep(3000);
	}
}









