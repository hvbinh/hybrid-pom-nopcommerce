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
		
		// deselect all
		productPage.uncheckToselectAllCheckbox();
		productPage.areProductCheckboxUnchecked();
		
		//special check
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		
		productPage.checkToProductCheckboxByName("$50 Physical Gift Card");	
	}
	@Test
	public void TC_03_Displayed_All()
	{
		//check displayed
		Assert.assertTrue(productPage.areProductDetailsDisplayed("Adobe Photoshop CS4","AD_CS4_PH","75","10000","Simple","true"));
		Assert.assertTrue(productPage.areProductDetailsDisplayed("adidas Consortium Campus 80s Running Shoes","AD_C80_RS","27.56","10000","Simple","true"));
		Assert.assertTrue(productPage.areProductDetailsDisplayed("Apple iCam","APPLE_CAM","1300","10000","Simple","true"));
		
		productPage.selectShowNumberDropdown("50");
		Assert.assertTrue(productPage.areProductDetailsDisplayed("Windows 8 Pro","MS_WIN_8P","65","10000","Simple","true"));
	}
	@Test
	public void TC_04_Edit()
	{
		productPage.clickToProductDetailByName("$50 Physical Gift Card");
		productPage.backToPage(driver);
	}
	@Test
	public void TC_05_Position()
	{
		
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnnameRowNumber("Product name","2","$25 Virtual Gift Card"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnnameRowNumber("SKU","2","VG_CR_025"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnnameRowNumber("Price","2","25"));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnnameRowNumber("Stock quantity","2",""));
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnnameRowNumber("Product type","2","Simple"));
		Assert.assertTrue(productPage.isPublishStatusAtColumnnameAndRowNumber("Published","2","true"));
		productPage.selectShowNumberDropdown("50");
		Assert.assertTrue(productPage.isPublishStatusAtColumnnameAndRowNumber("Published","45","true"));
	}
}
