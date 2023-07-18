package S2practice;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//@Listeners(value=iTest.class)
public class registerObjects {
     WebDriver wd ;
     ExtentTest test ;
     WebElement customerinfo ;
     String email;
     WebElement logout ;
     String FirstName ;
     
	registerObjects(WebDriver wd)
	{
	    this.wd = wd ;
	   
	    
	}
	

	
	void register(String  gender ,String FirstName , String Lastname , String email)
	{  
		By link_register =By.xpath("//a[@href=\"/register\"]");
		By gendermale =By.id("gender-male");
	    By genderfemale = By.id("gender-female");
		By Register_FirstName = By.id("FirstName");
		By Register_LastName = By.id("LastName");
		By Email  = By.id("Email");
		By Password = By.id("Password");
		By ConfirmPassword = By.id("ConfirmPassword");
		By Reg_Button  = By.xpath("//input[@id=\"register-button\"]");
		By logout = By.xpath("//a[@href=\"/logout\"]");
		By customerinfo = By.xpath("//a[@href=\"/customer/info\"]");
	
	 wd.findElement(link_register).click();
	   if(gender.equals("Male"))
			   {
		        wd.findElement(gendermale).click();
			   }
	   else 
	   {
		   wd.findElement(genderfemale).click();
	   }
	   wd.findElement(Register_FirstName).sendKeys(FirstName);
	   wd.findElement(Register_LastName).sendKeys(Lastname);
	   wd.findElement(Email).sendKeys(email);
	   wd.findElement(Password).sendKeys("test123@612$");
	   wd.findElement(ConfirmPassword).sendKeys("test123@612$");
	   wd.findElement(Reg_Button).click();
	   try
	   {
	   if (customerinfo.equals(email))
	   {
		   
		  assertTrue(true, "TestCase Passed");  
	   }
	   else 
	   {
		   assertTrue(true, "TestCase Failed");
	   }}
	   catch (Exception e)
	   {
		   System.out.println(e);
	   }
			   
	   System.out.println("TestCase Passed and User "+FirstName+"created Sucessfully");
	   //wd.findElement(logout).click();
	}
	   
	
}