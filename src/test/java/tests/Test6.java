package tests;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test6
{
	public static void main(String[] args)
	{
		//download "chromedriver software" to work with "chrome" browser
		//using static "chromedriver()" method in "WebDriverManager" class in wdm jar file
		WebDriverManager.chromedriver().browserVersion("102.0.5005.61")
		                               .driverVersion("102.0.5005.61")
		                               .arm64()
		                               .cachePath("src\\test\\resources")
		                               .setup();
		//Access chrome browser using that chromedriver software
		ChromeDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.facebook.com");
		driver.close();
	}
}
