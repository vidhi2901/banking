package MercuryTours_week4;

import org.testng.annotations.Test;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class scenario2_week4 {
	WebDriver driver;
	int count;
	Object[] a;
	
	
  @Test
  public void f() {
	  List<WebElement> all_links = driver.findElements(By.tagName("a"));
		 a = all_links.toArray();
		
		 count = 0;
		for (WebElement e : all_links) {							
			System.out.println("Link"+ count + "=" + e.getText());		
			count++;
      }
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
  public void afterMethod() {
	  System.out.println("Hi test");
	  
		System.out.println("Total number of links on the page:"+ a.length);
		
		if (count > 0 ) {
			System.out.println("\nLinks found, testcase passed");
		} else {
			System.out.println("\nLinks not found, testcase failed");
		}
		
		driver.close();
  }
  
}
