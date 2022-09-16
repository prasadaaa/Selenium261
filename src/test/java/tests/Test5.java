package tests;

import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test5
{
	public static void main(String[] args)
	{
		//download operadriver software to work with opera browser
		WebDriverManager.operadriver().setup();
		//Access opera browser using operadriver software
		OperaDriver driver=new OperaDriver();
		//Launch site
		driver.get("http://www.gmail.com");
	}
}
