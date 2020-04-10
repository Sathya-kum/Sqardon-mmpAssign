package MMpprojectAssignmentTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import MMPprojectAssignment.AdminCreateFee;
import MMPprojectAssignment.AdminLoginPage;
import MMPprojectAssignment.AdminUserApprovalPage1;
import MMPprojectAssignment.PatientFeesPage;
import MMPprojectAssignment.PatientLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminUserapprovalTest {

	WebDriver driver;

	@Test
	public void userApproval() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// get the URL
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");

		// instaniate the admin login page
		AdminLoginPage ap = new AdminLoginPage(driver);

		// call the admin Login method,intialsteplogin
		ap.intialStepLogin();
		ap.adminLogin("Thomas_444", "Edison_444");
		Thread.sleep(5000);
		// ap.userClick();

		AdminUserApprovalPage1 ap1 = new AdminUserApprovalPage1(driver);
		ap1.clickUser_Approval();

		// instantiate the user approval page and calling
		AdminCreateFee cf = new AdminCreateFee(driver);

		// list
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='show']//tr/td"));
		System.out.println(li.size());
		for (int i = 0; i < li.size();) {
			if (!li.equals("summer")) {
				break;
			} else {
				ap1.userApproval("summer");
				break;
			}

		}
		// call the method
		cf.adminSearchPatient();
		Thread.sleep(3000);
		cf.createFee("vaccination");

		// profile login
		PatientLogin pL = new PatientLogin(driver);
		pL.patientUrl("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		pL.login("summer", "Test123@");

		// instantiate the patientfee page and calling
		// the outstandingFee, payNow and cardDetails method
		PatientFeesPage pF = new PatientFeesPage(driver);
		pF.outstandigFee();
		pF.payNow();
		pF.cardDetails();

	}

}
