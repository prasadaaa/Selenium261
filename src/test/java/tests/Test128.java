package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test128
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();       
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.co.in");
        Thread.sleep(5000);
        //way-2: locate element using SWD-java and operate that element using JavaScript
        WebElement e=driver.findElement(By.name("q"));
        driver.executeScript("arguments[0].value='abdul kalam';",e);
        //way-1: both locate and operate element using JavaScriptt
        driver.executeScript("document.getElementsByName('btnK')[0].click();");
	}
}







