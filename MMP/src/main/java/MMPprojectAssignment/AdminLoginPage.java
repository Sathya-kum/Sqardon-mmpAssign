package MMPprojectAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {

	WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void adminLogin(String username, String password) {

		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys(username);
		WebElement passw = driver.findElement(By.id("password"));
		passw.sendKeys(password);
		WebElement sign = driver.findElement(By.xpath("//input[@name='admin']"));
		sign.click();

	}

	public void intialStepLogin() throws Exception {
		// officelogin.click();
		WebElement officelogin = driver.findElement(By.xpath("//a[contains(text(),'Office Login')]"));
		officelogin.click();
		Thread.sleep(3000);

		// Click the login Button
		WebElement login = driver.findElement(By.xpath("//div[@id='welcome']//a[text()='Login']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", login);
		Thread.sleep(3000);
	}

}
