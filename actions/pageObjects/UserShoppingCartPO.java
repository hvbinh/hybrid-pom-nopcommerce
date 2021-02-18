package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserShoppingCartPageUI;
import pageUIs.UserWishlistPageUI;

public class UserShoppingCartPO extends AbstractPage{

	WebDriver driver;
	
	public UserShoppingCartPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getWishlistNumber() {
		waitToElementVisible(driver, UserShoppingCartPageUI.SHOPPING_CART_NUMBER);
		return getElementText(driver, UserShoppingCartPageUI.SHOPPING_CART_NUMBER);
	}

	public UserWishlistPO clickToWishlistHeadermenu() {
		waitToElementClickable(driver, UserShoppingCartPageUI.WISHLIST_HEADER_MENU);
		clickToElement(driver, UserShoppingCartPageUI.WISHLIST_HEADER_MENU);
		return PageGeneratorManager.getUserWishlistPO(driver);
	}

	public UserComputerPO clickOnEditLink() {
		waitToElementClickable(driver, UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK);
		return PageGeneratorManager.getUserComputerPage(driver);
	}

	







}
