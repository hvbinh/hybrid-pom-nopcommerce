package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCompareProductPageUI;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserWishlistPageUI;

public class UserCompareProductPO extends AbstractPage{

	WebDriver driver;
	
	public UserCompareProductPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean compareProductDisplayByHref(String href) {
		
		waitToElementVisible(driver, UserCompareProductPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF,href);
		return isElementDisplayed(driver, UserCompareProductPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF,href);
	}

	public void hoverMouseToComputerHeader() {
		waitToElementVisible(driver, UserCompareProductPageUI.COMPUTER_HEADER_MENU);
		hoverMouseToElement(driver, UserCompareProductPageUI.COMPUTER_HEADER_MENU);
		
	}

	public UserComputerPO clickToNotebooksSubmenu() {
		waitToElementClickable(driver, UserCompareProductPageUI.NOTEBOOK_SUB_MENU);
		clickToElement(driver, UserCompareProductPageUI.NOTEBOOK_SUB_MENU);
		return PageGeneratorManager.getUserComputerPage(driver);
	}

}
