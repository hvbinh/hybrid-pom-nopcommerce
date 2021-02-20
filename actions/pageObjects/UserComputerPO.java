package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.UserComputerPageUI;
import pageUIs.UserProductDetailPageUI;

public class UserComputerPO extends AbstractPage{
	WebDriver driver;

	
	public UserComputerPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickAddToCompareListButtonByHrefProduct(String hrefProduct) {
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_BY_HREF, hrefProduct);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON_BY_HREF, hrefProduct);
	}

	public void closeNotificationSuccessMessage() {
		waitToElementClickable(driver, UserComputerPageUI.NOTIFICATION_CLOSE_BUTTON);
		clickToElement(driver, UserComputerPageUI.NOTIFICATION_CLOSE_BUTTON);
	}

	public UserCompareProductPO clickToCompareProductListFooterLink() {
		waitToElementClickable(driver, UserComputerPageUI.COMPARE_PRODUCT_LIST_FOOTER_LINK);
		clickToElement(driver, UserComputerPageUI.COMPARE_PRODUCT_LIST_FOOTER_LINK);
		return PageGeneratorManager.getUserCompareProductPO(driver);
	}

	public boolean notificationSuccessMessageDisplay() {
		waitToElementVisible(driver, UserComputerPageUI.NOTIFICATION_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserComputerPageUI.NOTIFICATION_SUCCESS_MESSAGE);
	}

	public UserProductDetailPO clickToProductNameByHref(String href) {
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_PRODUCT_NAME_BY_HREF, href, href);
		return PageGeneratorManager.getUserProductDetailPO(driver);
	}

	public UserRecentlyViewedProductPO clickToRerentlyViewedProductPage() {
		waitToElementClickable(driver, UserComputerPageUI.RECENTLY_VIEWED_PRODUCT_FOOTER_LINK);
		clickToElement(driver, UserComputerPageUI.RECENTLY_VIEWED_PRODUCT_FOOTER_LINK);
		return PageGeneratorManager.getUserRecentlyViewedProductPO(driver);
	}

	public void selectProcessorByName(String dropdownName,String itemValue) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName); 
		selectDropdownByName(driver, dropdownName, itemValue);
		
	}

	public void selectRAMByName(String dropdownName,String itemValue) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName); 
		selectDropdownByName(driver, dropdownName, itemValue);
		
	}

	public void selectHDDRadioByLabel(String hddName) {
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_HDD_RADIO,hddName);
		clickToElement(driver, UserComputerPageUI.DYNAMIC_HDD_RADIO,hddName);
	}

	public void selectOS(String osName) {
		waitToElementClickable(driver, UserComputerPageUI.OS_VISTA_PREMIUM_RADIO,osName);
		clickToElement(driver, UserComputerPageUI.OS_VISTA_PREMIUM_RADIO,osName);
	}

	public void selectAllSoftware(String msOffice,String acrobatReader, String totalCommander) {
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,msOffice);
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,acrobatReader);
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,totalCommander);
		WebElement element = getElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL, msOffice);
		if(!element.isSelected())
		{
			clickToElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,msOffice);
		}
		element = getElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL, acrobatReader);
		if(!element.isSelected())
		{
			clickToElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,acrobatReader);
		}
		element = getElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL, totalCommander);
		if(!element.isSelected())
		{
			clickToElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,totalCommander);
		}
	}
	public void selectOneSoftware(String msOffice,String acrobatReader, String totalCommander) {
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,msOffice);
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,acrobatReader);
		waitToElementClickable(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,totalCommander);
		WebElement element = getElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL, msOffice);
		if(!element.isSelected())
		{
			clickToElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,msOffice);
		}
		element = getElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL, acrobatReader);
		if(element.isSelected())
		{
			clickToElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,acrobatReader);
		}
		element = getElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL, totalCommander);
		if(element.isSelected())
		{
			clickToElement(driver, UserComputerPageUI.DYNAMIC_CHECKBOX_BY_LABEL,totalCommander);
		}
		
	}

	public void clicAddToCartButton() {
		waitToElementClickable(driver, UserComputerPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserComputerPageUI.ADD_TO_CART_BUTTON);
	}

	public boolean notificationSuccessDisplays() {
		waitToElementVisible(driver, UserComputerPageUI.NOTIFICATION_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserComputerPageUI.NOTIFICATION_SUCCESS_MESSAGE);
	}

	public void closeNotificationSuccess() {
		waitToElementVisible(driver, UserComputerPageUI.NOTIFICATION_CLOSE_BUTTON);
		clickToElement(driver, UserComputerPageUI.NOTIFICATION_CLOSE_BUTTON);
		
	}

	public void hoverMouseToShoppingCartMenu() {
		waitToElementVisible(driver, UserComputerPageUI.SHOPPING_CART_HEADER_MENU);
		hoverMouseToElement(driver, UserComputerPageUI.SHOPPING_CART_HEADER_MENU);
	}

	public String getProductTitleInShoppingCart() {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_TITLE_TEXT);
		return getElementText(driver, UserComputerPageUI.PRODUCT_TITLE_TEXT);
	}

	public boolean processorDisplay(String processor) {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		WebElement element = getElement(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		return element.getText().contains(processor);
	}

	public boolean RAMDisplay(String RAM) {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		WebElement element = getElement(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		return element.getText().contains(RAM);
	}

	public boolean HDDDisplay(String HDD) {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		WebElement element = getElement(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		return element.getText().contains(HDD);
	}

	public boolean OSDisplay(String OS) {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		WebElement element = getElement(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		return element.getText().contains(OS);
	}

	public boolean softwareDisplay(String software) {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		WebElement element = getElement(driver, UserComputerPageUI.PRODUCT_ATTRIBUTE_TEXT);
		return element.getText().contains(software);
	}

	public boolean priceDisplay(String price) {
		waitToElementVisible(driver, UserComputerPageUI.TOTAL_PRICE_IN_SHOPPING_CART);
		WebElement element = getElement(driver, UserComputerPageUI.TOTAL_PRICE_IN_SHOPPING_CART);
		return element.getText().contains(price);
	}

	public UserShoppingCartPO clickOnShoppingCartLink() {
		waitToElementClickable(driver, UserComputerPageUI.SHOPPING_CART_HEADER_MENU);
		clickToElement(driver, UserComputerPageUI.SHOPPING_CART_HEADER_MENU);
		return PageGeneratorManager.getUserShoppingCartPO(driver);
	}

	public void updateQuantity(String quantity) {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_QUANTITY);
		sendkeyToElement(driver, UserComputerPageUI.PRODUCT_QUANTITY, quantity);
	}

	public void clickToUpdateButton() {
		waitToElementClickable(driver, UserComputerPageUI.UPDATE_BUTTON);
		clickToElement(driver, UserComputerPageUI.UPDATE_BUTTON);
	}

	public String getProductPrice() {
		waitToElementVisible(driver, UserComputerPageUI.PRODUCT_PRICE);
		return getElementText(driver, UserComputerPageUI.PRODUCT_PRICE);
	}





}
