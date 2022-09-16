package tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test56 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.amazon.com");
		Thread.sleep(5000); 
		//collect all elements
		List<WebElement> l=driver.findElements(By.xpath("//*"));
		//go to each element
		int alllinks=0;
		int correctlinks=0;
		int brokenlinks=0;
		for(WebElement e:l)
		{
			try
			{
			if(e.getAttribute("href")!=null)
			{
				String x=e.getAttribute("href");
				if(x.startsWith("https") || x.startsWith("http"))
				{
					alllinks++;
					URL u=new URL(x);
					HttpURLConnection con=(HttpURLConnection) u.openConnection();
					con.connect();
					if(con.getResponseCode()==200)
					{
						correctlinks++;
					}
					else
					{
						brokenlinks++;
						System.out.println(x+" is broken link due to "+con.getResponseMessage());
					}
				}
			}
			}
			catch(StaleElementReferenceException ex)
			{
			}
		}
		System.out.println("count of all liks "+alllinks);
		System.out.println("count of correct links "+correctlinks);
		System.out.println("count of broken links "+brokenlinks);
		//close site
		driver.close();
	}
}






