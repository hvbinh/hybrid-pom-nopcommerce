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

import com.nopcommerce.common.Common_01_Register;

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

public class Level_15_Register_Login_Share_State_Part1_Search extends AbstractTest {
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
	@Test
	public void TC_03_Verify_Relative_Search() {
		searchPage.inputToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
		
		verifyTrue(searchPage.getProductsResult("Lenovo IdeaCentre 600 All-in-One PC"));
		verifyTrue(searchPage.getProductsResult("Lenovo Thinkpad X1 Carbon Laptop"));
		
	}
	@Test
	public void TC_04_Verify_Absolute_Search() {
		searchPage.inputToSearchTextbox("Lenovo Thinkpad X1 Carbon Laptop");
		searchPage.clickToSearchButton();
		
		verifyTrue(searchPage.getProductsResult("Lenovo Thinkpad X1 Carbon Laptop"));
		
	}
	@Test
	public void TC_05_Verify_Advance_Search_With_Parent_Category() {
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.uncheckSubCategoryCheckbox();
		searchPage.clickToSearchButton();
		
		verifyEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");	
	}
	@Test
	public void TC_06_Verify_Advance_Search_With_Sub_Category() {
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSubCategoryCheckbox();
		searchPage.clickToSearchButton();
		
		verifyTrue(searchPage.getProductsResult("Apple MacBook Pro 13-inch"));
	}
	@Test
	public void TC_07_Verify_Advance_Search_With_Incorrect_Manufacturer() {
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSubCategoryCheckbox();
		searchPage.selectManufacturer("HP");
		searchPage.clickToSearchButton();
		
		verifyEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
	}
	@Test
	public void TC_08_Verify_Advance_Search_With_Correct_Manufacturer() {
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSubCategoryCheckbox();
		searchPage.selectManufacturer("Apple");
		searchPage.clickToSearchButton();
		
		verifyTrue(searchPage.getProductsResult("Apple MacBook Pro 13-inch"));
	}
	@Test
	public void TC_09_Verify_Advance_Search_Within_Price_Range() {
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSubCategoryCheckbox();
		searchPage.selectManufacturer("Apple");
		searchPage.inputToFromPriceTextbox("1000");
		searchPage.inputToToPriceTextbox("2000");
		searchPage.clickToSearchButton();
		
		verifyTrue(searchPage.getProductsResult("Apple MacBook Pro 13-inch"));
	}
	@Test
	public void TC_10_Verify_Advance_Search_Price_Range_Greater_Than_Product_Price() {
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSubCategoryCheckbox();
		searchPage.selectManufacturer("Apple");
		searchPage.inputToFromPriceTextbox("1000");
		searchPage.inputToToPriceTextbox("1700");
		searchPage.clickToSearchButton();
		
		verifyEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
	}
	@Test
	public void TC_11_Verify_Advance_Search_Price_Range_Greater_Than_Product_Price() {
		
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		searchPage.checkToAdvanceSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSubCategoryCheckbox();
		searchPage.selectManufacturer("Apple");
		searchPage.inputToFromPriceTextbox("1900");
		searchPage.inputToToPriceTextbox("5000");
		searchPage.clickToSearchButton();
		
		verifyEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");
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
	UserSearchPO searchPage;
}
