package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)    //constructor for assigning/passing from  login testpage,
	{
		this.driver = driver;    
		PageFactory.initElements(driver, this);// initialize all objects @findby annotations means eg: assign input-email to the emailField.
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(css="input[value='Login']")
	private WebElement loginButton;
	
	
	public WebElement emailField()
	
	{
		return (emailField);
		
		
	}
	
public WebElement passwordField()
	
     	{
	
		return (passwordField);
		
		}
public WebElement loginButton()

	{

return (loginButton);

}
	}
