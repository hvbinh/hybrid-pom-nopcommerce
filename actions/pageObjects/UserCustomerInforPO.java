package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;

public class UserCustomerInforPO extends AbstractPage{

	WebDriver driver;
	
	public UserCustomerInforPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.GENDER_MAIL_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MAIL_RADIO);
	}

	public String getFirstnameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastnameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAtribute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsLetterCheckboxSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.NEWS_LETTER_CHECKBOX);
		return isElementSelected(driver, UserCustomerInforPageUI.NEWS_LETTER_CHECKBOX);
	}



}
