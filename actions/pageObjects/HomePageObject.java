package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {

	WebDriver driver;
	//ham khoi tao (constructor)
	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getregisterPage(driver);
		
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOG_IN_LINK);
		clickToElement(driver, HomePageUI.LOG_IN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.LOG_OUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOG_OUT_LINK);
	}

	public CustomerInforPageObject clickToMyAccountLink() {
		waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
		
	}

}
