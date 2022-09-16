package ddtrunner;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Test1 
{

	public static void main(String[] args) throws Exception 
	{
		// open file in read mode for getting or reading data
		File f=new File("src\\test\\resources\\propertiesfile\\dummy.properties");
		FileReader reader=new FileReader(f);
		//Load file into RAM as Properties file
		Properties p=new Properties();
		p.load(reader);
		//get properties values from that file
		System.out.println(p.getProperty("userId"));
		System.out.println(p.getProperty("password"));
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("maxwaittime"));


	}

}
