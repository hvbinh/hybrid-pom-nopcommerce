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
import pageObjects.UserAddressesPO;
import pageObjects.UserComputerPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;
import pageObjects.UserSearchPO;
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
	public void TC_01_Add_Product_To_Whishlist()
	{
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
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserProductDetailPO myProductPage;
	UserSearchPO searchPage;
	UserComputerPO computerPage;
	UserProductDetailPO productDetailPage;
	UserWishlistPO wishlistPage;
	
}
