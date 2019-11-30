package MercuryTours_week4;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class sceanrio3_week4 {
	WebDriver driver;
	
  @Test
  public void f() {
	  String parent=driver.getWindowHandle();
		System.out.println("Parent Window is : "+ parent);
		/* Path of WOrk at TVO */
		driver.findElement(By.xpath("//*[@id=\"block-footer\"]/div/ul/li[2]/ul/li[3]/a")).click();
		
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,250)", "");
		
		/* Path of browse categories */
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/section/div/article/div/div/div/div[10]/div/div[2]/a")).click();
		
		Set<String> allWindows=driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("total count : "+ count);
		for(String child:allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				/*path of search box*/
				driver.findElement(By.id("SearchInput")).sendKeys("automation");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
			
				//driver.findElement(By.id("jsb_form_submit_i")).click();
				 String ExpectedTitle ="There were no opportunities matching your criteria.";
				  String ActualTitle =driver.getTitle();
				  
				  if (ActualTitle.equals(ExpectedTitle))
						  {
					  System.out.println("Test case is passed");
						  }

			}
		}
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","/Users/vidhi/Drivers/chromedriver");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.get("https://www.tvo.org");
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
  }

  @AfterMethod
  public void afterMethod() {
	  String ExpectedTitle ="My Job Search";
	 
	  
		
	  System.out.println("asfasdfasdf" + driver.getTitle());
		if (driver.getTitle().equals(ExpectedTitle)) {
			System.out.println("Succesful");
		} else {
			System.out.println("Fail");
		}
	  
  }

}
