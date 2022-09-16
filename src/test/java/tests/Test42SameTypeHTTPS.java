package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test42SameTypeHTTPS
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
		//do login
		driver.findElement(By.name("identifier")).sendKeys("magnitiait");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Magnitia@44");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(3000);
		//Take new browser window/tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
	}
}









