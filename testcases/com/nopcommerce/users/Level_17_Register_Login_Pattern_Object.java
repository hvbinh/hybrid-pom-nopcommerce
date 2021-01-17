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
import pageObjects.UserProductDetailPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

public class Level_17_Register_Login_Pattern_Object extends AbstractTest {
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
	public void Tc_01_Validate_At_Register()
	{
		log.info("Validate - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Validate - Step 02: Click to Register link at Home page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Validate - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Validate - Step 04: Verify error message displays at FirstName textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryByID(driver, "FirstName"), "First name is required.");
		
		log.info("Validate - Step 05: Verify error message displays at LastName textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryByID(driver, "LastName"), "Last name is required.");
		
		log.info("Validate - Step 06: Verify error message displays at Email textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryByID(driver, "Email"), "Email is required.");
		
		log.info("Validate - Step 07: Verify error message displays at Password textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryByID(driver, "Password"), "Password is required.");
		
		log.info("Validate - Step 08: Verify error message displays at Password textbox");
		verifyEquals(registerPage.getErrorMessageAtMandatoryByID(driver, "ConfirmPassword"), "Password is required.");
		
		
	}

	@Test
	public void Tc_02_Register_Success() {
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 02: Click to Register link at Home page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 03: Click to Gender Male radio button");
		registerPage.clickToRadioButtonByID(driver, "male");

		log.info("Register - Step 04: Input to Firstname textbox with value: "+firstName);
		registerPage.inputToTexboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 05: Input to Lastname textbox with value: "+lastName);
		registerPage.inputToTexboxByID(driver, "LastName", lastName);

		log.info("Register - Step 06: Select Day dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", "10");

		log.info("Register - Step 07: Select Month dropdown");
		registerPage.selectMonthDropdown("February");
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", "February");

		log.info("Register - Step 08: Select Year dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", "1990");

		log.info("Register - Step 09: Input to Email textbox with value: "+email);
		registerPage.inputToTexboxByID(driver, "Email", email);
		
		log.info("Register - Step 10: Input to Company textbox with value: "+companyName);
		registerPage.inputToTexboxByID(driver, "Company", companyName);
		
		log.info("Register - Step 11: Input to Password textbox with value: "+pass);
		registerPage.inputToTexboxByID(driver, "Password", pass);
		
		log.info("Register - Step 12: Input to confirm Password textbox with value: "+pass);
		registerPage.inputToTexboxByID(driver, "ConfirmPassword", pass);

		log.info("Register - Step 13: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 17: Verify Register success message displayed");
		verifyEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

		log.info("Register - Step 18: Click to Logout link and navigate to Home Page");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Tc_03_Login_Success() {
		log.info("Login - Step 01: Open Login Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Input to Email textbox with value: "+email);
		loginPage.inputToTexboxByID(driver, "Email", email);
		
		log.info("Login - Step 03: Input to Password textbox with value: "+pass);
		loginPage.inputToTexboxByID(driver, "Password", pass);

		log.info("Login - Step 04: Click to Login button");
		homePage.clickToButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

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
		closeBrowserAndDriver(driver);
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserProductDetailPO myProductPage;
}
