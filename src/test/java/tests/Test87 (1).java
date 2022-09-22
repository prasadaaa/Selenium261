package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test87
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("magnitiait");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("Passwd")).sendKeys("44@Magnitia");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		Thread.sleep(10000);
		//delete mails received in Mar,2021
		while(true) //infinite loop for pagination
		{
			//1. collect all mails in current table
			List<WebElement> mails=driver.findElements(
					                      By.xpath("(//table)[6]/tbody/tr"));
			//2. Goto each mail
			for(int i=0;i<mails.size();i++)
			{
				String msg=mails.get(i).findElement(
						By.xpath("child::td[8]/span")).getAttribute("title");
				if(msg.contains("Mar") && msg.contains("2021"))
				{
					//1.select check box
					mails.get(i).findElement(By.xpath(
							"child::td[2]/div[@role='checkbox']")).click();
					Thread.sleep(2000);
					//2. click on delete
					mails.get(i).findElement(By.xpath(
							"child::td[9]/ul/li[2]")).click();
					Thread.sleep(3000);
					//3. close output banner
					driver.findElement(By.xpath(
					  "//div[@role='alert']/descendant::div[@role='button']")).click();
					Thread.sleep(3000);
					//4. to stay in same place because next mail occupies deleted mail
					i--; 
					//5. relocate mails once again due to changes in page DOM
					mails=driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
				}
			}
			//3. goto next page
			try
			{
				String temp=driver.findElement(By.xpath("//div[@aria-label='Older']"))
														.getAttribute("aria-disabled");
				if(temp.equals("true"))
				{
					break; //terminate from loop
				}
			}
			catch(Exception ex)
			{
				//goto next page
				driver.findElement(By.xpath("//div[@aria-label='Older']")).click();
				Thread.sleep(5000);
			}
		}
		//do logout
		
		//close site
		
	}
}
