package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInforPageUI;

public class CustomerInforPageObject extends AbstractPage{

	WebDriver driver;
	
	public CustomerInforPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, CustomerInforPageUI.GENDER_MAIL_RADIO);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_MAIL_RADIO);
	}

	public String getFirstnameTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastnameTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, CustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, CustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropDown(driver, CustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAtribute(driver, CustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsLetterCheckboxSelected() {
		waitToElementVisible(driver, CustomerInforPageUI.NEWS_LETTER_CHECKBOX);
		return isElementSelected(driver, CustomerInforPageUI.NEWS_LETTER_CHECKBOX);
	}



}
