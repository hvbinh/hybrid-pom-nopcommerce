package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserWishlistPageUI;

public class UserCompareProductPO extends AbstractPage{

	WebDriver driver;
	
	public UserCompareProductPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
