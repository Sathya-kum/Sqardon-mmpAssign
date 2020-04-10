package MMPprojectAssignment;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PatientFeesPage {

	WebDriver driver;

	public PatientFeesPage(WebDriver driver) {
		this.driver = driver;

	}

	public void outstandigFee() throws Exception {
		// Click Fees
		WebElement fees = driver.findElement(By.xpath("//span[contains(text(),'Fees')]"));
		fees.click();

		// Otstanding balance Tittle
		WebElement oSBalance = driver.findElement(By.xpath(" //p[contains(text(),'Your Outstanding Balance')]"));
		oSBalance.getText();
		System.out.println(oSBalance.getText());
		Thread.sleep(3000);

		// get text
		// WebElement amount =
		// driver.findElement(By.xpath("//p[contains(text(),'$188')]"));
		// amount.getText();
		// System.out.println(amount.getText());

		// get all the text form the list
		List<WebElement> balances = driver.findElements(By.xpath("//div[@class='panel-body nopadding']//li"));
		// int sum = 0;
		System.out.println(balances.size());

		for (WebElement fee : balances) {
			String text = fee.getText();
			System.out.println(text);

		}
		Thread.sleep(5000);

		// Click Pay Now Link
		WebElement payNow = driver.findElement(By.linkText("Pay Now"));
		payNow.click();

	}

	public void payNow() throws Exception {

		// Otstanding balance Tittle
		WebElement oSBalance = driver.findElement(By.xpath(" //p[contains(text(),'Your Outstanding Balance')]"));
		oSBalance.getText();
		System.out.println(oSBalance.getText());
		Thread.sleep(3000);

		// get text
		// WebElement amount =
		// driver.findElement(By.xpath("//p[contains(text(),'$188')]"));
		// amount.getText();
		// System.out.println(amount.getText());

		// get all the text form the list
		List<WebElement> balances = driver.findElements(By.xpath("//div[@class='panel-body nopadding']//li"));
		System.out.println(balances.size());
		for (int i = 0; i < balances.size(); i++) {
			System.out.println("The size of i " + balances.get(i).getText());
		}
		Thread.sleep(3000);

		// Click paynow button
		Select pay = new Select(driver.findElement(By.id("amount")));
		pay.selectByIndex(2);
		Thread.sleep(5000);

		// Click Continue button
		WebElement con = driver.findElement(By.xpath(" //input[@value='Continue']"));
		con.click();

	}

	public void cardDetails() throws Exception {

		// Enter firstname and last name
		WebElement fLname = driver.findElement(By.id("name"));
		fLname.sendKeys("summer Ben");

		// Select card from drop down
		Select card = new Select(driver.findElement(By.id("card_name")));
		List<WebElement> elementCount = card.getOptions();
		System.out.println(elementCount.size());
		card.selectByVisibleText("Visa");
		Thread.sleep(3000);

		// Enter card number
		WebElement cardNumber = driver.findElement(By.id("cid"));
		cardNumber.sendKeys("4242424242424242");
		Thread.sleep(3000);

		// Select Month expiration from drop down
		Select expMonth = new Select(driver.findElement(By.id("cardMonth")));
		expMonth.selectByVisibleText("March (03)");

		// Select year expiration from drop down
		Select expYear = new Select(driver.findElement(By.id("cardYear")));
		expYear.selectByVisibleText("2023");

		// Enter the CVV number
		WebElement cvv = driver.findElement(By.id("cvv"));
		cvv.sendKeys("123");

		// Click Submit Button
		// WebElement submit = driver.findElement(By.id("cvv"));
		// submit.click();

		// Click Log out
		// WebElement logOut =
		// driver.findElement(By.id("//span[contains(text(),'Logout')"));
		// logOut.click();

	}
}
