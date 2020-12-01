package pageObjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.AdminLoginPageUI;
import pageUIs.AdminProductPageUI;

public class AdminProductPO extends AbstractPage{

	WebDriver driver;
	
	
	public AdminProductPO(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public void goToPageAtTableByIndex(String indexPage) {
		waitToElementClickable(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX,indexPage);
		clickToElement(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX,indexPage);
		
	}


	public boolean isPageActiveAtTableByIndex(String indexPage) {
		waitToElementVisible(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX,indexPage);
		return isElementDisplayed(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX,indexPage);
		
	}


	public void checkToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);	
		
	}


	public void uncheckToselectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);	
		
	}


	public void areProductCheckboxChecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		for(WebElement productCheckbox : allProductCheckboxes)
		{
			Assert.assertTrue(productCheckbox.isSelected());
		}
		waitAjaxLoadingInvisible(driver);
		
	}


	public void areProductCheckboxUnchecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		for(WebElement productCheckbox : allProductCheckboxes)
		{
			Assert.assertFalse(productCheckbox.isSelected());
		}
		waitAjaxLoadingInvisible(driver);
	}


	public void checkToProductCheckboxByName(String nameProduct) {
		waitToElementClickable(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME,nameProduct);
		checkToCheckbox(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME,nameProduct);
		waitAjaxLoadingInvisible(driver);
		
	}


	public boolean areProductDetailsDisplayed(String productName, String skuID, String price, String quantity, String productType, String publishSatus)  {
		waitAjaxLoadingInvisible(driver);
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName,skuID,price,quantity,productType,publishSatus);
		
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE,productName,skuID,price,quantity,productType,publishSatus);
	}


	public void selectShowNumberDropdown(String itemNumber) {
		waitToElementClickable(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN, itemNumber);
		waitAjaxLoadingInvisible(driver);
		
	}


	public boolean isInformationDisplayedAtColumnnameRowNumber(String columnName, String rowIndex, String expectedValue) {
		//index of column
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName) + 1;
		String actualResult = getElementText(driver, AdminProductPageUI.CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex,String.valueOf(columnNameIndex));
		return actualResult.equals(expectedValue);
	}
	public boolean isPublishStatusAtColumnnameAndRowNumber(String columnName, String rowIndex, String publishStatus) {
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName) + 1;
		return isElementDisplayed(driver, AdminProductPageUI.PUBLISH_STATUS_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex,String.valueOf(columnNameIndex),publishStatus);
	}


	public void clickToProductDetailByName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
		waitAjaxLoadingInvisible(driver);
	}





	

		
	


	
	
}