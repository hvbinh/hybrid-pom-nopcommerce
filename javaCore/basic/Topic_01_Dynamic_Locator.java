package basic;

public class Topic_01_Dynamic_Locator {

	public static void main(String[] args) {
		final String DYNAMIC_LOCATOR = "//a[text()='%s']";
		final String DYNAMIC_ERROR_MESSAGE = "//span[@id='%s-error']";
		
		clickToElement(DYNAMIC_ERROR_MESSAGE, "First name");
	}
	public static void clickToElement(String locator, String pageName)
	{
		locator = String.format(locator, pageName);
		System.out.println(locator);
		
	}

}
