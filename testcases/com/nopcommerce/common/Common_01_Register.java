package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.AbstractTest;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserProductDetailPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

public class Common_01_Register extends AbstractTest {
	WebDriver driver;
	Select selectDay, selectMonth, selectYear;

	String firstName, lastName, companyName,  confirmPass;
	public static String email, pass;
	

	/**
	 * @author admin: Binh Ha
	 * 
	 */
	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		// data
		firstName = "Tony";
		lastName = "Buoi Sang";
		email = "tonybuoisang" + randomNumber() + "@gmail.com";
		companyName = "Tony Buoi Sang company";
		pass = "123456";
		
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

		
		driver.quit();
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

	@BeforeTest
	public void afterClass() {
		
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserProductDetailPO myProductPage;
}
