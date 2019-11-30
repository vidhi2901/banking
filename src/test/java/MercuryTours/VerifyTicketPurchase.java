package MercuryTours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class VerifyTicketPurchase {
	WebDriver driver;
	
	 @BeforeMethod
	  public void setup() {
		 System.setProperty("webdriver.chrome.driver","/Users/vidhi/Drivers/chromedriver");
		 driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
	  
	 
  @Test
  public void verifyTicketPurchase() {
	  
	  driver.findElement(By.name("userName")).sendKeys("tutorial");
	  driver.findElement(By.name("password")).sendKeys("tutorial");
	  driver.findElement(By.name("login")).click();
	//  driver.findElement((By.xpath(("//input[@value="oneway"]"));
	  //driver.findElement((By.cssSelector("input[value='oneway']")).click();
	  

	  
	  
  }

  
 

  @AfterMethod
  public void teardown() {
	  driver.quit();
  }

}
