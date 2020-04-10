package MMPprojectAssignment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminCreateFee {

	WebDriver driver;

	public AdminCreateFee(WebDriver driver) {
		this.driver = driver;

	}

	public void adminSearchPatient() throws Exception {
		String name ="summer";
		// Click the patients tab in the menu
		WebElement patient = driver.findElement(By.xpath("//span[contains(text(),'Patients')]"));
		patient.click();

		// Enter the SSN or name in the text box,Search for patient by
		WebElement name1 = driver.findElement(By.id("search"));
		name1.sendKeys(name);
		Thread.sleep(3000);

		// click Search button
		WebElement search = driver.findElement(By.xpath("//input[@value ='search']"));
		search.click();
		Thread.sleep(3000);

		// click the link under the Name Column
		WebElement cl = driver.findElement(By.xpath("//td/a[contains(text(),'"+name+"')]"));
		cl.click();
		Thread.sleep(3000);
	}

	public void createFee(String service) throws Exception {

		// Click the CreateFee button
		WebElement fee = driver.findElement(By.xpath("//input[@value='Create Fee']"));
		fee.click();

		// click the select Appointments date from the dropdown
		Select date1 = new Select(driver.findElement(By.id("app_date")));
		date1.selectByIndex(2);
		Thread.sleep(5000);

		// Select service from drop down
		Select ser = new Select(driver.findElement(By.id("service")));
		ser.selectByVisibleText(service);
		Thread.sleep(5000);

		// Click submit button
		WebElement submit = driver.findElement(By.xpath("//input[@value='submit']"));
		submit.click();

		// Click Popup button
		driver.switchTo().alert().accept();

		// Admin Logout
		WebElement logout = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
		logout.click();

	}

}
