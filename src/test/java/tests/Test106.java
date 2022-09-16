package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test106 
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
		driver.get(
		  "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		//Locate and operate <select> tag drop down
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
				                                             By.name("iframeResult")));
		WebElement e=driver.findElement(By.id("cars"));
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
		//test case-3: select multiple items
		Actions act=new Actions(driver);
		act.keyDown(Keys.CONTROL)
		   .click(s.getOptions().get(1)) //2nd item
		   .click(s.getOptions().get(3)) //4th item
		   .click(s.getOptions().get(2)) //3rd item
		   .click(s.getOptions().get(0)) //1st item
		   .keyUp(Keys.CONTROL)
		   .build().perform();
		Thread.sleep(5000);
		//test case-4: get selected options
		List<WebElement> sitems=s.getAllSelectedOptions();
		for(WebElement item:sitems)
		{
			System.out.println(item.getText());
		}
		//test case-5: get 1st item in selected items
		WebElement fe=s.getFirstSelectedOption();
		System.out.println(fe.getText());
		//test case-6: deselect item
		s.deselectByIndex(3); //deselect 4th item
		Thread.sleep(5000);
		s.deselectByVisibleText("Volvo");
		Thread.sleep(5000);
		s.deselectByValue("opel");
		Thread.sleep(5000);
		s.deselectAll();
	}
}






