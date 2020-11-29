package pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import pageFactory.AbstractPage;
import pageUIs.UserRegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//element
	@FindBy(id="gender-male")
	WebElement genderMailRadio;
	
	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTextbox;
	
	@FindBy(name="DateOfBirthDay")
	WebElement dayDropdown;
	
	@FindBy(name="DateOfBirthMonth")
	WebElement monthDropdown;
	
	@FindBy(name="DateOfBirthYear")
	WebElement yearDropdown;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Company")
	WebElement companyTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(id="Newsletter")
	WebElement newsLetterCheckbox;
	
	@FindBy(className ="result")
	WebElement registerSuccessMessage;
	
	@FindBy(className="ico-logout")
	WebElement logoutLink;
	
	//action
	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, genderMailRadio);
		clickToElement(driver, genderMailRadio);

	}

	public void inputToFirstnameTextBox(String firstName) {
		waitToElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);

	}

	public void inputToLastnameTextBox(String lastName) {
		waitToElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);

	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, dayDropdown);
		selectItemInDropdown(driver, dayDropdown, day);

	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, monthDropdown);
		selectItemInDropdown(driver, monthDropdown, month);

	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, yearDropdown);
		selectItemInDropdown(driver, yearDropdown, year);

	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);

	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, companyTextbox);
		sendkeyToElement(driver, companyTextbox, companyName);

	}

	public void inputToPasswordTextbox(String pass) {
		waitToElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, pass);

	}

	public void inputToConfirmPasswordTextbox(String pass) {
		waitToElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, pass);

	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getRegisteredSuccessMessage() {
		waitToElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitToElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

}
