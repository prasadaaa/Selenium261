package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test115
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
		//Horizontal slider
		driver.switchTo().frame(0); //switch to 1st frame
		//Locate bubble in Horizontal slider and move
		WebElement e=driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions act=new Actions(driver);
		act.dragAndDropBy(e,400,0).perform(); //left to right
		Thread.sleep(5000);
		act.dragAndDropBy(e,-400,0).perform(); //right to left
		Thread.sleep(5000);
		driver.switchTo().defaultContent(); //back to page
	}
}






