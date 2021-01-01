package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public boolean getProductsResult(String value) {
		List<WebElement> list = getElements(driver, UserSearchPageUI.LIST_PRODUCT_RETURN);
		for(WebElement e : list)
		{
			if(e.getText().equals(value))
			{
				return true;
			}
		}
		return false;
	}

	public void checkToAdvanceSearchCheckbox() {
		waitToElementClickable(driver, UserSearchPageUI.SEARCH_ADV_CHECKBOX);
		checkToCheckbox(driver, UserSearchPageUI.SEARCH_ADV_CHECKBOX);
		
	}

	public void selectCategory(String itemValue) {
		waitToElementClickable(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.CATEGORY_DROPDOWN, itemValue);
	}

	public void uncheckSubCategoryCheckbox() {
		waitToElementClickable(driver, UserSearchPageUI.SUB_CATEGORY_CHECBOX);
		uncheckToCheckbox(driver, UserSearchPageUI.SUB_CATEGORY_CHECBOX);
	}

	public void checkSubCategoryCheckbox() {
		waitToElementClickable(driver, UserSearchPageUI.SUB_CATEGORY_CHECBOX);
		checkToCheckbox(driver, UserSearchPageUI.SUB_CATEGORY_CHECBOX);
	}

	public void selectManufacturer(String itemValue) {
		waitToElementClickable(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN, itemValue);
	}

	public void inputToFromPriceTextbox(String value) {
		waitToElementVisible(driver, UserSearchPageUI.FROM_PRICE_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.FROM_PRICE_TEXTBOX, value);
	}

	public void inputToToPriceTextbox(String value) {
		waitToElementVisible(driver, UserSearchPageUI.TO_PRICE_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.TO_PRICE_TEXTBOX, value);
	}
	

}
