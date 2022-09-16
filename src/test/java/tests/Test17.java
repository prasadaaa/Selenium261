package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test17
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver	driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.name("identifier")).sendKeys("xxxxxx");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button"))
																	.click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("xxxxxx");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button"))
																	.click();
		Thread.sleep(5000);
		//Click on compose
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Thread.sleep(5000);
		//Fill fields
		driver.findElement(By.name("to"))
		                          .sendKeys("xxxxx@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("stay in mute");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']"))
						.sendKeys("Hi sister,\nfollow subject\nbye sister");
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(5000);
		//Do logout
		driver.findElement(By.xpath(
				"//a[starts-with(@aria-label,'Google Account')]")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("account");
		driver.findElement(By.xpath("//div[text()='Sign out']")).click();
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}







