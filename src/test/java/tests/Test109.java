package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test109
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
				By.xpath("(//div[text()='Gender'])[2]/following::div[5]")));
		//*step-2: open that drop down
		dd.click();
		Thread.sleep(2000);
		//step-3: select an item in that drop down(In xpaths, index starts with 1)
		for(int i=1;i<=6;i++)
		{
			dd.findElement(By.xpath("child::div[2]/div["+i+"]")).click();
			Thread.sleep(2000);
			dd.click();
			Thread.sleep(2000);
		}
	}
}
