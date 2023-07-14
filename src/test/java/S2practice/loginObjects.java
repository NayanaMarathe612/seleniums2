package S2practice;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginObjects {
       WebDriver d ;
       
	public loginObjects(WebDriver driver) {
		 this.d = driver;
		 
		}
	
	
	
	 public void login(String Lemail, String Lpass)
	 { 
		 By loginlink = By.xpath("//a[@href ='/login']");
		 By emailid =  By.xpath("//input[@id='Email']");
		 By lpassword = By.xpath("//input[@id='Password']");
		 By submit = By.xpath("//input[@value='Log in']");
		 
		 
		d.findElement(loginlink).click();
	try {
		d.findElement(emailid).sendKeys(Lemail);
		d.findElement(lpassword).sendKeys(Lpass);
	}
	 catch(Exception e)
	{ System.out.println(e);
		 }
	 
	d.findElement(submit).click();
	 
	

}
}