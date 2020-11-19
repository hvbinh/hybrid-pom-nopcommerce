package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageFactory.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//element
	@FindBy(className ="ico-register")
	WebElement registerLink;
	
	@FindBy(className ="ico-login")
	WebElement loginLink;
	
	@FindBy(className="ico-logout")
	WebElement logoutLink;
	
	@FindBy(className="ico-account")
	WebElement myAccountLink;
	
	
	
	//action
	public void clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, logoutLink);
		return isElementDisplayed(driver, logoutLink);
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}

}
