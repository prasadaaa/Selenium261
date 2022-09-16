package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test44SameBrowserTypeHTTP
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(); //opens without history and cookies by default
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site and do login
		driver.get("http://www.testyou.in/Login.aspx"); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//img[contains(@src,'google.png')])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("seleniumpractice261"); 
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Srujana@1990");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		//take new window/tab in chrome and switch to that new window/tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> swh=driver.getWindowHandles(); 
		List<String> lwh=new ArrayList<String>(swh); 
		driver.switchTo().window(lwh.get(1));
		//Launch same site by skipping login due to session cookie
		driver.get("http://www.testyou.in/Login.aspx");
		Thread.sleep(5000);
		//close all browser windows/tabs
		//driver.quit();
	}
}
