package com.nopcommerce.users;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
import com.nopcommerce.common.Common_02_Cookie;

import commons.AbstractPage;
import commons.AbstractTest;
import net.bytebuddy.implementation.bytecode.Throw;
import pageObjects.UserAddressesPO;
import pageObjects.UserComputerPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewsPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;
import pageObjects.UserSearchPO;
import pageUIs.UserSearchPageUI;

public class Level_15_Register_Login_Share_State_Part3_Cookie extends AbstractTest {
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

		log.info("Precondition - Step 1: Open log in Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 2: Log in by Cookie");
		for (Cookie cookie : Common_02_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		/*
		 * Set<Cookie> allCookies = driver.manage().getCookies(); System.out.println("level 15 cookie:"+allCookies);
		 */
		homePage.refreshCurrentPage(driver);
		
		log.info("Precondition - Step 3: Verify my account link displays");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_01_Verify_Sort_Name_Ascending() {
		
		
	}
	@Test
	public void TC_02_Verify_Sort_Name_Descending() {
		
		
	}
	@Test
	public void TC_03_Verify_Sort_Price_From_Low_To_High() {
		
	}
	@Test
	public void TC_04_Verify_Sort_Price_From_High_To_Low() {

	}
	@Test
	public void TC_05_Verify_Advance_Search_With_Parent_Category() {
			
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
	UserComputerPO computerPage;
}
