package tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test36
{
	public static void main(String[] args) throws Exception
	{
		////Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Minimize browser
		driver.manage().window().minimize();
		Thread.sleep(5000);
		//Maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Resize browser
		Dimension d=new Dimension(300,400);
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Relocate browser on Desktop
		Point p=new Point(200,200);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//get full screen
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		//Back to normal
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}
