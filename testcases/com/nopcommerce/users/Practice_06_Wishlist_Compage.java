package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.AbstractTest;
import pageObjects.UserCompareProductPO;
import pageObjects.UserComputerPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserRecentlyViewedProductPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserSearchPO;
import pageObjects.UserShoppingCartPO;
import pageObjects.UserWishlistPO;

public class Practice_06_Wishlist_Compage extends AbstractTest {
	WebDriver driver;
	Select selectDay, selectMonth, selectYear;

	String firstName, lastName, email, companyName, pass, confirmPass;
	String updateFirstName, updateLastName, updateEmail, updateCompanyName;

	/**
	 * @author admin: Binh Ha
	 * 
	 */
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		Login_In_With_Register_Email_And_correct_Password();
		homePage = PageGeneratorManager.getUserHomePage(driver);
		searchPage = homePage.clickToSearchLink();

	}

	@Test
	public void TC_01_Add_Product_To_Whishlist() {
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSubCategoryCheckbox();
		searchPage.selectManufacturer("Apple");
		searchPage.clickToSearchButton();

		verifyTrue(searchPage.getProductsResult("Apple MacBook Pro 13-inch"));

		productDetailPage = searchPage.clickToProductTitleByName(driver, "Apple MacBook Pro 13-inch");
		productDetailPage.clickToAddToWishlistButton("add-to-wishlist");
		verifyEquals(productDetailPage.getNotificationSuccessMessage(), "The product has been added to your wishlist");
		productDetailPage.closeNotificationSuccessMessage();

		wishlistPage = productDetailPage.clickToWishlistHeaderLink("wishlist-label");
		verifyEquals(wishlistPage.getProductName("product-name"), "Apple MacBook Pro 13-inch");
		verifyEquals(wishlistPage.getSKU("sku-number"), "AP_MBP_13");
		verifyEquals(wishlistPage.getPrice("product-unit-price"), "$1,800.00");
		verifyEquals(wishlistPage.getQuantity(), "2");

		wishlistPage.clickToWishlistShareLink();
		verifyEquals(wishlistPage.getWishlistPageTitle(), "Wishlist of " + Common_01_Register.firstName + " " + Common_01_Register.lastName);
	}

	@Test
	public void TC_02_Add_Product_To_Cart_From_Wishlist() {
		wishlistPage.clickToAddToCartCheckbox();
		String wishlistNumber = wishlistPage.getWishlistNumber();
		shoppingCartPage = wishlistPage.clickToAddToCartButton();
		String shoppingCartNumber = shoppingCartPage.getWishlistNumber();
		verifyEquals(wishlistNumber, shoppingCartNumber);

	}

	@Test
	public void TC_03_Remove_Product_From_Wishlist() {
		wishlistPage = shoppingCartPage.clickToWishlistHeadermenu();
		wishlistPage.clickToRemoveFromCartCheckbox();
		wishlistPage.clickToUpdateWishlistButton();
		verifyEquals(wishlistPage.getWishlistNumber(), "(0)");

	}

	@Test
	public void TC_04_Add_Product_To_Compare() {

		wishlistPage.hoverToComputersHeaderMenu();
		computerPage = wishlistPage.clickToDesktopSubMenu();

		log.info("click add to compare list on Build your own computer");
		computerPage.clickAddToCompareListButtonByHrefProduct("build-your-own-computer");

		log.info("verify notificaiton message displayed");
		verifyTrue(computerPage.notificationSuccessMessageDisplay());
		
		log.info("close notification message");
		computerPage.closeNotificationSuccessMessage();

		log.info("click add to compare list on Lenovo IdeaCentre 600 All-in-One PC");
		computerPage.clickAddToCompareListButtonByHrefProduct("lenovo-ideacentre-600-all-in-one-pc");

		log.info("verify notificaiton message displayed");
		verifyTrue(computerPage.notificationSuccessMessageDisplay());
		
		log.info("close notification message"); 
		computerPage.sleepInSecond(2); 
		computerPage.closeNotificationSuccessMessage();
	

		log.info("click to compare product list in footer");
		compareProductPage = computerPage.clickToCompareProductListFooterLink();

		log.info("verify that Lenovo IdeaCentre 600 All-in-One PC displays");
		verifyTrue(compareProductPage.compareProductDisplayByHref("lenovo-ideacentre-600-all-in-one-pc"));
		
		log.info("verify that Build your own computer displays");
		verifyTrue(compareProductPage.compareProductDisplayByHref("build-your-own-computer"));
		
	}
	@Test
	public void TC_05_Recently_View_Products() {
		log.info("hover on Computer header menu then click on notebooks submenu");
		compareProductPage.hoverMouseToComputerHeader();
		computerPage = compareProductPage.clickToNotebooksSubmenu();
		
		log.info("view product detail Asus N551JK-XO076H Laptop");
		myProductPage = computerPage.clickToProductNameByHref("asus-n551jk-xo076h-laptop");
		computerPage = myProductPage.navigateBack();
		
		log.info("view product detail HP Envy 6-1180ca 15.6-Inch Sleekbook");
		myProductPage = computerPage.clickToProductNameByHref("hp-envy-6-1180ca-156-inch-sleekbook");
		computerPage = myProductPage.navigateBack();
		
		log.info("view product detail HP Spectre XT Pro UltraBook");
		myProductPage = computerPage.clickToProductNameByHref("hp-spectre-xt-pro-ultrabook");
		computerPage = myProductPage.navigateBack();
		
		log.info("view product detail Lenovo Thinkpad X1 Carbon Laptop");
		myProductPage = computerPage.clickToProductNameByHref("lenovo-thinkpad-x1-carbon-laptop");
		computerPage = myProductPage.navigateBack();
		
		log.info("view product detail Samsung Series 9 NP900X4C Premium Ultrabook");
		myProductPage = computerPage.clickToProductNameByHref("samsung-series-9-np900x4c-premium-ultrabook");
		computerPage = myProductPage.navigateBack();
		
		log.info("click to recently viewed products footer link");
		recentlyViewedProductPage = computerPage.clickToRerentlyViewedProductPage();
		
		log.info("verify 3 recently viewed products show");
		verifyEquals(recentlyViewedProductPage.getProductNameWithHref("hp-spectre-xt-pro-ultrabook"), "HP Spectre XT Pro UltraBook");
		verifyEquals(recentlyViewedProductPage.getProductNameWithHref("lenovo-thinkpad-x1-carbon-laptop"), "Lenovo Thinkpad X1 Carbon Laptop");
		verifyEquals(recentlyViewedProductPage.getProductNameWithHref("samsung-series-9-np900x4c-premium-ultrabook"), "Samsung Series 9 NP900X4C Premium Ultrabook");
		
		log.info("other products should not show");
		verifyFalse(recentlyViewedProductPage.isProductDisplayWithHref("asus-n551jk-xo076h-laptop"));

	}

	public void Login_In_With_Register_Email_And_correct_Password() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(Common_01_Register.email);
		loginPage.inputToPasswordTextbox(Common_01_Register.pass);
		loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
	}

	UserHomePO homePage;
	UserLoginPO loginPage;
	UserProductDetailPO myProductPage;
	UserSearchPO searchPage;
	UserComputerPO computerPage;
	UserProductDetailPO productDetailPage;
	UserWishlistPO wishlistPage;
	UserShoppingCartPO shoppingCartPage;
	UserCompareProductPO compareProductPage;
	UserRecentlyViewedProductPO recentlyViewedProductPage;

}
