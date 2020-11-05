package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

	
public class Level_02_Register_Login_Abstract_Page_01 {
	WebDriver driver;
	String projectFolder = System.getProperty("user.dir");
	Select selectDay, selectMonth, selectYear;
	AbstractPage abstractPage;

	String firstName, lastName, email, companyName, pass, confirmPass;


	/**
	 * @author admin: Binh Ha
	 * 
	 */
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		abstractPage = new AbstractPage();
		driver.get("http://demo.nopcommerce.com/");

		// data
		firstName = "Tony";
		lastName = "Buoi Sang";
		email = "tonybuoisang" + getRandomNumber() + "@gmail.com";
		companyName = "Tony Buoi Sang company";
		pass = "123456";
		
	}

	@Test
	public void Tc_01_Register() {
		abstractPage.clickToElement(driver, "//a[text()='Register']");

		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);

		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "February");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");

		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Company']", companyName);
		
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", pass);
		abstractPage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", pass);

		abstractPage.clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(abstractPage.getElementText(driver, "//div[@class='result']"),
				"Your registration completed");

		abstractPage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void Tc_02_Login() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");

		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", pass);

		abstractPage.clickToElement(driver, "//input[@class='button-1 login-button']");

		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-logout']"));
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-account']"));
	}

	@Test
	public void Tc_03_View_My_Account() {
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));

		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='FirstName']", "value"),firstName);
		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='LastName']", "value"),lastName);
		
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthDay']"), "10");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthMonth']"), "February");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthYear']"), "1990");

		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(abstractPage.getElementAtribute(driver, "//input[@id='Company']", "value"), companyName);

		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));

	}


	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	/**
	 * @param time
	 * @throws InterruptedException
	 */
	public void sleepInSecond(long time) throws InterruptedException
	{
		Thread.sleep(time * 1000);
	}
	@AfterClass	
	public void afterClass() {
	}

}
