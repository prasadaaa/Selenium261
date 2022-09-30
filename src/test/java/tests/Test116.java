package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test116
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();    
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://jqueryui.com/slider");
		Thread.sleep(5000);
		//click on vertical slider link
		driver.findElement(By.linkText("Vertical slider")).click();
		Thread.sleep(5000);
		//switch to frame
		driver.switchTo().frame(0); //switch to frame again
		//Locate bubble in Vertical slider and move
		WebElement e=driver.findElement(By.xpath("//*[@id='slider-vertical']/span"));
		Actions act=new Actions(driver);
		act.dragAndDropBy(e,0,100).perform(); //top to bottom
		Thread.sleep(5000);
		act.dragAndDropBy(e,0,-200).perform(); //bottom to top
		Thread.sleep(5000);
		driver.switchTo().defaultContent(); //back to page
	}
}
