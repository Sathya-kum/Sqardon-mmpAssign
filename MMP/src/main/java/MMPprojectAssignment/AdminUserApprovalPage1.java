package MMPprojectAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminUserApprovalPage1 {

	WebDriver driver;
	// WebDriver driver = new ChromeDriver();

	public AdminUserApprovalPage1(WebDriver driver) {
		this.driver = driver;

	}

	public void clickUser_Approval() throws Exception {
		// Click the user Tab from the Menu
		WebElement us = driver.findElement(By.xpath("//span[contains(text(),' Users')]"));
		us.click();

		WebElement pending = driver.findElement(By.xpath("//option[contains(text(),'Pending')]"));
		pending.click();

	}

	public void userApproval(String name) throws Exception {

		// Select the status from the status drop down list
		Select pending1 = new Select(driver.findElement(By.id("search")));
		pending1.selectByVisibleText("Pending");
		Thread.sleep(2000);

		// Click-Name in the table
		WebElement wName = driver.findElement(By.linkText(name));
		wName.click();

		// Select the status from the drop down
		Select approve = new Select(driver.findElement(By.id("sapproval")));
		approve.selectByVisibleText("Accepted");
		Thread.sleep(2000);

		// Click Submit button
		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
		submit.click();

		// Click -Popup button
		driver.switchTo().alert().accept();

	}

}
