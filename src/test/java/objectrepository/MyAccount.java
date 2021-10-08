package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
		
		WebDriver driver;
		
		public MyAccount(WebDriver driver) 
		{
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Account']")
		private WebElement accountBreadcrumb;
		
		
		public WebElement accountBreadcrumb() 
		
		{
			
			return (accountBreadcrumb);
			
		}
		
	
	

}
