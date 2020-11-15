package automationtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	private String name = "Selenium Webdriver";
	// protected
	protected String sponser = "Saucelab";
	// default
	String organization = "Selenium HQ";
	// public
	public String version = "3.141.59";

	private String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

	String getOrganization() {
		return this.organization;
	}

	protected String getSponsor() {
		return this.sponser;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return this.version;
	}

	public static void main(String[] args) {
		Selenium selenium = new Selenium();

		// private
		System.out.println(selenium.name);
		System.out.println(selenium.getName());

		// default
		System.out.println(selenium.organization);
		System.out.println(selenium.getOrganization());

		// protected
		System.out.println(selenium.sponser);
		System.out.println(selenium.getSponsor());
		
		//public
		System.out.println(selenium.version);
		System.out.println(selenium.getVersion());
		
		WebDriver driver;
		String projectFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

	}

}
