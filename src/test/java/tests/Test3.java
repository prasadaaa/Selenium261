package tests;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3
{
	public static void main(String[] args)
	{
		//download msedgedriver software to work with edge bowser
		WebDriverManager.edgedriver().setup();
		//Access Edge browser using msedgedriver software 
		EdgeDriver driver=new EdgeDriver();
		//Launch site
		driver.get("http://www.amazon.in");
	}
}
