package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserRecentlyViewProductPageUI;

public class UserRecentlyViewedProductPO extends AbstractPage{

	WebDriver driver;
	
	public UserRecentlyViewedProductPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getProductNameWithHref(String href) {
		waitToElementVisible(driver, UserRecentlyViewProductPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href);
		return getElementText(driver, UserRecentlyViewProductPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href);
	}

	public boolean isProductDisplayWithHref(String href) {
		waitToElementInvisible(driver, UserRecentlyViewProductPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href);
		return isElementDisplayed(driver, UserRecentlyViewProductPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href);
	}

	

	


}
