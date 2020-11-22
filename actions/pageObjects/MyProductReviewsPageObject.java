package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInforPageUI;
import pageUIs.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends AbstractPage{

	WebDriver driver;
	
	public MyProductReviewsPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}



}
