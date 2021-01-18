package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserAddressesPageUI;
import pageUIs.UserCustomerInforPageUI;

public class UserAddressesPO extends AbstractPage{

	WebDriver driver;
	
	public UserAddressesPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public UserProductReviewPO openMyProductReviewsPage(WebDriver driver2) {
		waitToElementClickable(driver2, UserAddressesPageUI.REVIEW_PRODUCT_LEFT_MENU);
		clickToElement(driver2, UserAddressesPageUI.REVIEW_PRODUCT_LEFT_MENU);
		return PageGeneratorManager.getUserProductReviewPO(driver2);
	}



}
