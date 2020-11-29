package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserMyProductReviewsPageUI;

public class UserMyProductReviewsPO extends AbstractPage{

	WebDriver driver;
	
	public UserMyProductReviewsPO(WebDriver driver) {
		super();
		this.driver = driver;
	}



}
