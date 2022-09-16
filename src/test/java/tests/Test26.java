package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test26
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://chercher.tech/practice/frames");
		Thread.sleep(5000);
		//fill text box in outer frame
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath(
				"//b[@id='topic']/following-sibling::input"))
				.sendKeys("abdul kalam sir");
		//select check box in inner frame
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		//back to page directly
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}






