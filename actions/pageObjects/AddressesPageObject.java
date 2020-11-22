package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AddressesPageUI;
import pageUIs.CustomerInforPageUI;

public class AddressesPageObject extends AbstractPage{

	WebDriver driver;
	
	public AddressesPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}



}
