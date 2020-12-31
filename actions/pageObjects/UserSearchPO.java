package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserSearchPageUI;

public class UserSearchPO extends AbstractPage{

	WebDriver driver;
	
	public UserSearchPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getWarningMessage() {
		waitToElementVisible(driver, UserSearchPageUI.WARNING_MESSAGE);
		return getElementText(driver, UserSearchPageUI.WARNING_MESSAGE);
	}

	public void inputToSearchTextbox(String value) {
		waitToElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, value);
	}



	public String getNoResultMessage() {
		waitToElementVisible(driver, UserSearchPageUI.NO_RESULT_MESSAGE);
		return getElementText(driver, UserSearchPageUI.NO_RESULT_MESSAGE);
	}
	

}
