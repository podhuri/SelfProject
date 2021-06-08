package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorChangeText {

	public static void main(String[] args) throws InterruptedException {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\podhuri\\OneDrive - Capgemini\\Desktop\\DRIVER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.get("https://classic.freecrm.com/index.html");
		//driver.findElement(By.name("username")).sendKeys("batchautomation ");
		//driver.findElement(By.name("password")).sendKeys("Test@12345");
		
		WebElement link = driver.findElement(By.linkText("Sign Up"));
		change(link,driver);
		
		
	}
	
	public static void change(WebElement locator,WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String signup = locator.getAttribute("text");
		Thread.sleep(10000);
		changeText("Log in",locator,driver);
		
		
		
	}
	public static void changeText(String text, WebElement locator,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].text= arguments[1];",locator,text);

	}
}
