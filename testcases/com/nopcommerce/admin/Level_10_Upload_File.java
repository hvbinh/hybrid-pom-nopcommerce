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

public class Level_10_Upload_File extends AbstractTest {
	WebDriver driver;
	
	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;
	
	String fileName = "silver.jpg";
	String productName = "Adobe Photoshop CS4";
	String pictureAlt ="Description";
	String pictureTitle ="Title";
	String pictureOrder = "1";

	/**
	 * @author admin: Binh Ha
	 * 
	 */
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {

		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		loginPage.inputToEmailTextbox("admin@yourstore.com");
		loginPage.inputToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();

		productPage = dashboardPage.openProductPage();

	}

	@Test
	public void TC_01_Upload_File() {
		// search adobe photoshop cs4
		productPage.inputToProductNameTextbox(productName);
		productPage.clickToSearchButton();

		// go to edit
		productPage.clickToEditButton();

		
		// scroll to upload function
		productPage.scrollToPicturePanel();

		// click to plus icon
		productPage.clickToPlusIconByPanelID(driver, "product-pictures");

		//productPage.clickToDeleteButtonByPictureTitle(pictureTitle);
		//productPage.sleepInSecond(3);
		productPage.scrollToPicturePanel();
		// upload one file (name,title,alt,order)
		productPage.uploadFileByPanelID(driver, "product-pictures", fileName);

		// verify file name is uploaded successfully
		Assert.assertTrue(productPage.isNewPictureLoadedSuccess(fileName));

		productPage.inputToAltTextbox(pictureAlt);
		productPage.inputToTitleTextbox(pictureTitle);
		productPage.clickToIconAtOrderTextbox("Increase");
		productPage.sleepInSecond(7);
		productPage.clickToAddProductPictureButton();



		// verify on picture table 
		Assert.assertTrue(productPage.areImageDetailDisplayed(productName,pictureOrder,pictureAlt,pictureTitle));

		// save => go to product page 
		productPage.clickToSaveButton();
		
		// search adobe photoshop cs4 
		productPage.inputToProductNameTextbox(productName);
		
		productPage.clickToSearchButton();
		//verify (name/image name) => found
		
		Assert.assertTrue(productPage.areProductDisplayed(productName,productName, "AD_CS4_PH", "75", "10000", "Simple", "true")); // edit
		productPage.clickToEditButton();

		// scroll to upload function 
		productPage.scrollToPicturePanel();

		// delete image 
		productPage.clickToDeleteButtonByPictureTitle(pictureTitle);
		

		// save ->go to product page 
		productPage.clickToSaveButton();

		// search adobe photoshop cs4 
		productPage.inputToProductNameTextbox(productName);
		
		productPage.clickToSearchButton();
		

		// veriry(name, image name) => not found
		Assert.assertTrue(productPage.areProductDisplayed("default-image",productName, "AD_CS4_PH", "75", "10000", "Simple", "true"));

	}

}
