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

public class Practice_07_Order extends AbstractTest {
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

	}

	@Test
	public void Add_Product_To_Cart() {
		log.info("Add to cart - Step 1: Hover mouse to Computer header menu");
		homePage.hoverToHeaderMenu("Computers");
		
		log.info("Add to cart - Step 1: Click to Desktop submenu");
		homePage.clickToSubmenu("Desktops");
		
		log.info("Add to cart - Step 1: Product name build your own computer");
		computerPage = homePage.clickToProductTitleByName("Build your own computer");
		
		
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
