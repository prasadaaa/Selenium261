package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test67
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("http://www.gmail.com");
		Thread.sleep(5000); 
		//"ElementNotInteractableException" due to clear a hidden element
		driver.findElement(By.name("hiddenPassword")).clear();
	}
}
