package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserAddressesPageUI;
import pageUIs.UserCustomerInforPageUI;

public class UserAddressesPO extends AbstractPage{

	WebDriver driver;
	
	public UserAddressesPO(WebDriver driver) {
		super();
		this.driver = driver;
	}



}
