package MercuryTours_week4;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scenario1_week4Test {
	WebDriver driver;
	String user_name_attribute;
	String password_attribute;
  @Test
  public void f() {
	  user_name_attribute = driver.findElement(By.name("userName")).getAttribute("name");
	  password_attribute = driver.findElement(By.name("password")).getAttribute("name");

	  
  }
	  
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","/Users/vidhi/Drivers/chromedriver");
	  	driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
	  
  }
  @AfterMethod
  
	  public void aftermethod()
	  
	  {
		  System.out.println("The 'name' attribute of user_name field =" + user_name_attribute);	  
		  System.out.println("The 'name' attribute of password field =" + password_attribute);
		  driver.quit();
	  }
	  
	  
  }


  

