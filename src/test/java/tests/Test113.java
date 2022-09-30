package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test113
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();  
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in");
		Thread.sleep(5000);
		//get details of radio button("::before" pseudo element) before select(JavaScript)
		String bc1=getDetailsFromPseudoElement(driver,"border-color");
		String bgc1=getDetailsFromPseudoElement(driver,"background-color");          
		System.out.println(bc1+" "+bgc1);
		//Select a radio button("::before" pseudo element) using SWD
		WebElement ne=driver.findElement(By.xpath("//label[@for='roundTrip']"));
		Actions a=new Actions(driver);
		a.moveToElement(ne).moveByOffset(-50,0).click().build().perform();
		Thread.sleep(5000);
		//get details of radio button("::before" pseudo element) after select(JavaScript)
		String bc2=getDetailsFromPseudoElement(driver,"border-color");
		String bgc2=getDetailsFromPseudoElement(driver,"background-color"); 
		System.out.println(bc2+" "+bgc2);
		//Close site
		driver.close();
	}
	
	public static String getDetailsFromPseudoElement(ChromeDriver driver, String cssProperty)
	{
		String value=(String) driver.executeScript(
				"var ne=document.querySelector('label[for=roundTrip]'); "
				+ "var pe=window.getComputedStyle(ne,'::before'); "
				+ "var y=pe.getPropertyValue('"+cssProperty+"');"
				+ "return(y);");
		return(value);
	}
}







