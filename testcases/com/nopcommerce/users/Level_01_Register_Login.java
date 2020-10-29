package com.nopcommerce.users;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_Login {
	WebDriver driver;
	String projectFolder = System.getProperty("user.dir");
	Select selectDay, selectMonth, selectYear;

	String firstName, lastName, email, companyName, pass, confirmPass;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectFolder+"\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//data
		firstName="Tony";
		lastName="Buoi Sang";
		email="tonybuoisang"+getRandomNumber()+"@gmail.com";
		companyName="Tony Buoi Sang company";
		pass="123456";
		confirmPass="123456";

	}

	@Test
	public void Tc_01_Register() {
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
		selectDay.selectByVisibleText("10");
		
		selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		selectMonth.selectByVisibleText("February");
		
		selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
		selectYear.selectByVisibleText("1990");
		
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPass);
		
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		
		driver.findElement(By.className("ico-logout")).click();
		
		
	}
	@Test
	public void Tc_02_Login() {
		driver.findElement(By.className("ico-login")).click();
		
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#Password")).sendKeys(pass);
		
		driver.findElement(By.cssSelector(".login-button")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
	}
	@Test
	public void Tc_03_View_My_Account() {
		driver.findElement(By.cssSelector(".ico-account")).click();
		
		Assert.assertTrue(driver.findElement(By.id("gender-male")).isSelected());
		
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		
		selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(selectDay.getFirstSelectedOption().getText(), "10");
		
		selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(), "February");
		
		selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(selectYear.getFirstSelectedOption().getText(), "1990");
		
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), email);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);
		
		Assert.assertTrue(driver.findElement(By.id("Newsletter")).isSelected());
		
	}
	public int getRandomNumber()
	{
		Random random = new Random();
		return random.nextInt(9999);
	}


	@AfterClass
	public void afterClass() {
	}

}
