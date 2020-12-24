package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import net.bytebuddy.implementation.bytecode.Throw;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewsPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

public class Level_13_Register_Login_Log_Report_HTML extends AbstractTest {
	WebDriver driver;
	Select selectDay, selectMonth, selectYear;

	String firstName, lastName, email, companyName, pass, confirmPass;

	/**
	 * @author admin: Binh Ha
	 * 
	 */
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		// data
		firstName = "Tony";
		lastName = "Buoi Sang";
		email = "tonybuoisang" + randomNumber() + "@gmail.com";
		companyName = "Tony Buoi Sang company";
		pass = "123456";

	}

	@Test
	public void Tc_01_Register() {
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 02: Verify Register link displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 03: Verify Login link displayed");
		verifyTrue(homePage.isLoginLinkDisplayed()); 

		log.info("Register - Step 04: Click to Register link at Home page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 05: Click to Gender Male radio button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Register - Step 06: Input to Firstname textbox with value: "+firstName);
		registerPage.inputToFirstnameTextBox(firstName);

		log.info("Register - Step 07: Input to Lastname textbox with value: "+lastName);
		registerPage.inputToLastnameTextBox(lastName);

		log.info("Register - Step 08: Select Day dropdown");
		registerPage.selectDayDropdown("10");

		log.info("Register - Step 09: Select Month dropdown");
		registerPage.selectMonthDropdown("February");

		log.info("Register - Step 10: Select Year dropdown");
		registerPage.selectYearDropdown("1990");

		log.info("Register - Step 11: Input to Email textbox with value: "+email);
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 12: Input to Company textbox with value: "+companyName);
		registerPage.inputToCompanyTextbox(companyName);
		
		log.info("Register - Step 13: Input to Password textbox with value: "+pass);
		registerPage.inputToPasswordTextbox(pass);
		
		log.info("Register - Step 14: Input to confirm Password textbox with value: "+pass);
		registerPage.inputToConfirmPasswordTextbox(pass);

		log.info("Register - Step 15: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 16: Verify Register success message displayed");
		verifyEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

		log.info("Register - Step 17: Click to Logout link and navigate to Home Page");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Tc_02_Login() {
		log.info("Login - Step 01: Open Login Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Input to Email textbox with value: "+email);
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 03: Input to Password textbox with value: "+pass);
		loginPage.inputToPasswordTextbox(pass);

		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify My Account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed()); 
		
		log.info("Login - Step 06: Verify Logout link displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Login - Step 07: Verify Register link undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());
		
		log.info("Login - Step 08: Verify Login link undisplayed");
		verifyTrue(homePage.isLoginLinkUndisplayed());
		
		log.info("Login - Step 09: Verify Tooltip undisplayed");
		verifyTrue(homePage.isTooltipUndisplayed());
	}

	//@Test
	public void Tc_03_View_My_Account() {
		customerInforPage = homePage.clickToMyAccountLink();

		// 6
		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());

		Assert.assertEquals(customerInforPage.getFirstnameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastnameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), "10");
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), "February");
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), "1990");

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), companyName);

		Assert.assertTrue(customerInforPage.isNewsLetterCheckboxSelected());

	}

	//@Test
	public void Tc_04_Switch_Page_solution1() {
		// customer infor -> Addresses
		addressesPage =(UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
		customerInforPage = (UserCustomerInforPO)addressesPage.openLinkByPageName(driver, "Customer info");
		myProductPage =(UserMyProductReviewsPO) customerInforPage.openLinkByPageName(driver, "My product reviews");
		customerInforPage = (UserCustomerInforPO) myProductPage.openLinkByPageName(driver, "Customer info");
		addressesPage =(UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
		// addresses -> my product review
		myProductPage = (UserMyProductReviewsPO)addressesPage.openLinkByPageName(driver, "My product reviews");
		// my product review -> order
		ordersPage =(UserOrdersPO) myProductPage.openLinkByPageName(driver, "Order");

		// order -> addresses
		addressesPage =(UserAddressesPO) ordersPage.openLinkByPageName(driver, "Addresses");

		// addresses -> customer infor
		customerInforPage =(UserCustomerInforPO) addressesPage.openLinkByPageName(driver, "Customer info");

	}
	//@Test
	public void Tc_05_Switch_Page_solution2() {
		customerInforPage.openLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		addressesPage.openLinkWithPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
		
		customerInforPage.openLinkWithPageName(driver, "My product reviews");
		myProductPage = PageGeneratorManager.getUserMyProductReviewsPage(driver);
		
		

	}
	

	/**
	 * @param time
	 * @throws InterruptedException
	 */
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	UserMyProductReviewsPO myProductPage;
}
