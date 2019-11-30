package banking;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Testcase001_VerifyLogin {
	
	WebDriver driver;
	@BeforeMethod
	  public void setup() {
		System.setProperty("webdriver.chrome.driver","/Users/vidhi/Drivers/chromedriver");
		 driver=new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	  }

  @Test
  public void verifyinglogin() {
	  driver.findElement(By.id("signin_button")).click();
	  driver.findElement(By.id("user_login")).sendKeys("usernajme");
	  driver.findElement(By.id("user_password")).sendKeys("password");
	  driver.findElement(By.name("submit")).click();
	  
	  String ExpectedTitle="Zero - Account Summary";
	  
	  String ActualTitle=driver.getTitle();
	  AssertJUnit.assertEquals(ActualTitle, ExpectedTitle);
  }
  
  @AfterMethod
 
	  public void teardown(ITestResult testResult) throws IOException {
		  if(testResult.getStatus() == ITestResult.FAILURE) 
		  {
			  utility.Screenshot.takeScreenshot(driver, testResult.getName());
			  
			  // calling class screenshot and two plugs is pkg 
		  }
	  driver.close();
	  
  }

}
