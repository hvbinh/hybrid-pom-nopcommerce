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

public class Practice_03_My_Account extends AbstractTest {
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
		customerInforPage = homePage.clickToMyAccountLink();

	}

	@Test
	public void TC_01_Verify_Customer_Info() {
		// update information
		customerInforPage.clickToGenderFemaleRadioButton();
		customerInforPage.inputToFirstNameTextbox(updateFirstName);
		customerInforPage.inputToLastNameTextbox(updateLastName);
		customerInforPage.selectDayDropdown("1");
		customerInforPage.selectMonthDropdown("January");
		customerInforPage.selectYearDropdown("1990");
		customerInforPage.inputToEmailTextbox(updateEmail);
		customerInforPage.inputToCompanyTextbox(updateCompanyName);
		customerInforPage.clickToSaveButton();

		// verify
		Assert.assertTrue(customerInforPage.isGenderFeMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstnameTextboxValue(), updateFirstName);
		Assert.assertEquals(customerInforPage.getLastnameTextboxValue(), updateLastName);
		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), "1");
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), "January");
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), "1990");

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), updateEmail);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), updateCompanyName);

	}

	@Test
	public void TC_02_Add_Address() {
		customerInforPage.clickToAddressesLeftMenu("Addresses");
		customerInforPage.clickToAddNewButton();

		customerInforPage.inputToAddressFirstnameTextbox(updateFirstName);
		customerInforPage.inputToAddressLastnameTextbox(updateLastName);
		customerInforPage.inputToAddressEmailTextbox(updateEmail);
		customerInforPage.inputToAddressCompanyTextboxTextbox(updateCompanyName);
		customerInforPage.selectCountryDropdown("Viet Nam");
		customerInforPage.selectStateOrProvinceDropdown("");
		customerInforPage.inputToAddressCityTextbox("Da Nang");
		customerInforPage.inputToAddressAddress1Textbox("123/04 Le Lai");
		customerInforPage.inputToAddressAddress2Textbox("234/05 Hai Phong");
		customerInforPage.inputToAddressPortalCodeTextbox("550000");
		customerInforPage.inputToAddressPhoneTextbox("0123456789");
		customerInforPage.inputToAddressFaxTextbox("0987654321");
		customerInforPage.clickToAddressSaveButton();

		// verify

		Assert.assertTrue(customerInforPage.getAddressFullnameValue("name").contains(updateFirstName + " " + updateLastName));
		Assert.assertTrue(customerInforPage.getAddressPhoneNumberValue("phone").contains("0123456789"));
		Assert.assertTrue(customerInforPage.getAddressFaxNumberValue("fax").contains("0987654321"));
		Assert.assertTrue(customerInforPage.getAddressCompanyValue("company").contains(updateCompanyName));
		Assert.assertTrue(customerInforPage.getAddressAddress1Value("address1").contains("123/04 Le Lai"));
		Assert.assertTrue(customerInforPage.getAddressAddress2Value("address2").contains("234/05 Hai Phong"));
		Assert.assertTrue(customerInforPage.getAddressCityZipValue("city-state-zip").contains("Da Nang, 550000"));
		Assert.assertTrue(customerInforPage.getCountryValue("country").contains("Viet Nam"));

	}
	@Test
	public void TC_03_Update_Password()
	{
		customerInforPage.clickToAddressesLeftMenu("Change password");
		customerInforPage.inputToOldPasswordTextbox("123456");
		customerInforPage.inputToNewPasswordTextbox("1234567");
		customerInforPage.inputToConfirmPasswordTextbox("1234567");
		customerInforPage.clickToChangePasswordButton();
		
		Assert.assertEquals(customerInforPage.getResultMessage(), "Password was changed");
		homePage = customerInforPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(updateEmail);
		loginPage.inputToPasswordTextbox("1234567");
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
	}
	@Test
	public void TC_04_Product_Review()
	{
		customerInforPage = homePage.clickToMyAccountLink();
		customerInforPage.inputToSearchTextbox("Adobe Photoshop CS4");
		customerInforPage.clickToSearchButton();
		customerInforPage.clickToProductTitleResult("Adobe Photoshop CS4");
		customerInforPage.clickToAddYourReviewLink();
		customerInforPage.inputToReviewTitle("my review adobe");
		customerInforPage.inputToReviewText("very good");
		customerInforPage.clickToRateOption("3");
		customerInforPage.clickToSubmitReviewButton();
		customerInforPage.clickToMyAccountLink();
		customerInforPage.clickToMyProductReviewLeftMenu("My product reviews");
		
		Assert.assertEquals(customerInforPage.getReviewTitle(),"my review adobe");
		Assert.assertEquals(customerInforPage.getReviewText(), "very good");
		
		Assert.assertTrue(customerInforPage.getReviewRatingNumber("style").contains("60%"));
		
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
}
