package S2practice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class registration {
	WebDriver wd ;
	
	
@BeforeTest
public void beforeTest() throws InterruptedException {
	 WebDriverManager.chromedriver().setup();
	  wd = new ChromeDriver();	
	  Thread.sleep(1000);
	  }


  @Test(dataProvider="getdata")
  public void register_Webshop(Map<String,List<String>>reguser) throws InterruptedException {
	  
	 wd.get("https://demowebshop.tricentis.com/");
	 Thread.sleep(2000);
	 String Gender =null ;
	 String fname =null;
	 String lname =null;
	 String email = null;

        for(Map.Entry<String,List<String>>entry:reguser.entrySet())
        {
        	String user =entry.getValue().toString();
        	  user =user.replaceAll("[\\[\\](){}]","");
        	 String[] UserArr = user.split(",") ;
        	 Gender = UserArr[0];
        	 fname = UserArr[1];
        	 fname = fname.trim();
        	 lname = UserArr[2];
        	 lname =lname.trim();
        	 email =UserArr[3];
        	 email = email.trim();
        	 registerObjects r1= new registerObjects(wd);
     		r1.register(Gender, fname, lname, email);
        	
        }

	   
		
		
	 
	 
  }
 
@DataProvider(name = "getdata")
  public Object[][] getdata(){
	  Map<String, List<String>>reguser = new HashMap<String , List<String>>();
	  {
	    reguser.put("user1",Arrays.asList( "Male", "xyz" ,"abc", "xzy_abc@gmail.com"));
	   // reguser.put("user2",Arrays.asList("female","Piya" ,"kapoor", "piya_kapoor@gmail.com"));
	   
	      return new Object[][]{{reguser}};
	  }
  
}
 

  @AfterTest
  public void afterTest() {
	  
	  wd.close();
  }

}
