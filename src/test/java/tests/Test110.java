package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test110
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
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		//step-1: Locate <div> tag drop down
		WebElement dd=wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@id='multiple-selection']/following-sibling::div")));
		//*step-2: open that drop down
		dd.click();
		Thread.sleep(2000);
		//step-3: select items one by one in that drop down
		List<WebElement> items=dd.findElements(By.xpath("child::div[2]/div"));
		for(WebElement item:items)
		{
			item.click();
			Thread.sleep(2000);
		}
		//step-4 deselect items one by one
		List<WebElement> selecteditems=dd.findElements(By.xpath("child::a"));
		for(WebElement item:selecteditems)
		{
			item.findElement(By.xpath("child::i")).click();
			Thread.sleep(2000);
		}

	}

}
