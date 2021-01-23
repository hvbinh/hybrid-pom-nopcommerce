package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserComputerPageUI;
import pageUIs.UserProductDetailPageUI;

public class UserComputerPO extends AbstractPage{
	WebDriver driver;

	
	public UserComputerPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickAddToCompareListButtonByHrefProduct(String hrefProduct) {
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_BY_HREF, hrefProduct);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_BY_HREF, hrefProduct);
	}

	public void closeNotificationSuccessMessage() {
		waitToElementClickable(driver, UserComputerPageUI.NOTIFICATION_CLOSE_BUTTON);
		clickToElement(driver, UserComputerPageUI.NOTIFICATION_CLOSE_BUTTON);
	}

	public UserCompareProductPO clickToCompareProductListFooterLink() {
		waitToElementClickable(driver, UserComputerPageUI.COMPARE_PRODUCT_LIST_FOOTER_LINK);
		clickToElement(driver, UserComputerPageUI.COMPARE_PRODUCT_LIST_FOOTER_LINK);
		return PageGeneratorManager.getUserCompareProductPO(driver);
	}

	public boolean notificationSuccessMessageDisplay() {
		waitToElementVisible(driver, UserComputerPageUI.NOTIFICATION_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserComputerPageUI.NOTIFICATION_SUCCESS_MESSAGE);
	}

	public UserProductDetailPO clickToProductNameByHref(String href) {
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href, href);
		return PageGeneratorManager.getUserProductDetailPO(driver);
	}

	public UserRecentlyViewedProductPO clickToRerentlyViewedProductPage() {
		waitToElementClickable(driver, UserComputerPageUI.RECENTLY_VIEWED_PRODUCT_FOOTER_LINK);
		clickToElement(driver, UserComputerPageUI.RECENTLY_VIEWED_PRODUCT_FOOTER_LINK);
		return PageGeneratorManager.getUserRecentlyViewedProductPO(driver);
	}





}
