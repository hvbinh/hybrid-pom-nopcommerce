package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserHomePO getUserHomePage(WebDriver driver)
	{
		return new UserHomePO(driver);
	}
	public static UserLoginPO getUserLoginPage(WebDriver driver)
	{
		return new UserLoginPO(driver);
	}
	public static UserCustomerInforPO getUserCustomerInforPage(WebDriver driver)
	{
		return new UserCustomerInforPO(driver);
	}
	public static UserRegisterPO getUserRegisterPage(WebDriver driver)
	{
		return new UserRegisterPO(driver);
	}
	public static UserAddressesPO getUserAddressesPage(WebDriver driver)
	{
		return new UserAddressesPO(driver);
	}
	public static UserOrdersPO getUserOrdersPage(WebDriver driver)
	{
		return new UserOrdersPO(driver);
	}
	public static UserMyProductReviewsPO getUserMyProductReviewsPage(WebDriver driver)
	{
		return new UserMyProductReviewsPO(driver);
	}
	public static AdminLoginPO getAdminLoginPage(WebDriver driver)
	{
		return new AdminLoginPO(driver);
	}
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver)
	{
		return new AdminDashboardPO(driver);
	}
	public static AdminProductPO getAdminProductPage(WebDriver driver)
	{
		return new AdminProductPO(driver);
	}

}
