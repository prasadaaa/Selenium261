package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test105 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//launch site
		driver.get("http://www.amazon.in");
		//Locate and operate <select> tag drop down
		wait.until(ExpectedConditions.visibilityOfElementLocated(
										           By.id("nav-search-dropdown-card")));
		WebElement e=driver.findElement(By.id("searchDropdownBox"));
		Select s=new Select(e);
		//test case-1: check for single select or multi select
		if(s.isMultiple())
		{
			System.out.println("Multi select drop down");
		}
		else
		{
			System.out.println("Single select drop down");
		}
		//test case-2: get all items of that drop down
		List<WebElement> items=s.getOptions();
		System.out.println("count of tems is "+items.size());
		for(WebElement item:items)
		{
			System.out.println(item.getText());
		}
		//test case-3: select an item
		s.selectByIndex(10);
		Thread.sleep(5000);
		s.selectByVisibleText("Beauty");
		Thread.sleep(5000);
		s.selectByValue("search-alias=apparel");
	}
}






