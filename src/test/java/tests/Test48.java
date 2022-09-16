package tests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test48
{
	public static void main(String[] args)
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(); //browser opens without history and cookies
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.gmail.com"); 
		//Add cookie(way-1)
		Cookie cc=new Cookie("magntia","abdulkalam");
		driver.manage().addCookie(cc);
		//Collect all loaded cookies along with added cookie
		Set<Cookie> s=driver.manage().getCookies();
		List<Cookie> l=new ArrayList<Cookie>(s);
		System.out.println("Count of cookies is "+s.size());
		for(Cookie c:l)
		{
			System.out.println(c.getName()+"----"+c.getValue()+"----"+c.getDomain());
		}
		//Get specific cookie using cookie's name
		Cookie c=driver.manage().getCookieNamed("NID");
		System.out.println(c.getName()+"----"+c.getValue()+"----"+c.getDomain());
		//Delete specific cookie(ex:- 2nd cookie) using Cookie class's object
		driver.manage().deleteCookie(l.get(1));
		//Delete specific cookie(ex:- 1st cookie) using name
		driver.manage().deleteCookieNamed(l.get(0).getName());
		//delete all cookies
		driver.manage().deleteAllCookies();
		//Close site
		driver.close();
	}
}

