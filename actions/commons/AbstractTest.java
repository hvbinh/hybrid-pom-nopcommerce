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
	private String osName = System.getProperty("os.name");

	protected WebDriver getBrowserDriver(String browserName) {
		setBrowserDriver();
		if (browserName.equals("chrome_ui")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox_ui")) {

			driver = new FirefoxDriver();
		} else if (browserName.equals("edge_chromium_ui")) {

			driver = new EdgeDriver();
		} else if (browserName.equals("chrome_headless")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox_headless")) {

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

	public void setBrowserDriver() {
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
}
