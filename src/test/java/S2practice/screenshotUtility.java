package S2practice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtility {
	
	public String screenshot(WebDriver wd , String screenpath) 
	{
	TakesScreenshot ts = ((TakesScreenshot)wd);
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 String destination = System.getProperty(".\\test-output\\screenshot.png");
	 File dest = new File(destination);
	 try {
	 FileUtils.copyFile(source,dest);}
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
	 return destination;
	
	}

}
