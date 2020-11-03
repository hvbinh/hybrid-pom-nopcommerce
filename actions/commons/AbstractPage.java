package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	public void openPageUrl(WebDriver driver,String url)
	{
		driver.get(url);
	}
	public String getCurrentPageUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	public String getCurrentPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	public String getCurrentPageSource(WebDriver driver)
	{
		return driver.getPageSource();
	}
	public void backToPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void forwardToPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void refreshCurrentPage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String getTextlAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void setTextlAlert(WebDriver driver,String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	public void waitAlertPresence(WebDriver driver)
	{
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void swithToWindowById(WebDriver driver,String parentID)
	{
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows)
		{
			if(!runWindow.equals(parentID))
			{
				driver.switchTo().window(runWindow);
				break;
			}
		}
		
	}
	public boolean closeAllWindowsWithoutParent(WebDriver driver,String idParent) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String runWindow : allWindows) {

			if (!runWindow.equals(idParent)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(idParent);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToWindowByTitle(WebDriver driver,String title) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentTitle = driver.getTitle();
			if (currentTitle.trim().equals(title)) {
				break;
			}
		}
	}
	public WebElement getElement(WebDriver driver, String locator)
	{
		return driver.findElement(getByXpath(locator));
	}
	public List<WebElement> getElements(WebDriver driver, String locator)
	{
		return driver.findElements(getByXpath(locator));
	}
	public void clickToElement(WebDriver driver, String locator)
	{
		WebElement element = getElement(driver,locator);
		element.click();
	}
	public void sendkeyToElement(WebDriver driver, String locator, String value)
	{
		WebElement element = getElement(driver,locator);
		element.clear();
		element.sendKeys(value);
	}
	public By getByXpath(String locator)
	{
		return By.xpath(locator);
	}
	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue)
	{
		WebElement element = getElement(driver,locator);
		Select select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	public String getFirstSelectedTextInDropDown(WebDriver driver, String locator)
	{
		WebElement element = getElement(driver,locator);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMultiple(WebDriver driver, String locator)
	{
		WebElement element = getElement(driver,locator);
		Select select = new Select(element);
		return select.isMultiple();
	}
	public void selectTheItemInCustomeDropdown(WebDriver driver,String parentXpath, String childXpath, String expectedText) {

		getElement(driver,parentXpath).click();;
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));

		List<WebElement> childItems = getElements(driver, childXpath);

		for (WebElement actualItem : childItems) {
			System.out.println("actual: "+actualItem.getText());
			if (actualItem.getText().trim().equals(expectedText)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", actualItem);
				sleepInSecond(1);
				actualItem.click();
				sleepInSecond(1);
				break;
			}
		}

	}
	public void sleepInSecond(long second) {

		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	public String getElementAtribute(WebDriver driver, String locator, String attributeName)
	{
		WebElement element = getElement(driver,locator);
		return element.getAttribute(attributeName);
	}
	public String getElementText(WebDriver driver, String locator)
	{
		WebElement element = getElement(driver,locator);
		return element.getText();
	}
	public int countElementSize(WebDriver driver, String locator)
	{
		return getElements(driver, locator).size();
	}
	public void checkToCheckbox(WebDriver driver, String locator)
	{
		WebElement element = getElement(driver,locator);
		if(!element.isSelected())
		{
			element.click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver, String locator)
	{
		WebElement element = getElement(driver,locator);
		if(element.isSelected())
		{
			element.click();
		}
	}
	public boolean isElementDisplayed(WebDriver driver, String locator)
	{
		return getElement(driver,locator).isDisplayed();
	}
	public boolean isElementEnabled(WebDriver driver, String locator)
	{
		return getElement(driver,locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver, String locator)
	{
		return getElement(driver,locator).isSelected();
	}
	public void swithToFrame(WebDriver driver, String locator)
	{
		driver.switchTo().frame(getElement(driver,locator));
	}
	public void swithToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}



}
