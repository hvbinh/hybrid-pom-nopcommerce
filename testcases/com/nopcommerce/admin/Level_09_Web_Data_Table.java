package com.nopcommerce.admin;

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
import org.openqa.selenium.support.ui.Sleeper;
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
import pageObjects.AdminDashboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

public class Level_09_Web_Data_Table extends AbstractTest {
	WebDriver driver;
	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;

	/**
	 * @author admin: Binh Ha
	 * 
	 */
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName,String urlValue) {

		driver = getBrowserDriver(browserName,urlValue);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		loginPage.inputToEmailTextbox("admin@yourstore.com");
		loginPage.inputToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		
		productPage = dashboardPage.openProductPage();

	}
	//@Test
	public void TC_01_Paging()
	{
		//paging
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("2"));

		
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("1"));

		
		productPage.goToPageAtTableByIndex("3");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("3"));

		
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("2"));

		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("1"));
		
		
		//check displayed
		
		//edit
		
	}
	@Test
	public void TC_02_Select_Deselect_All()
	{
		//select all
		productPage.checkToSelectAllCheckbox();
		productPage.areProductCheckboxChecked();
		productPage.sleepInSecond(3);
		
		// deselect all
		productPage.uncheckToselectAllCheckbox();
		productPage.areProductCheckboxUnchecked();
		productPage.sleepInSecond(3);
		
		//special check
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		productPage.sleepInSecond(3);
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		
		productPage.checkToProductCheckboxByName("$50 Physical Gift Card");
		
		
	}

}
