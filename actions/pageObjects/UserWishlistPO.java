package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserProductDetailPageUI;
import pageUIs.UserWishlistPageUI;

public class UserWishlistPO extends AbstractPage{

	WebDriver driver;
	
	public UserWishlistPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getProductName(String productClassName) {
		waitToElementVisible(driver, UserWishlistPageUI.PRODUCT_NAME_BY_CLASS,productClassName);
		return getElementText(driver, UserWishlistPageUI.PRODUCT_NAME_BY_CLASS,productClassName);
	}

	public String getSKU(String SKUClassName) {
		waitToElementVisible(driver, UserWishlistPageUI.PRODUCT_SKU_BY_CLASS,SKUClassName);
		return getElementText(driver, UserWishlistPageUI.PRODUCT_SKU_BY_CLASS,SKUClassName);
	}

	public String getPrice(String priceClassName) {
		waitToElementVisible(driver, UserWishlistPageUI.PRODUCT_PRICE_BY_CLASS,priceClassName);
		return getElementText(driver, UserWishlistPageUI.PRODUCT_PRICE_BY_CLASS,priceClassName);

	}

	public String getQuantity() {
		waitToElementVisible(driver, UserWishlistPageUI.PRODUCT_QUANTITY_BY_VALUE);
		return getElementAtribute(driver, UserWishlistPageUI.PRODUCT_QUANTITY_BY_VALUE, "value");
	}
	





}
