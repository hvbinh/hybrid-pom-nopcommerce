package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage{
	WebDriver driver;

	public UserRegisterPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, UserRegisterPageUI.GENDER_MAIL_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MAIL_RADIO);
		
	}
	public void inputToFirstnameTextBox(String firstName) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void inputToLastnameTextBox(String lastName) {
		waitToElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
		
	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
		
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
		
	}

	public void inputToPasswordTextbox(String pass) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, pass);
		
	}

	public void inputToConfirmPasswordTextbox(String pass) {
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, pass);
		
	}

	public UserRegisterPO clickToRegisterButton() {
		waitToElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return new UserRegisterPO(driver);
		
	}

	public String getRegisteredSuccessMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePO clickToLogoutLink() {
		waitToElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getRegisteredErrorMessage(String errorName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, errorName);
		
		return getElementText(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, errorName);
	}

	public String getRegisteredExistedErrorMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_VALIDATE_EXISTED_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_VALIDATE_EXISTED_ERROR_MESSAGE);
	}

	public String getRegisteredPasswordLessThan6Characters() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_VALIDATE_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_VALIDATE_PASSWORD_ERROR_MESSAGE);
	}

	public String getRegisteredNotMatchConfirmPassword() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_VALIDATE_CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_VALIDATE_CONFIRM_PASSWORD_ERROR_MESSAGE);
	}





}
