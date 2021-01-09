package pageUIs;

public class AbstractPageUI {
	//4 locator
	public static final String MY_PRODUCT_REVIEWS_LINK = "//div[@class='listbox']//a[contains(.,'My product reviews')]"; 
	public static final String CUSTOMER_INFOR_LINK = "//div[@class='listbox']//a[contains(.,'Customer info')]";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[contains(.,'Addresses')]";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[contains(.,'Orders')]";
	
	//dynamic link
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "//span[@class='field-validation-error']/span[@id='%s-error']";
	
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[contains(.,'%s')]";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String UPLOAD_FILE_TYPE_BY_PANEL = "//div[@id='%s']//input[@type='file']";
	public static final String PLUS_ICON_PANEL = "//div[@id='%s']//i[contains(@class,'toggle-icon')]";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='gender-%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	
}
