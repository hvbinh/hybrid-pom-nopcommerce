package pageFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractPage {
	WebDriverWait explicitWait;
	Select select;
	public void sendkeyToElement(WebDriver driver, WebElement element, String value)
	{
		element.clear();
		element.sendKeys(value);
	}
	public void clickToElement(WebDriver driver, WebElement element)
	{
		element.click();
	}
	public void waitToElementVisible(WebDriver driver,WebElement element)
	{
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitToElementClickable(WebDriver driver,WebElement element)
	{
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void selectItemInDropdown(WebDriver driver, WebElement element, String itemValue)
	{
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	public String getElementText(WebDriver driver, WebElement element)
	{
		return element.getText();
	}
	public boolean isElementDisplayed(WebDriver driver, WebElement element)
	{
		return element.isDisplayed();
	}
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	protected WebDriver getBrowserDriver(String browserName) {
		//setBrowserDriver();
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if (browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().driverVersion("86.0.4240.22").setup();
			driver = new ChromeDriver();
		} else if (browser == Browser.FIREFOX_UI) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else {
			throw new RuntimeException("please input valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demo.nopcommerce.com/");

		return driver;
	}
	WebDriver driver;

}
