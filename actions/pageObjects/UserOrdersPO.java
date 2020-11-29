package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserMyProductReviewsPageUI;
import pageUIs.UserOrdersPageUI;

public class UserOrdersPO extends AbstractPage{

	WebDriver driver;
	
	public UserOrdersPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserAddressesPO openAddressesPage() {
		waitToElementClickable(driver, AbstractPageUI.ADDRESSES_LINK);
		clickToElement(driver, AbstractPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}

}
