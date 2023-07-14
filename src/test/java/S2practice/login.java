package S2practice;

import org.testng.annotations.Test;
import org.testng.mustache.Value;

import com.google.common.collect.Iterators;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.Implementation.Context;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class login {
	
  WebDriver wd ; 
  String email;
  String password;
  
  @BeforeTest
  public void beforeTest() 
  {  
	  WebDriverManager.chromedriver().setup();
	  wd = new ChromeDriver();
	  String Lemail ;
	  String Lpass ;
	  
	  
  }
  
 
 /**
 * @throws InterruptedException
 */
@Test
 @Parameters({"email","password"})
  public void loginTest() throws InterruptedException{
	  wd.get("https://demowebshop.tricentis.com/");
	  
//    String Lemail = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("email");
//    String Lpass = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("password") ;
	//  ITestContext context = org.testng.Reporter.getCurrentTestResult()
	  //Int size = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().
	 Map<String ,String>params = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getAllParameters();//context.getCurrentXmlTest().getAllParameters();
	 int count = params.size();
	 String Lemail = null ;
	 String Lpass = null ;
	 for (int i=0 ;i<=count ;i++)
	 {
	  Lemail = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("email");
	 System.out.println("email ="+Lemail);
	  Lpass = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("password");   
	 System.out.println("password="+Lpass);
     }
	  
	  
	  loginObjects l = new loginObjects(wd);
	  l.login(Lemail , Lpass);
	  Thread.sleep(2000);
	  
	  
  }


 

  @AfterTest
  public void afterTest() {
	
	 // wd.close();
  }

}
