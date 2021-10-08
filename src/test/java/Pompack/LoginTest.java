package Pompack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.LoginPage;
import objectrepository.MyAccount;

public class LoginTest 

{
	WebDriver driver; //driver is global for all the methods
	
    @Test(dataProvider = "Logindatas")
	public void login(String EmailField,String PasswordField ) throws IOException,Exception
	
	{
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		  
		  LoginPage loginPage = new LoginPage(driver); // create object for the login page(to call the method from diferent class) {(driver) constructor calling statemnt from login page) 
		  Thread.sleep(3000);
		  loginPage.emailField().sendKeys(EmailField);
		  Thread.sleep(3000);
		  loginPage.passwordField().sendKeys(PasswordField);
		  Thread.sleep(3000);
		  loginPage.loginButton().click();
		  
		  MyAccount myAccount = new MyAccount(driver);
		  Assert.assertTrue(myAccount.accountBreadcrumb().isDisplayed()); // suppose this fails if we dont add after mthod driver.close it not run , it shows cmple error
          Thread.sleep(3000);
	}
          
          @DataProvider (name ="Logindatas")                          //another method for adding values
      	
      	public Object[][]  dataSet1(){
      		
      		return new Object[] [] 
      				{
      			       {"anildas@yopmail.com","Anildas@0987"} , // 2 rows
      			         {"christo@yopmail.com","Christo@123"}  
      			       };
          
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
	}
	
	
	
}
