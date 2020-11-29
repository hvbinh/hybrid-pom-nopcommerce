package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminDashboardPageUI;
import pageUIs.AdminLoginPageUI;

public class AdminDashboardPO extends AbstractPage{

	WebDriver driver;
	
	
	public AdminDashboardPO(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public AdminProductPO openProductPage() {
		waitToElementClickable(driver,AdminDashboardPageUI.CATALOG_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_LINK_AT_SIDEBAR);
		
		waitToElementClickable(driver,AdminDashboardPageUI.PRODUCTS_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.PRODUCTS_LINK_AT_SIDEBAR);
		waitAjaxLoadingInvisible(driver);
		return PageGeneratorManager.getAdminProductPage(driver);
	}
}
