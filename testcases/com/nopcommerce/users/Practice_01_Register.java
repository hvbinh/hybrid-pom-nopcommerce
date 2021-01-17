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



public class Practice_01_Register extends AbstractTest {
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
	public void Tc_01_Register_With_Valid_Information() {
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
	public void Tc_02_Register_With_Existed_Email() {
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("1990");
		registerPage.inputToEmailTextbox("tony123@yopmail.com");
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(pass);
		registerPage.inputToConfirmPasswordTextbox(pass);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisteredExistedErrorMessage(), "The specified email already exists");
		
		//homePage = registerPage.clickToLogoutLink();
		
		
	}

	@Test
	public void Tc_03_Register_With_Empty_Data() {
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		
		// let all fieds are emtpy
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisteredErrorMessage("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getRegisteredErrorMessage("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getRegisteredErrorMessage("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getRegisteredErrorMessage("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getRegisteredErrorMessage("ConfirmPassword"), "Password is required.");
		
		
	}
	@Test
	public void Tc_04_Register_With_Invalid_Email() {
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("1990");
		registerPage.inputToEmailTextbox("abc");
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(pass);
		registerPage.inputToConfirmPasswordTextbox(pass);
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisteredErrorMessage("Email"), "Wrong email");

		//homePage = registerPage.clickToLogoutLink();


	}

	@Test
	public void Tc_05_Register_Password_Under_6_Characters() {
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("1990");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox("12345");
		registerPage.inputToConfirmPasswordTextbox("12345");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisteredPasswordLessThan6Characters(), "must have at least 6 characters");
		
		//homePage = registerPage.clickToLogoutLink();	
	}
	@Test
	public void Tc_06_Register_Not_Match_Confirm_Password() {
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.selectDayDropdown("1");
		registerPage.selectMonthDropdown("January");
		registerPage.selectYearDropdown("1990");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox("12345");
		registerPage.inputToConfirmPasswordTextbox("123456");
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisteredNotMatchConfirmPassword(), "The password and confirmation password do not match.");
		
		//homePage = registerPage.clickToLogoutLink();	
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
}
