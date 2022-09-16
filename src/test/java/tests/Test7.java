package tests;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test7
{
	public static void main(String[] args)
	{
		//download operadriver software to work with opera browser
		System.setProperty("webdriver.opera.driver",
				  "src\\test\\resources\\operadriver_win64\\operadriver.exe");
		//Access opera browser using operadriver software
		OperaOptions oo=new OperaOptions();
		oo.setBinary("C:\\Program Files\\Opera\\88.0.4412.53\\opera.exe");
		OperaDriver driver=new OperaDriver(oo);
		//Launch site
		driver.get("http://www.gmail.com");
	}
}
