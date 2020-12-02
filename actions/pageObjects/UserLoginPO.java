package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserLoginPageUI;

public class UserLoginPO extends AbstractPage{
	WebDriver driver;
	public UserLoginPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String pass) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, pass);
		
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}



	public String getEmailErrorMessage() {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}



	public String getNotRegisterEmailErrorMessage() {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_NOT_REGISTER_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_NOT_REGISTER_ERROR_MESSAGE);
	}






}
