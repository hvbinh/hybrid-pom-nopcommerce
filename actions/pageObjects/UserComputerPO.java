package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserComputerPO extends AbstractPage{
	WebDriver driver;

	
	public UserComputerPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
