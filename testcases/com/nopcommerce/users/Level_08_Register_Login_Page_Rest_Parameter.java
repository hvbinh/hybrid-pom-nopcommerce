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

public class Level_08_Register_Login_Page_Rest_Parameter extends AbstractTest {
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
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();

		// 2
		registerPage.clickToGenderMaleRadioButton();

		registerPage.inputToFirstnameTextBox(firstName);

		registerPage.inputToLastnameTextBox(lastName);

		registerPage.selectDayDropdown("10");

		registerPage.selectMonthDropdown("February");

		registerPage.selectYearDropdown("1990");

		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(pass);
		registerPage.inputToConfirmPasswordTextbox(pass);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

		// 3

	}

	@Test
	public void Tc_02_Login() {
		loginPage = homePage.clickToLoginLink();

		// 4
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(pass);

		homePage = loginPage.clickToLoginButton();

		// 5

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
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

	@Test
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
	@Test
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
