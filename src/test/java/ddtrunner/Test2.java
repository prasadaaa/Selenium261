package ddtrunner;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Test2 
{

	public static void main(String[] args) throws Exception 
	{
		// open file in read mode for getting or reading data
		File f=new File("src\\test\\resources\\propertiesfile\\dummy.properties");
		PropertiesConfiguration pc=new PropertiesConfiguration(f);
		pc.setProperty("userId", "abdul");
		pc.setProperty("email", "prasadj039@gmail.com");
		pc.save();


	}

}
