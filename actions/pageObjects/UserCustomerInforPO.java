package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserRegisterPageUI;

public class UserCustomerInforPO extends AbstractPage{

	WebDriver driver;

	
	public UserCustomerInforPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
	}
	public boolean isGenderFeMaleRadioButtonSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
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

	public void clickToGenderFemaleRadioButton() {
		waitToElementClickable(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN, day);
		
	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN, month);
		
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN, year);
		
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, companyName);
		
	}

	public void clickToSaveButton() {
		waitToElementVisible(driver, UserCustomerInforPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInforPageUI.SAVE_BUTTON);
		
	}

	public void clickToAddressesLeftMenu(String leftMenuName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.LEFT_MENU_LINK_BY_NAME,leftMenuName);
		clickToElement(driver, UserCustomerInforPageUI.LEFT_MENU_LINK_BY_NAME,leftMenuName);
	}

	public void clickToAddNewButton() {
		waitToElementClickable(driver, UserCustomerInforPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserCustomerInforPageUI.ADD_NEW_BUTTON);
		
	}

	public void inputToAddressFirstnameTextbox(String updateFirstName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_FIRSTNAME_TEXTBOX, updateFirstName);
		
	}

	public void inputToAddressLastnameTextbox(String updateLastName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_LASTNAME_TEXTBOX, updateLastName);
		
	}

	public void inputToAddressEmailTextbox(String email) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_EMAIL_TEXTBOX, email);
		
	}

	public void inputToAddressCompanyTextboxTextbox(String companyName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_COMPANY_TEXTBOX, companyName);
		
	}

	public void selectCountryDropdown(String country) {
		waitToElementClickable(driver, UserCustomerInforPageUI.ADDRESS_COUNTRY_DROPDOWN);
	    selectItemInDropdown(driver, UserCustomerInforPageUI.ADDRESS_COUNTRY_DROPDOWN, country);

		
	}

	public void selectStateOrProvinceDropdown(String string) {
		// TODO Auto-generated method stub
		
	}

	public void inputToAddressCityTextbox(String city) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_CITY_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_CITY_TEXTBOX, city);
		
	}

	public void inputToAddressAddress1Textbox(String address1) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_ADDRESS1_TEXTBOX, address1);
		
	}

	public void inputToAddressAddress2Textbox(String address2) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_ADDRESS2_TEXTBOX, address2);
	}

	public void inputToAddressPortalCodeTextbox(String portalCode) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_POSTAL_CODE_TEXTBOX, portalCode);
		
	}

	public void inputToAddressPhoneTextbox(String phone) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX, phone);
		
	}

	public void clickToAddressSaveButton() {
		waitToElementClickable(driver, UserCustomerInforPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, UserCustomerInforPageUI.ADDRESS_SAVE_BUTTON);
		
	}

	public void inputToAddressFaxTextbox(String fax) {
		waitToElementVisible(driver, UserCustomerInforPageUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.ADDRESS_FAX_NUMBER_TEXTBOX, fax);
		
	}

	public String getAddressFullnameValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.);
		return null;
	}

	public String getAddressFullnameValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressPhoneNumberValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressFaxNumberValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressCompanyValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressAddress1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressAddress2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressCityZip() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}







}
