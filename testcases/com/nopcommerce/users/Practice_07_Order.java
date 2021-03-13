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
	public void TC_01_Add_Product_To_Cart() {
		log.info("Add to cart - Step 1: Hover mouse to Computer header menu");
		homePage.hoverToHeaderMenu("Computers");

		log.info("Add to cart - Step 2: Click to Desktop submenu");
		homePage.clickToSubmenu("Desktops");
		showBrowserConsoleLogs(driver);

		log.info("Add to cart - Step 3: Product name build your own computer");
		computerPage = homePage.clickToProductTitleByName("Build your own computer");
		showBrowserConsoleLogs(driver);

		log.info("Add to cart - Step 4: select processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]'");
		computerPage.selectProcessorByName("product_attribute_1", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		log.info("Add to cart - Step 5: select RAM: 8.00 GHz");
		computerPage.selectRAMByName("product_attribute_2", "4GB [+$20.00]");

		log.info("Add to cart - Step 6: HDD select 400 GB");
		computerPage.selectHDDRadioByLabel("400 GB [+$100.00]");

		log.info("Add to cart - Step 7: OS select Vista Premium");
		computerPage.selectOS("Vista Premium [+$60.00]");

		log.info("Add to cart - Step 8: Software check all options");
		computerPage.selectAllSoftware("Microsoft Office [+$50.00]", "Acrobat Reader [+$10.00]", "Total Commander [+$5.00]");

		log.info("Add to cart - Step 9: Click to Add to Cart button");
		computerPage.clicAddToCartButton();
		showBrowserConsoleLogs(driver);

		log.info("Add to cart - Step 10: Verify notification success displays");
		verifyTrue(computerPage.notificationSuccessDisplays());

		log.info("Add to cart - Step 11: Close notification success");
		computerPage.closeNotificationSuccess();

		log.info("Add to cart - Step 12: Hover mouse on shopping cart menu");
		computerPage.hoverMouseToShoppingCartMenu();

		log.info("Add to cart - Step 13: Verify product title shows");
		verifyEquals(computerPage.getProductTitleInShoppingCart(), "Build your own computer");

		log.info("Add to cart - Step 14: Verify attribute shows");
		verifyTrue(computerPage.processorDisplay("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"));
		verifyTrue(computerPage.RAMDisplay("4GB [+$20.00]"));
		verifyTrue(computerPage.HDDDisplay("400 GB [+$100.00]"));
		verifyTrue(computerPage.OSDisplay("Vista Premium [+$60.00]"));
		verifyTrue(computerPage.softwareDisplay("Microsoft Office [+$50.00]"));
		verifyTrue(computerPage.softwareDisplay("Acrobat Reader [+$10.00]"));
		verifyTrue(computerPage.softwareDisplay("Total Commander [+$5.00]"));

		log.info("Add to cart - Step 15: Verify price show");
		verifyTrue(computerPage.priceDisplay("$1,460.00"));

	}

	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart() {
		log.info("Edit product - Step 01: Click on shoping cart link");
		shoppingCartPage = computerPage.clickOnShoppingCartLink();
		showBrowserConsoleLogs(driver);

		log.info("Edit product - Step 02: Click on edit link");
		computerPage = shoppingCartPage.clickOnEditLink();
		showBrowserConsoleLogs(driver);

		log.info("Edit product - Step 03: Select processor 2.2 GHz");
		computerPage.selectProcessorByName("product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200");

		log.info("Edit product - Step 04: Select RAM 4.0 GB");
		computerPage.selectRAMByName("product_attribute_2", "4GB [+$20.00]");

		log.info("Edit product - Step 05: Select HDD 320 GB");
		computerPage.selectHDDRadioByLabel("320 GB");

		log.info("Edit product - Step 06: Select OS vista home");
		computerPage.selectOS("Vista Home [+$50.00]");

		log.info("Edit product - Step 07: Select software Microsoft Office");
		computerPage.selectOneSoftware("Microsoft Office [+$50.00]", "Acrobat Reader [+$10.00]", "Total Commander [+$5.00]");

		log.info("Edit product - Step 08: Increase number proto to 2");
		computerPage.updateQuantity("2");

		log.info("Edit product - Step 09: Click to Update button");
		computerPage.clickToUpdateButton();
		showBrowserConsoleLogs(driver);

		log.info("Add to cart - Step 10: Verify notification success displays");
		verifyTrue(computerPage.notificationSuccessDisplays());

		log.info("Add to cart - Step 11: Close notification success");
		computerPage.closeNotificationSuccess();

		log.info("Edit product - Step 12: Verify that product price: $1,320");
		verifyEquals(computerPage.getProductPrice(), "$1,320.00");

		log.info("Add to cart - Step 13: Hover mouse on shopping cart menu");
		computerPage.hoverMouseToShoppingCartMenu();

		log.info("Add to cart - Step 14: Verify product title shows");
		verifyEquals(computerPage.getProductTitleInShoppingCart(), "Build your own computer");

		log.info("Add to cart - Step 15: Verify attribute shows");
		verifyTrue(computerPage.processorDisplay("2.2 GHz Intel Pentium Dual-Core E2200"));
		verifyTrue(computerPage.RAMDisplay("4GB [+$20.00]"));
		verifyTrue(computerPage.HDDDisplay("320 GB"));
		verifyTrue(computerPage.OSDisplay("Vista Home [+$50.00]"));
		verifyTrue(computerPage.softwareDisplay("Microsoft Office [+$50.00]"));

		log.info("Add to cart - Step 16: Verify price show");
		verifyTrue(computerPage.priceDisplay("$2,640.00"));

	}
	@Test
	public void TC_03_Remove_From_Cart() {
		log.info("Remove frome cart - Step 01: Click on Go to cart button");
		computerPage.clickOnGoToCartButton();
		showBrowserConsoleLogs(driver);
		
		log.info("Remove frome cart - Step 01: Click on remove checkbox ");
		computerPage.ClickOnRemoveCheckbox("COMP_CUST");
		
		log.info("Remove frome cart - Step 01: Click on Update Shopping Cart button");
		computerPage.clickOnUpdateShoppingCartButton();
		showBrowserConsoleLogs(driver);
		
		log.info("Remove frome cart - Step 01: Verify that 'Your Shopping Cart is empty!' displays");
		log.info("Remove frome cart - Step 01: Verify that 'Your Shopping Cart is empty!' displays update testing 1aaaaaaaaaaaaaaa");
		verifyTrue(computerPage.shoppingCartEmptyDisplay());
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
