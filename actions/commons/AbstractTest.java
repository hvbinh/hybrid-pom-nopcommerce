package commons;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AbstractTest {
	
	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	// define log variable
	protected final Log log;
	
	protected AbstractTest()
	{
		//init log
		log = LogFactory.getLog(getClass());
	}

	protected synchronized WebDriver getBrowserDriver(String browserName) {
		//setBrowserDriver();
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if (browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
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
	protected synchronized WebDriver getBrowserDriver(String browserName, String url) {
		//setBrowserDriver();
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		if (browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup(); //.driverVersion("86.0.4240.22").setup();
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

		driver.get(url);

		return driver;
	}

	void setBrowserDriver() {
		if (isWindows()) {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browserDriver") + "chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browserDriver") + "geckodriver.exe");
			System.setProperty("webdriver.edge.driver", projectFolder + getDirectorySlash("browserDriver") + "msedgedriver.exe");
		}

		else if (isMac()) {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browserDriver") + "chromedriver_mac");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browserDriver") + "geckodriver_mac");
			System.setProperty("webdriver.edge.driver", projectFolder + getDirectorySlash("browserDriver") + "msedgedriver_mac");
		} else {
			System.setProperty("webdriver.chrome.driver", projectFolder + getDirectorySlash("browserDriver") + "geckodriver_linux");
			System.setProperty("webdriver.gecko.driver", projectFolder + getDirectorySlash("browserDriver") + "msedgedriver_linux");

		}

	}

	public String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	public boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	public boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	public boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0 || osName.toLowerCase().indexOf("aix") > 0);
	}

	public boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

	protected int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	public WebDriver getDriver() {
		return driver;
	}
	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// Get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			if (driver != null) {
				driver.quit();
			}
			
			// Quit driver executable file in Task Manager
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("edge")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill msedgedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}

