package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test114
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();        
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable");
        Thread.sleep(5000); 
        //Switch to frame
        WebElement f=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(f);
        //locate elements for drag and drop
        WebElement e1=driver.findElement(By.id("draggable"));
        WebElement e2=driver.findElement(By.id("droppable")); 
        driver.executeScript("arguments[0].scrollIntoView();",e1);
        Thread.sleep(5000); 
        //Perform drag and drop
        Actions act=new Actions(driver);
        act.dragAndDrop(e1,e2).perform();
	}
}
