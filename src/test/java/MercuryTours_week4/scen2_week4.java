package MercuryTours_week4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class scen2_week4 {

	WebDriver driver;

	@Test
	public void AddPayee() {
		System.out.println("First line of AddPayee");
		driver.findElement(By.id("signin_button")).click();
		//driver.findElement(By.className("signin btn btn-info")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Pay Bills')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Add New Payee')]")).click();
		driver.findElement(By.id("np_new_payee_name")).sendKeys("HydroOne Utility");
		driver.findElement(By.id("np_new_payee_address")).sendKeys("200 RoberSpec Pkwy, Mississauga, ON L6R1K9");
		driver.findElement(By.id("np_new_payee_account")).sendKeys("123234434");
		driver.findElement(By.id("np_new_payee_details")).sendKeys("Natural Gas Utility");
		driver.findElement(By.id("add_new_payee")).click();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void VerifyLogin() {
		System.setProperty("webdriver.chrome.driver", "/Users/vidhi/Drivers/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://zero.webappsecurity.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closer() {
		driver.quit();
		/*
		 * System.out.println("In closer.."); String ExpectedTitle =
		 * "The new payee HydroOne Utility was successfully created.";
		 * 
		 * //String ActualTitle = driver.getTitle(); System.out.println("asfasdfasdf" +
		 * driver.getTitle()); if (driver.getTitle().equals(ExpectedTitle)) {
		 * System.out.println("Succesful"); } else { System.out.println("Fail"); }
		 */
	}

}
