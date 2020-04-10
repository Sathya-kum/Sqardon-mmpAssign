package MMPprojectAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientLogin {
	
			WebDriver driver;
		 
		public PatientLogin(WebDriver driver)
		{
			
				  this.driver = driver;
				
		}
	    
		public void patientUrl(String url)
		{
		   driver.get(url);
		}
	   
	 //login 
	 	public boolean  login(String userName, String password) {

	 	driver.findElement(By.id("username")).sendKeys(userName);

	 	driver.findElement(By.id("password")).sendKeys(password);

	 	driver.findElement(By.name("submit")).click();

	 	return false;
	 	}

	 	
	 		
	 		
	}

	
	
	


