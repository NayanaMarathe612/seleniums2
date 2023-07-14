package S2practice;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerObjects {
     WebDriver wd ;
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
	   if (customerinfo.equals(email))
	   {
		  assertTrue(true, "The TestCase Passed");
	   }
	   else 
	   {
		   assertTrue(false, "TestCase Failed");
	   }
			   
	   System.out.println("TestCase Passed and User "+FirstName+"created Sucessfully" );
	   wd.findElement(logout).click();
	   
	   
	}
}