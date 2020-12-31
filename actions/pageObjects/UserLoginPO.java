package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
//import io.qameta.allure.Step;
import pageUIs.UserLoginPageUI;

public class UserLoginPO extends AbstractPage{
	WebDriver driver;
	public UserLoginPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	
	//@Step("Input to Email textbox with value: {0}")
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
		
	}
	//@Step("Input to Password textbox with value: {0}")
	public void inputToPasswordTextbox(String pass) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, pass);
		
	}
	//@Step("Click to Login button")
	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}


	//@Step("")
	public String getEmailErrorMessage() {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}


	//@Step("")
	public String getNotRegisterEmailErrorMessage() {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_NOT_REGISTER_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_NOT_REGISTER_ERROR_MESSAGE);
	}






}
