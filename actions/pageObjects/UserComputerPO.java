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
		waitToElementClickable(driver, UserComputerPageUI.HDD_400_GB_RADIO,hddName);
		clickToElement(driver, UserComputerPageUI.HDD_400_GB_RADIO,hddName);
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

	public void clicAddToCartButton() {
		// TODO Auto-generated method stub
		
	}





}
