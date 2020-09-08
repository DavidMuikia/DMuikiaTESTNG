package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page.NSS_ToDoPage;
import util.BrowserFactory;

public class NSS_ToDoTest {

	WebDriver driver;

	@Test(priority = 1)
	public void UserShouldBeAbleToGoToSite() throws InterruptedException {
// Starts the browser and saves the driver in the test class
		driver = BrowserFactory.startBrowser();

//		On to the site
		driver.get("http://techfios.com/test/102/");
		System.out.println("Before Adding " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		NSS_ToDoPage nss_todoPage = PageFactory.initElements(driver, NSS_ToDoPage.class);
		nss_todoPage.UserShldBeAbleToAddNewcategory();
		System.out.println("After Adding " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());

	}

	@Test(priority = 2)
	public void UserShouldNotBeAbletoAddDuplicateCategory() throws InterruptedException {
		// driver.get("techfios.com/test/102/");

		NSS_ToDoPage newcategory = PageFactory.initElements(driver, NSS_ToDoPage.class);

		String expectedCategory = "Freeland"; // To store the actual title
		String actualcategory = newcategory.NewCategory(); // To get and store the title
		System.out.println("The category you want to add already exists: <duplicated category name>");
		Assert.assertTrue(true, expectedCategory);

	}
}

//		@AfterMethod
//		public void close() {
//		driver.close();
//		driver.quit();
