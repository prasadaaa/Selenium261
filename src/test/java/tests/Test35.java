package tests;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test35
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.yahoomail.com");
		Thread.sleep(10000);
		//Click on signin in yahoo
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(5000);
		//Do login in yahoo
		driver.findElement(By.name("username")).sendKeys("xxxxxxxx");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("xxxxxxxx");
		driver.findElement(By.name("verifyPassword")).click();
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.xpath("//*[@title='Mail']")).click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
		}
		//Do mail compose in yahoo
		driver.findElement(By.linkText("Compose")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("message-to-field")).sendKeys(
				                             "xxxxxxxx@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Subject']"))
		                                            .sendKeys("Testing");
		driver.findElement(By.xpath("//div[@aria-label='Message body']"))
		                                                 .sendKeys("hi");
		//send mail in yahoo
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		Thread.sleep(5000);
		String x=driver.findElement(By.xpath(
				"//span[contains(text(),'message')]/parent::a/parent::span"))
				.getText();
		System.out.println(x);
		//Take new Window or tab and switch to it
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> s=driver.getWindowHandles(); 
		ArrayList<String> l=new ArrayList<String>(s);
		//Switch to new window or tab(index is 1)
		driver.switchTo().window(l.get(1));
		//Launch Gmail site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//Do login in Gmail site
		driver.findElement(By.name("identifier")).sendKeys("xxxxxxxx"); 
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("xxxxxxxx");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(10000);
		//Check "from" address of latest mail
		String y=driver.findElement(By.xpath(
		 "(//table[@role='grid'])[2]/tbody/tr[1]/td[4]/div[1]/span[1]/span"))
				                                     .getAttribute("email");
		if(y.contains("magnitiabatch251"))
		{
			System.out.println("Yahoo mail sent to Gmail completly working");
		}
		else
		{
			System.out.println(
					"Yahoo mail sent to Gmail not completly working");
		}
		//do logout in Gmail
		driver.findElement(By.xpath(
				"//a[contains(@aria-label,'Google Account')]/child::img"))
        																			.click();
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.linkText("Sign out")).click();
		}
		catch(Exception ex)
		{
			WebElement f=driver.findElement(By.xpath(
					"(//iframe[@role='presentation'])[2]"));
			driver.switchTo().frame(f); //2nd frame
			driver.findElement(By.xpath(
					"//div[text()='Sign out']/parent::a")).click();
		}
		Thread.sleep(5000);
		//Close Gmail site
		driver.close();
		//Back to Yahoo
		driver.switchTo().window(l.get(0));
		//Do logout in yahoo
		driver.findElement(By.xpath("(//img[@alt='Profile image'])[1]"))
																	.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Sign out']")).click();
		Thread.sleep(5000);
		//Close yahoo site
		driver.close();
	}
}
