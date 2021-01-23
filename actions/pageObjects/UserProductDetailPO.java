package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserProductDetailPageUI;

public class UserProductDetailPO extends AbstractPage{

	WebDriver driver;
	public static String productName, SKU,quantity, price;
	
	public UserProductDetailPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickToAddToWishlistButton(String wishlistName) {
		waitToElementClickable(driver, UserProductDetailPageUI.DYNAMIC_BUTTON_BY_CLASS_NAME, wishlistName);
		productName = getElementText(driver, UserProductDetailPageUI.DYNAMIC_BUTTON_BY_CLASS_NAME, wishlistName);
		SKU = getElementText(driver, UserProductDetailPageUI.SKU);
		quantity = getElementAtribute(driver, UserProductDetailPageUI.QUANTITY_ORDER_BY_VALUE, "value");
		price = getElementText(driver, UserProductDetailPageUI.PRICE);
		clickToElement(driver, UserProductDetailPageUI.DYNAMIC_BUTTON_BY_CLASS_NAME, wishlistName);
		
	}

	public String getNotificationSuccessMessage() {
		waitToElementVisible(driver, UserProductDetailPageUI.NOTIFICATION_SUCCESS);
		return getElementText(driver, UserProductDetailPageUI.NOTIFICATION_SUCCESS);
	}

	public UserWishlistPO clickToWishlistHeaderLink(String headerLinkClassName) {
		waitToElementClickable(driver, UserProductDetailPageUI.DYNAMIC_HEADER_LINK_BY_CLASS, headerLinkClassName);
		clickToElement(driver, UserProductDetailPageUI.DYNAMIC_HEADER_LINK_BY_CLASS, headerLinkClassName);
		return PageGeneratorManager.getUserWishlistPO(driver);
	}

	public void closeNotificationSuccessMessage() {
		waitToElementClickable(driver, UserProductDetailPageUI.NOTIFICATION_CLOSE_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.NOTIFICATION_CLOSE_BUTTON);
	}

	public UserComputerPO navigateBack() {
		backToPage(driver);
		return PageGeneratorManager.getUserComputerPage(driver);
	}
	



}
