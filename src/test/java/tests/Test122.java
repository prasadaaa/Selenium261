package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test122
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();       
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("chrome://settings/");
        Thread.sleep(5000);
        //fill search box by using cssSelector expressions only
        driver.findElement(By.cssSelector("settings-ui")).getShadowRoot()
	      .findElement(By.cssSelector("#toolbar")).getShadowRoot()
	      .findElement(By.cssSelector("#search")).getShadowRoot()
	      .findElement(By.cssSelector("#searchInput")).sendKeys("abdulkalam");
	}

}
