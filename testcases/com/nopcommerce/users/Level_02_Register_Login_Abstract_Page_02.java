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

	
public class Level_02_Register_Login_Abstract_Page_02 extends AbstractPage {
	WebDriver driver;
	String projectFolder = System.getProperty("user.dir");
	Select selectDay, selectMonth, selectYear;

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
		clickToElement(driver, "//a[text()='Register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);

		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "10");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "February");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");

		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", companyName);
		
		sendkeyToElement(driver, "//input[@id='Password']", pass);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", pass);

		clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"),
				"Your registration completed");

		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void Tc_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", pass);

		clickToElement(driver, "//input[@class='button-1 login-button']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-logout']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
	}

	@Test
	public void Tc_03_View_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));

		Assert.assertEquals(getElementAtribute(driver, "//input[@id='FirstName']", "value"),firstName);
		Assert.assertEquals(getElementAtribute(driver, "//input[@id='LastName']", "value"),lastName);
		
		Assert.assertEquals(getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthDay']"), "10");
		Assert.assertEquals(getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthMonth']"), "February");
		Assert.assertEquals(getFirstSelectedTextInDropDown(driver, "//select[@name='DateOfBirthYear']"), "1990");

		Assert.assertEquals(getElementAtribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(getElementAtribute(driver, "//input[@id='Company']", "value"), companyName);

		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));

	}


	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
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

}
