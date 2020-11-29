package pageUIs;

public class AbstractPageUI {
	//4 locator
	public static final String MY_PRODUCT_REVIEWS_LINK = "//div[@class='listbox']//a[contains(.,'My product reviews')]"; 
	public static final String CUSTOMER_INFOR_LINK = "//div[@class='listbox']//a[contains(.,'Customer info')]";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[contains(.,'Addresses')]";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[contains(.,'Orders')]";
	
	//dynamic link
	public static final String DYNAMIC_ERROR_MESSAGE = "//span[@id='%s-error']";
	
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[contains(.,'%s')]";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']/span";
}
