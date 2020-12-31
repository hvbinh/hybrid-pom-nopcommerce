package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.MagicNumberFileFilter;
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
import pageObjects.UserSearchPO;
import pageUIs.UserSearchPageUI;

public class Practice_04_Search extends AbstractTest {
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

		// data
		firstName = "Tony";
		lastName = "Buoi Sang";
		email = "tonybuoisang" + randomNumber() + "@gmail.com";
		companyName = "Tony Buoi Sang company";
		pass = "123456";
		// update data
		updateFirstName = "Automation";
		updateLastName = "FC";
		updateEmail = "automationfc." + randomNumber() + ".vn@gmail.com";
		updateCompanyName = "Automation FC";

		Register();
		Login_In_With_Register_Email_And_correct_Password();
		homePage = PageGeneratorManager.getUserHomePage(driver);
		searchPage = homePage.clickToSearchLink();

	}

	@Test
	public void TC_01_Verify_Search_With_Empty_Value() {
		searchPage.clickToSearchButton();
		
		verifyEquals(searchPage.getWarningMessage(), "Search term minimum length is 3 characters");
		
	}
	@Test
	public void TC_02_Verify_Search_With_Not_Exit_Data() {
		searchPage.inputToSearchTextbox("Macbook Pro 2050");
		searchPage.clickToSearchButton();
		
		verifyEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
		
	}

	

	public void Login_In_With_Register_Email_And_correct_Password() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	public void Register() {
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

		// Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

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
	UserSearchPO searchPage;
}
