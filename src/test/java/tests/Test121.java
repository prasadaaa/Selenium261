package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test121
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();       
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        Thread.sleep(5000);
        long st=System.currentTimeMillis();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("asdf");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("asdf");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        long et=System.currentTimeMillis();
        System.out.println(et-st);
        driver.close();
	}

}
