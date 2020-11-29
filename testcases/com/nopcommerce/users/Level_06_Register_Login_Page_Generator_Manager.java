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
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

	
public class Level_06_Register_Login_Page_Generator_Manager extends AbstractTest {
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
		//1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		
		//2
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

		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(),"Your registration completed");

		homePage = registerPage.clickToLogoutLink();
		
		//3

	}

	@Test
	public void Tc_02_Login() {
		loginPage=homePage.clickToLoginLink();

		//4
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(pass);

		homePage = loginPage.clickToLoginButton();

		//5
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void Tc_03_View_My_Account() {
		customerInformPage = homePage.clickToMyAccountLink();

		//6
		Assert.assertTrue(customerInformPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(customerInformPage.getFirstnameTextboxValue(),firstName);
		Assert.assertEquals(customerInformPage.getLastnameTextboxValue(),lastName);
		
		Assert.assertEquals(customerInformPage.getSelectedTextInDayDropdown(), "10");
		Assert.assertEquals(customerInformPage.getSelectedTextInMonthDropdown(), "February");
		Assert.assertEquals(customerInformPage.getSelectedTextInYearDropdown(), "1990");

		Assert.assertEquals(customerInformPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInformPage.getCompanyTextboxValue(), companyName);

		Assert.assertTrue(customerInformPage.isNewsLetterCheckboxSelected());

	}



	/**
	 * @param time
	 * @throws InterruptedException
	 */
	public void sleepInSecond(long time) 
	{
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
	UserCustomerInforPO customerInformPage;
}
