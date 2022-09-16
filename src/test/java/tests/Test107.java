package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test107
{
	public static void main(String[] args)
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
		//test case: verify items of the drop down in sorted order or not
		//step-1: take items of drop down into 2 lists
		List<String> l1=new ArrayList<String>();
		List<String> l2=new ArrayList<String>();
		List<WebElement> items=s.getOptions();
		//skip 1st item(index=0) and start from 2nd item(index=1)
		for(int i=1;i<items.size();i++)
		{
			l1.add(items.get(i).getText());
			l2.add(items.get(i).getText());
		}
		//step-2: sort 1st list items
		Collections.sort(l1);
		//step-3: compare sorted 1st list with 2nd list
		if(l1.equals(l2))
		{
			System.out.println("Items are already in sorted order");
		}
		else
		{
			System.out.println("Items are not in sorted order");
		}
		//close site
		driver.close();
	}
}







