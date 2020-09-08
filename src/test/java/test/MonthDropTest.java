package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class MonthDropTest {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Starts the browser and saves the driver in the test class
		driver = BrowserFactory.startBrowser();
	}

	@Test
	public void MonthDropDownList() throws InterruptedException {

//		On to the site
		driver.get("http://techfios.com/test/102/");

		String arr[] = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
//		WebElement monthlist = driver.findElement(By.xpath("//select[option='None'] [3]"));

		Select select = new Select(driver.findElement(By.xpath("//select[option='None'] [3]")));
		List<WebElement> dropdownvalues = select.getOptions();
		System.out.println(dropdownvalues.size());
	
		for (int i = 0; i < dropdownvalues.size(); i++) {
			Assert.assertEquals(arr[i], dropdownvalues.get(i).getText());
		}
		System.out.println("Dropdown list contains all the twelve months!!");

		
		 driver.close();
		 driver.quit();
	}
}
