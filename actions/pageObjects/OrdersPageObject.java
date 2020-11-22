package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.MyProductReviewsPageUI;
import pageUIs.OrdersPageUI;

public class OrdersPageObject extends AbstractPage{

	WebDriver driver;
	
	public OrdersPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public AddressesPageObject openAddressesPage() {
		waitToElementClickable(driver, OrdersPageUI.ADDRESSES_LINK);
		clickToElement(driver, OrdersPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}

}
