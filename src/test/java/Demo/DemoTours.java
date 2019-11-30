package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DemoTours {
	WebDriver driver;
  @Test
  public void verifylogin() {
	  driver.findElement(By.name("userName")).sendKeys("tutorial");
	  driver.findElement(By.name("password")).sendKeys("tutorial");
	  driver.findElement(By.name("login")).click();
	  String ExpectedTitle="Find a Flight: Mercury Tours:";
	  
	  String ActualTitle=driver.getTitle();
	  
	  
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
  }
  @BeforeMethod
  public void setup() {
	  System.setProperty("webdriver.chrome.driver","/Users/vidhi/Drivers/chromedriver");
		 driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void teardown() {
	  driver.close();
	  
  }

}
