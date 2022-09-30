package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test118
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();         
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(
        		"https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple"); 
        Thread.sleep(5000); 
        //Locate and operate multiple select drop-down developed using <select> tag
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.name("cars"));
        Select s=new Select(e);
        Actions act=new Actions(driver);
        //Select multiple items one by one
        act.keyDown(Keys.CONTROL).perform(); //Keys.META in Mac 
        act.click(s.getOptions().get(2))
        	 .click(s.getOptions().get(0))
        	 .click(s.getOptions().get(3)).build().perform();
        act.keyUp(Keys.CONTROL).perform(); //use modifier keys only(control, alt, shift)
        Thread.sleep(5000); 
        //close site
        driver.close();
	}
}
