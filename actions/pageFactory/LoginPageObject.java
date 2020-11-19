package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageFactory.AbstractPage;


public class LoginPageObject extends AbstractPage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//elements
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement loginButton;
	
	
	//action
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
		
	}

	public void inputToPasswordTextbox(String pass) {
		waitToElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, pass);
		
	}

	public void clickToLoginButton() {
		waitToElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}
	


}
