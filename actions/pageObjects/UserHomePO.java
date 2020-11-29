package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserHomePageUI;

public class UserHomePO extends AbstractPage {

	WebDriver driver;
	//ham khoi tao (constructor)
	public UserHomePO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
		
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickable(driver, UserHomePageUI.LOG_IN_LINK);
		clickToElement(driver, UserHomePageUI.LOG_IN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOG_OUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOG_OUT_LINK);
	}

	public UserCustomerInforPO clickToMyAccountLink() {
		waitToElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
		
	}

}
