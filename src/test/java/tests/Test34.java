package tests;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test34
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch gmail site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//Do login in Gmail site
		driver.findElement(By.name("identifier")).sendKeys("xxxxxxxx"); 
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("xxxxxxxx");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		//Click compose and fill fields in Gmail site
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("to")).sendKeys("xxxxxxxx@yahoo.com");
		driver.findElement(By.name("subjectbox")).sendKeys("testing by batch261");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']"))
		                         .sendKeys("hi,\nhow are you?\nbye");
		//Send mail from Gmail site and display output message
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		Thread.sleep(5000);
		String o=driver.findElement(By.className("bAq")).getText();
		System.out.println(o);
		//Take new Window or tab and switch to it
		driver.switchTo().newWindow(WindowType.TAB); //WindowType.TAB
		Thread.sleep(5000);
		Set<String> s=driver.getWindowHandles(); //sequential set
		ArrayList<String> l=new ArrayList<String>(s); //random access
		//Switch to newly created window or tab(index is 1)
		driver.switchTo().window(l.get(1));
		//Launch yahoo site
		driver.get("http://www.yahoomail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Click on signin in Yahoo
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(5000);
		//Do login in yahoo
		driver.findElement(By.name("username")).sendKeys("xxxxxxxx");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("xxxxxxxx");
		driver.findElement(By.name("verifyPassword")).click();
		Thread.sleep(5000);
		//Click on mail button if exists
		try
		{
			driver.findElement(By.xpath("//a[@title='Mail']")).click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
		}
		//Get "from" address of latest mail in mailbox
		String x=driver.findElement(By.xpath(
				"//*[@data-test-id='virtual-list']/ul/li[3]/descendant::span[4]"))
				                                                    .getAttribute("title");
		if(x.contains("magnitiaitgmail.com"))
		{
			System.out.println("Gmail mail sent to yahoo completly working");
		}
		else
		{
			System.out.println("Gmail mail sent to yahoo not completly working");
		}
		//Do logout in yahoo
		driver.findElement(By.xpath("(//img[@alt='Profile image'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Sign out']")).click();
		Thread.sleep(5000);
		//Close yahoo site
		driver.close();
		//Switch back to Gmail
		driver.switchTo().window(l.get(0));
		//Do logout
		driver.findElement(By.xpath(
				"//a[contains(@aria-label,'Google Account')]/child::img")).click();
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.linkText("Sign out")).click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			WebElement f=driver.findElement(By.xpath("(//iframe[@role='presentation'])[2]"));
			driver.switchTo().frame(f); //2nd frame
			driver.findElement(By.xpath("//div[text()='Sign out']/parent::a")).click();
		}
		//Close gmail site
		driver.close();
	}
}
