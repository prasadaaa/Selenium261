package tests;

import java.time.Duration;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test97
{
	public static void main(String[] args)
	{
		//Open browser
		WebDriverManager.chromedriver().setup(); 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("http://www.gmail.com");
		ExpectedCondition<Boolean> ec1=titleIs("Gmail");
		ExpectedCondition<Boolean> ec2=urlContains("https");
		wait.until(and(ec1,ec2));
		//Do login
		wait.until(visibilityOfElementLocated(
				                   By.name("identifier"))).sendKeys("magnitiait");
		wait.until(elementToBeClickable(
				               By.xpath("//*[text()='Next']/parent::*"))).click();
		wait.until(visibilityOfElementLocated(
				                    By.name("Passwd"))).sendKeys("44@Magnitia");
		wait.until(elementToBeClickable(
				               By.xpath("//*[text()='Next']/parent::*"))).click();
		wait.until(numberOfElementsToBe(By.xpath("(//table)[6]/tbody/tr"),50));
		//Click compose
		wait.until(elementToBeClickable(
				                      By.xpath("//*[text()='Compose']"))).click();
		//fill fields and send mail
		wait.until(visibilityOfElementLocated(
				By.xpath("//div[@aria-label='Search Field']//input")))
		                                   .sendKeys("rasmiranjan365barik@gmail.com");
		wait.until(visibilityOfElementLocated(
				                        By.name("subjectbox"))).sendKeys("Wishes");
		wait.until(visibilityOfElementLocated(
			 By.xpath("//div[@aria-label='Message Body']"))).sendKeys("Hi hero\nBye");
		//Wait for hidden element(not in page but in page source)
		wait.until(presenceOfElementLocated(By.name("Filedata")))
		         .sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg");
		wait.until(invisibilityOfElementLocated(By.xpath(
				                      "//div[starts-with(@aria-label,'Uploading')]")));
		wait.until(elementToBeClickable(
				      By.xpath("(//div[starts-with(@aria-label,'Send')])[2]"))).click();
		//Get output
		Pattern p=Pattern.compile("^Message sent"); //In regex, ^ means starts with
		wait.until(textMatches(By.xpath("//*[@class='vh']/span"),p));
		//Do logout
		wait.until(elementToBeClickable(
			By.xpath("//*[starts-with(@aria-label,'Google Account')]/img"))).click();
		try
		{
			wait.withTimeout(Duration.ofSeconds(5));
			wait.until(elementToBeClickable(By.linkText("Sign out"))).click();
		}
		catch(Exception ex)
		{
			wait.withTimeout(Duration.ofSeconds(20));
			wait.until(frameToBeAvailableAndSwitchToIt(
					      By.xpath("(//iframe[@role='presentation'])[2]"))); //2nd frame
			wait.until(elementToBeClickable(
					By.xpath("//div[text()='Sign out']/parent::a"))).click();
		}
		//Close site
		wait.until(visibilityOfElementLocated(
				                      By.xpath("//*[text()='Choose an account']")));
		driver.close();
	}
}
