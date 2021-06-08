package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\podhuri\\OneDrive - Capgemini\\Desktop\\DRIVER\\chromedriver.exe");
		driver  = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
	}
	
	@Test(priority = 2)
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Rediffmail123", "Title is not getting matched");
	}
	
	@Test(priority = 1)
	public void logoTest() {
		Boolean b = driver.findElement(By.linkText("rediff.com")).isDisplayed();
		//System.out.println(b);
		Assert.assertTrue(b);//we are expecting true
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
