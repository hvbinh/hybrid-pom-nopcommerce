package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {
	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName)
	{
		if(browserName.equals("chrome_ui"))
		{
			System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox_ui"))
		{
			System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge_chromium_ui"))
		{
			System.setProperty("webdriver.edge.driver", projectFolder + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equals("chrome_headless"))
		{
			System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox_headless"))
		{
			System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions(); 
			options.setHeadless(true); 
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}
		else
		{
			throw new RuntimeException("please input valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.nopcommerce.com/");
		
		return driver;
	}
	protected int randomNumber()
	{
		Random random = new Random();
		return random.nextInt(999999);
	}
}
