package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test38
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		System.out.println("Browser opened");
		//Maximize browser
		driver.manage().window().maximize();
		//define waiting time when browser is slow to show elements in page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//Launch site
		driver.get("https://www.gmail.com");
		//do login
		driver.findElement(By.name("identifier")).sendKeys("magnitiait");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button"))
																	.click();
		driver.findElement(By.name("password")).sendKeys("Magnitia@44");
		Thread.sleep(3000); //needed even if we have implicit wait also
		driver.findElement(By.xpath("//span[text()='Next']/parent::button"))
																	.click();
		//Click on compose
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		//Fill fields
		driver.findElement(By.xpath(
			 "(//div[@role='presentation']/input)[1]"))
		                          .sendKeys("aabidkool@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("stay in mute");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']"))
						.sendKeys("Hi bro,\nfollow subject\nbye");
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		//Do logout
		driver.findElement(By.xpath(
				"//a[starts-with(@aria-label,'Google Account')]")).click();
		try
		{
			driver.switchTo().frame("account");
			Thread.sleep(5000);//needed even if we have implicit wait also
			driver.findElement(By.xpath("//div[text()='Sign out']")).click();
			driver.switchTo().defaultContent(); //back to page
		}
		catch(Exception ex)
		{
			driver.findElement(By.linkText("Sign out")).click();
		}
		//close site
		driver.close();
	}
}









