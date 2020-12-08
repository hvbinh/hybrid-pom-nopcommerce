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
	String fileName = "silver.jpg";
	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;

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
		productPage.inputToProductNameTextbox("Adobe Photoshop CS4");
		productPage.clickToSearchButton();

		// go to edit
		productPage.clickToEditButton();

		// scroll to upload function
		productPage.scrollToPicturePanel();

		// click to plus icon
		productPage.clickToPlusIconByPanelID(driver, "product-pictures");

		// upload one file (name,title,alt,order)
		productPage.uploadFileByPanelID(driver, "product-pictures", fileName);

		// verify file name is uploaded successfully
		Assert.assertTrue(productPage.isNewPictureLoadedSuccess(fileName));

		productPage.inputToAltTextbox("");
		productPage.inputToTitleTextbox("");
		productPage.inputToOrder("");
		productPage.clickToAddProductPictureButton();

		// add to product picture productPage.clickToAddProductPictureButton();

		// verify on picture table Assert.assertTrue(productPage.areImageDetailDisplayed("image name","Adobe Photoshop CS4","Order","Title"));

		// save => go to product page productPage.clickToSaveButton();

		// search adobe photoshop cs4 productPage.inputToProductNameTextbox(""); productPage.clickToSearchButton(); //verify (name/image name) => found
		Assert.assertTrue(productPage.areProductDisplayed("image name", "Adobe Photoshop CS4", "AD_CS4_PH", "75", "10000", "Simple", "true")); // edit
		productPage.clickToEditButton();

		// scroll to upload function productPage.scrollToPicturePanel();

		// delete image productPage.clickToDeleteButton();

		// save ->go to product page productPage.clickToSaveButton();

		// search adobe photoshop cs4 productPage.inputToProductNameTextbox("");

		// veriry(name, image name) => not found
		Assert.assertTrue(productPage.areProductDisplayed("default_image", "Adobe Photoshop CS4", "AD_CS4_PH", "75", "10000", "Simple", "true"));

	}

}
